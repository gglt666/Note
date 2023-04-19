package pers.gglt.note.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AppSignUtil {
    /**
     * 获取 app 签名Md5
     * 等效于: keytool -list -v -keystore file
     */
    public static String appSignMd5(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), PackageManager.GET_SIGNATURES);
            if(packageInfo == null || packageInfo.signatures == null)
                return "";
            Signature signature = packageInfo.signatures[0];
            return Md5(signature.toByteArray());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
    private static String Md5(byte[] byteStr) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(byteStr);
            return Hex2String(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String Hex2String(byte[] data) {
        if (data == null)
            return "";
        char[] hexCode = "0123456789ABCDEF".toCharArray();
        StringBuilder r = new StringBuilder(data.length * 2);
        for (byte b : data) {
            r.append(hexCode[b >> 4 & 0xF]);
            r.append(hexCode[b & 0xF]);
            r.append(" ");
        }
        return r.toString();
    }
}
