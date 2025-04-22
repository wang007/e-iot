package io.github.eiot.ocpp;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * created by wang007 on 2025/5/18
 */
public class GenerateCommandDef {

    public static void generate(String path, String commandPackage, String protocol, String className) {
        File dir = new File(path);
        if (!dir.exists() || !dir.isDirectory()) {
            System.err.println("目录不存在或不是有效目录！");
            return;
        }

        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            System.err.println("not file in dir: " + path);
            return;
        }
        Map<String, List<String>> collect = Arrays.stream(files)
                .map(f -> {
                    String name = f.getName();
                    // remove suffix
                    int i = name.indexOf('.');
                    return i > 0 ? name.substring(0, i) : name;
                })
                .filter(n -> {
                    return n.endsWith("Request") || n.endsWith("Response");
                })
                .collect(Collectors.groupingBy(n -> {
                    return n.endsWith("Request") ? n.substring(0, n.length() - 7) : n.substring(0, n.length() - 8);
                }));

        collect.values()
                .forEach(v -> {
                    v.sort((o1, o2) -> {
                        if (o1.endsWith("Request")) {
                            return 1;
                        }
                        if (o1.endsWith("Response")) {
                            return -1;
                        }
                        if (o2.endsWith("Request")) {
                            return -1;
                        }
                        if (o2.endsWith("Response")) {
                            return 1;
                        }
                        return 0;
                    });
                });

        generate(collect, commandPackage, protocol, className);
    }

    public static void generate(Map<String, List<String>> commands, String commandPackage, String protocol, String className) {
        int pkgIndex = className.lastIndexOf('.');
        String pkgName = className.substring(0, pkgIndex);
        String onlyClassName = className.substring(pkgIndex + 1);

        StringBuilder text = new StringBuilder(1200);
        text.append("package ").append(pkgName).append(";\r\n");
        text.append("\r\n");
        text.append("import io.github.eiot.CommandDef;\r\n");
        text.append("import io.github.eiot.impl.CommandDefProtocol;\r\n");
        text.append("import " + commandPackage + ".*;\r\n");
        text.append("\r\n");
        text.append("// generated \r\n");
        text.append("public interface " + onlyClassName + " {\r\n");
        text.append("\r\n");
        text.append("    CommandDefProtocol COMMAND_PROTOCOL = new CommandDefProtocol(\"" + protocol + "\");\n");
        text.append("\r\n");

        commands.forEach((k, v) -> {
            v.forEach(n -> {
                if (n.endsWith("Response")) {
                    text.append("    CommandDef<" + n + "> " + k + "Response = COMMAND_PROTOCOL.createAndRegister(\"" + k + "Response\", " + n + ".class, null);\r\n");
                } else {
                    text.append("    CommandDef<" + n + "> " + k + "Request = COMMAND_PROTOCOL.createAndRegister(\"" + k + "\", " + n + ".class, " + k + "Response);\r\n");
                }
            });
            text.append("\r\n");
        });

        text.append("    static CommandDef<?> match(String command) {\r\n");
        text.append("        return COMMAND_PROTOCOL.match(command);\r\n");
        text.append("    }\r\n");
        text.append("}"); // class end

        System.out.println(text.toString());
    }
}
