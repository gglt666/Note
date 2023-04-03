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
    /**16进制转10进制*/
    public static String parseHex2Decimal(String hexStr) {
        try {
            if (hexStr.contains("0x") || hexStr.contains("0X")) {
                hexStr = hexStr.substring(2);
            }
            return String.valueOf(Integer.parseInt(hexStr,16));
        } catch (Exception e) {
            return hexStr;
        }
    }
    /**10进制转16进制*/
    public static String parseDecimal2Hex(String decimalStr) {
        try {
            Integer integer = Integer.valueOf(decimalStr);
            return integer.toHexString(integer);
        } catch (Exception e) {
            return decimalStr;
        }
    }
}
