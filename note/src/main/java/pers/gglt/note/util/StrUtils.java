package pers.gglt.note.util;

public class StrUtils {
    /**截取某字符前的字符串*/
    public static String subFrontString(String subChar, String str) {
        try {
            return str.substring(0, str.indexOf(subChar));
        } catch (Exception e) {
            return str;
        }
    }
    /**截取某字符后的字符串*/
    public static String subFollowString(String subChar, String str) {
        try {
            String str1 = str.substring(0, str.indexOf(subChar));
            return str.substring(str1.length() + 1);
        } catch (Exception e) {
            return str;
        }
    }
}
