package io.github.eiot.utils;

/**
 * created by wang007 on 2025/3/20
 */
public class StringUtil {

    public static boolean isEmpty(String str) {
        if (str == null) {
            return true;
        }
        return str.isEmpty();
    }

    public static String leftPad(String str, int len, char c) {
        return pad0(str, len, c, true);
    }

    public static String rightPad(String str, int len, char c) {
        return pad0(str, len, c, false);
    }

    private static String pad0(String str, int len, char c, boolean lr) { // lr = left or right
        if (str == null) {
            str = "";
        }
        if (str.length() == len) {
            return str;
        }
        if (str.length() > len) {
            return str.substring(0, len);
        }
        int l = len - str.length();
        StringBuilder s = new StringBuilder(len);
        if (!lr) {
            s.append(str);
        }
        for (int i = 0; i < l; i++) {
            s.append(c);
        }
        if (lr) {
            s.append(str);
        }
        return s.toString();
    }

}
