package io.github.eiot.utils;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.VoidType;
import io.github.eiot.annotation.FrameField;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * created by wang007 on 2025/5/23
 */
public class FrameDataGenerate {

    public static void main(String[] args) throws FileNotFoundException {

        JavaParser parser = new JavaParser();
        ParseResult<CompilationUnit> parseResult = parser.parse(new File("/Users/wangzhancheng/IdeaProjects/e-iot/eiot-ykc/src/main/java/io/github/eiot/charge/ykc/data/YkcBmsChargingData.java"));
        CompilationUnit unit = parseResult.getResult().orElse(null);
        if (unit == null) {
            return;
        }
        TypeDeclaration<?> classType = unit.getPrimaryType().orElse(null);
        if (classType == null) {
            return;
        }
        if (!classType.isAnnotationPresent("Frame")) {
            // Not frame type class. skip
            return;
        }

        List<FrameFieldDeclaration> fdList = new ArrayList<>();

        List<FieldDeclaration> fields = classType.getFields();
        for (FieldDeclaration field : fields) {
            FrameFieldDeclaration fd = new FrameFieldDeclaration();
            fd.simpleTypeName = field.getElementType().toString();
            fd.name = field.getVariable(0).getNameAsString();

            NormalAnnotationExpr annotationExpr = (NormalAnnotationExpr) field.getAnnotationByName("FrameField").orElse(null);
            if (annotationExpr != null) {
                FrameFieldAnnotation annotation = new FrameFieldAnnotation();
                for (MemberValuePair pair : annotationExpr.getPairs()) {
                    String name = pair.getName().asString();
                    String v = pair.getValue().toString();
                    switch (name) {
                        case "len":
                            annotation.len = Integer.parseInt(v);
                            break;
                        case "unit":
                            annotation.unit = Integer.parseInt(v);
                            break;
                        case "offset":
                            annotation.offset = Integer.parseInt(v);
                            break;
                        case "offsetReverse":
                            annotation.offsetReverse = Boolean.parseBoolean(v);
                            break;
                    }
                }
                fd.frameFieldAnnotation = annotation;
            }

            fdList.add(fd);
        }

        for (FrameFieldDeclaration frameFieldDeclaration : fdList) {
            toGenerateGetterAndSetter(frameFieldDeclaration);
        }
    }

    private static void toGenerateGetterAndSetter(FrameFieldDeclaration fd) {
        MethodDeclaration getterMd = new MethodDeclaration();
        getterMd.setPublic(true);
        getterMd.setType(new ClassOrInterfaceType(fd.simpleTypeName));
        getterMd.setName("get" + fd.name.substring(0, 1).toUpperCase() + fd.name.substring(1));
        BlockStmt getterBody = new BlockStmt();
        getterBody.addStatement("return " + fd.name + "");
        getterMd.setBody(getterBody);

        MethodDeclaration setterMd = new MethodDeclaration();
        setterMd.setPublic(true);
        setterMd.setType(new VoidType());
        setterMd.setName("set" + fd.name.substring(0, 1).toUpperCase() + fd.name.substring(1));
        setterMd.addParameter(new Parameter(new ClassOrInterfaceType(fd.simpleTypeName), fd.name));
        BlockStmt setterBody = new BlockStmt();
        setterBody.addStatement("return this." + fd.name + " = " + fd.name + "");
        setterMd.setBody(setterBody);

        FrameFieldAnnotation an = fd.frameFieldAnnotation;
        if (an == null) {
            return;
        }

        MethodDeclaration setterMd0 = new MethodDeclaration();
        setterMd0.setPublic(true);
        setterMd0.setName("set" + fd.name.substring(0, 1).toUpperCase() + fd.name.substring(1));
        setterMd0.setType(new VoidType());
        switch (fd.simpleTypeName) {
            case "Ascii":
            case "BCD":
            case "Hex":
                setterMd0.addParameter(new Parameter(new ClassOrInterfaceType("String"), fd.name));
                BlockStmt setterBody0 = new BlockStmt();
                int len = an.len;
                if (fd.simpleTypeName.equals("BCD") || fd.simpleTypeName.equals("Hex")) {
                    len = len * 2;
                }
                setterBody0.addStatement(ValidationUtil.class.getName() + ".lteLen(" + fd.name + ", " + len + ", " + fd.name + ")");
                if (fd.simpleTypeName.equals("Ascii")) {
                    setterBody0.addStatement("this." + fd.name + " = Ascii.from(" + fd.name + ", " + len + ")");
                } else if (fd.simpleTypeName.equals("BCD")) {
                    setterBody0.addStatement("this." + fd.name + " = BCD.from(" + fd.name + ", " + len + ")");
                } else if(fd.simpleTypeName.equals("Hex")) {
                    setterBody0.addStatement("this." + fd.name + " = Hex.from(" + fd.name + ", " + len + ")");
                }
        }


        StringBuilder text = new StringBuilder();
        // normal getter;
        text.append("    public " + fd.simpleTypeName + " get" + fd.name.substring(0, 1).toUpperCase() + fd.name.substring(1) + "() {\r\n");
        text.append("        return " + fd.name + ";\n");
        text.append("    }\n");
        text.append(" \r\n");

        // normal setter;
        text.append("    public void set" + fd.name.substring(0, 1).toUpperCase() + fd.name.substring(1) + "(" + fd.simpleTypeName + " " + fd.name + ") {\n");
        text.append("        return this." + fd.name + " = " + fd.name + "\n");
        text.append("    }\n");
        text.append(" \r\n");
        //System.out.println(text.toString());
    }


    private static class FrameFieldDeclaration {

        /**
         * field type
         */
        public String simpleTypeName;

        /**
         * field name
         */
        public String name;

        /**
         * {@link FrameField} on field
         */
        public FrameFieldAnnotation frameFieldAnnotation;

    }

    private static class FrameFieldAnnotation {

        public int len;

        public int unit = 1;

        public int offset;

        public boolean offsetReverse;


    }
}
