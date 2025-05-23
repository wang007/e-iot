package io.github.eiot.utils;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;

import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.ast.type.VoidType;
import io.github.eiot.annotation.FrameField;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * created by wang007 on 2025/5/23
 */
public class FrameDataGenerate {

    /**
     * parse java file and generate getter and setter for directory
     *
     * @param javaFileDir java file directory
     */
    public static void parseAndGenSelfFiles(String javaFileDir) {
        File file = new File(javaFileDir);
        if (!file.exists() || !file.isDirectory()) {
            return;
        }
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                parseAndGenSelfFiles(javaFileDir);
                continue;
            }
            String name = f.getName();
            if (!name.endsWith(".java")) {
                continue;
            }
            if (name.equals("package-info.java")) {
                continue;
            }
            parseAndGenSelfFile(f.getAbsolutePath());
        }
    }

    /**
     * parse java file and generate getter and setter
     *
     * @param javaFilePath java file, only field and not getter and setter
     */
    public static void parseAndGenSelfFile(String javaFilePath) {
        CompilationUnit unit = parseAndGenIntoGetterSetter(javaFilePath);
        if (unit == null) {
            return;
        }
        try {
            String s = unit.toString();
            FileWriter fileWriter = new FileWriter(javaFilePath);
            fileWriter.write(s);
            fileWriter.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * @param javaFilePath java file, only field and not getter and setter
     * @return return null if nto present @Frame
     */
    public static CompilationUnit parseAndGenIntoGetterSetter(String javaFilePath) {
        ParserConfiguration config = new ParserConfiguration()
                .setStoreTokens(true)
                .setLexicalPreservationEnabled(true);
        JavaParser parser = new JavaParser(config);
        ParseResult<CompilationUnit> parseResult = null;
        try {
            parseResult = parser.parse(new File(javaFilePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        CompilationUnit unit = parseResult.getResult().orElse(null);
        if (unit == null) {
            return null;
        }

        ClassOrInterfaceDeclaration classType = (ClassOrInterfaceDeclaration) unit.getPrimaryType().orElse(null);
        if (classType == null) {
            return null;
        }
        if (!classType.isAnnotationPresent("Frame")) {
            // Not frame type class. skip
            return null;
        }

        List<FrameFieldDeclaration> fdList = new ArrayList<>();

        List<FieldDeclaration> fields = classType.getFields();
        for (FieldDeclaration field : fields) {
            FrameFieldDeclaration fd = new FrameFieldDeclaration();
            fd.simpleTypeName = field.getCommonType().toString();
            fd.name = field.getVariable(0).getNameAsString();

            AnnotationExpr annotationExpr0 = field.getAnnotationByName("FrameField").orElse(null);
            if ((annotationExpr0 instanceof NormalAnnotationExpr)) {
                NormalAnnotationExpr annotationExpr = (NormalAnnotationExpr) annotationExpr0;

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
            List<MethodDeclaration> mdList = toGenerateGetterAndSetterMd(frameFieldDeclaration);
            for (MethodDeclaration methodDeclaration : mdList) {
                classType.addMember(methodDeclaration);
            }
        }
        return unit;
    }


    private static List<MethodDeclaration> toGenerateGetterAndSetterMd(FrameFieldDeclaration fd) {
        List<MethodDeclaration> mdList = new ArrayList<>();

        MethodDeclaration getterMd = new MethodDeclaration();
        getterMd.setPublic(true);
        getterMd.setType(new ClassOrInterfaceType(fd.simpleTypeName));
        getterMd.setName("get" + fd.name.substring(0, 1).toUpperCase() + fd.name.substring(1));
        getterMd.setComment(new JavadocComment("getter auto generated"));
        BlockStmt getterBody = new BlockStmt();
        getterBody.addAndGetStatement("return " + fd.name);
        getterMd.setBody(getterBody);
        mdList.add(getterMd);

        MethodDeclaration setterMd = new MethodDeclaration();
        setterMd.setPublic(true);
        setterMd.setType(new VoidType());
        setterMd.setComment(new JavadocComment("setter auto generated"));
        setterMd.setName("set" + fd.name.substring(0, 1).toUpperCase() + fd.name.substring(1));
        setterMd.addParameter(new Parameter(new ClassOrInterfaceType(fd.simpleTypeName), fd.name));
        BlockStmt setterBody = new BlockStmt();
        setterBody.addAndGetStatement("this." + fd.name + " = " + fd.name);
        setterMd.setBody(setterBody);
        mdList.add(setterMd);

        FrameFieldAnnotation an = fd.frameFieldAnnotation;
        if (an == null) {
            return mdList;
        }
        int len = an.len;

        switch (fd.simpleTypeName) {
            case "Ascii":
            case "BCD":
            case "Hex":
                MethodDeclaration stringSetterMd = new MethodDeclaration();
                stringSetterMd.setPublic(true);
                stringSetterMd.setName("set" + fd.name.substring(0, 1).toUpperCase() + fd.name.substring(1));
                stringSetterMd.setType(new VoidType());
                stringSetterMd.addParameter(new Parameter(new ClassOrInterfaceType("String"), fd.name));
                stringSetterMd.setComment(new JavadocComment("setter auto generated"));
                BlockStmt stringSetterBody = new BlockStmt();
                if (fd.simpleTypeName.equals("BCD") || fd.simpleTypeName.equals("Hex")) {
                    len = len * 2;
                }
                stringSetterBody.addAndGetStatement(ValidationUtil.class.getName() + ".lteLen(" + fd.name + ", " + len + ", " + fd.name + ")");
                stringSetterBody.addAndGetStatement("this." + fd.name + " = " + fd.simpleTypeName + ".from(" + fd.name + ", " + len + ")");
                stringSetterMd.setBody(stringSetterBody);
                mdList.add(stringSetterMd);
                break;
        }

        int unit = an.unit;
        int offset = an.offset;
        boolean offsetReverse = an.offsetReverse;

        switch (fd.simpleTypeName) {
            case "BCDNumber":
            case "NumberUnit":
            case "OffsetBCDNumber":
            case "OffsetNumberUnit":
                MethodDeclaration doubleSetterMd = new MethodDeclaration();
                doubleSetterMd.setPublic(true);
                doubleSetterMd.setName("set" + fd.name.substring(0, 1).toUpperCase() + fd.name.substring(1));
                doubleSetterMd.setType(new VoidType());
                doubleSetterMd.addParameter(new Parameter(PrimitiveType.doubleType(), fd.name));
                doubleSetterMd.setComment(new JavadocComment("setter auto generated"));
                BlockStmt doubleSetterBody = new BlockStmt();
                switch (fd.simpleTypeName) {
                    case "BCDNumber":
                        doubleSetterBody.addAndGetStatement("this." + fd.name + " = " + fd.simpleTypeName + ".from(" + fd.name + ", " + unit + "," + len + ")");
                        break;
                    case "NumberUnit":
                        doubleSetterBody.addAndGetStatement("this." + fd.name + " = " + fd.simpleTypeName + ".from(" + fd.name + ", " + unit + ")");
                        break;
                    case "OffsetBCDNumber":
                        doubleSetterBody.addAndGetStatement("this." + fd.name + " = " + fd.simpleTypeName + ".from(" + fd.name + ", " + unit + ", " + offset + ", " + offsetReverse + len + ")");
                        break;
                    case "OffsetNumberUnit":
                        doubleSetterBody.addAndGetStatement("this." + fd.name + " = " + fd.simpleTypeName + ".from(" + fd.name + ", " + unit + ", " + offset + ", " + offsetReverse + ")");
                        break;
                }
                doubleSetterMd.setBody(doubleSetterBody);
                mdList.add(doubleSetterMd);
                break;
        }
        return mdList;
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
