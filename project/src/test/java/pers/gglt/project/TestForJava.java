package pers.gglt.project;

import org.junit.Test;

import static org.junit.Assert.*;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TestForJava {

    @Test public void a() throws Exception {
        String decStr1 = "3043677171";
        String decStr2 = "4090718901";

        String hexStr1 = "B56AD3F3";
        String hexStr2 = "F3D36AB5";

       //System.out.println(hexStr2DEC("B56AD3F3"));
        byte[] hexBytes1 = ConvertUtils.hexString2Bytes(hexStr1);
        byte[] hexBytes2 = ConvertUtils.hexString2Bytes(hexStr2);

        byte[] convertBytes1 = changeBytesEndian(hexBytes1);
        byte[] convertBytes2 = changeBytesEndian(hexBytes2);

        String convertHexStr1 = ConvertUtils.bytes2HexString(convertBytes1);
        String convertHexStr2 = ConvertUtils.bytes2HexString(convertBytes2);


        System.out.println(convertHexStr1);
        System.out.println(convertHexStr2);
    }

    @Test public void b() {

    }


    public static String decimal2fitHex(long num) {
        String hex = Long.toHexString(num).toUpperCase();
        if (hex.length() % 2 != 0) {
            return "0" + hex;
        }
        return hex.toUpperCase();
    }

    /**大端/小端互转*/
    public String hexStr2DEC(String hexStr) {
        String real1 = "";
        String real = "";
        int j = 0;
        int size = hexStr.length() / 2;
        ArrayList<String> list = new ArrayList();

        for (int i = 0; i < size; i++) {
            list.add(hexStr.substring(j, j + 2));
            j = j + 2;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            real1 = real1 + list.get(i);
        }
        BigInteger a = new BigInteger(real1, 16);
        real = a.toString();
        return real;
    }

    /**大端/小端互转*/
    public static byte[] changeBytesEndian(byte[] x){
        byte[] y = new byte[x.length];
        for (int i = 0; i < y.length; i++) {
            y[i] = x[y.length - i - 1];
        }
        return y;
    }

    /**
     * 将bytes转为大端数据，返回int
     * c存储二进制文件是用的小端存储，java都是大端存储，因此需要转换，此方法用于将数据转为大端存储，读出二进制文件
     * @param bytes
     * @return
     */
    private static int bytesToBigEndian(byte[] bytes) {
        return ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    /**
     * 将bytes转为小端数据，返回int
     * c存储二进制文件是用的小端存储，java都是大端存储，因此需要转换，此方法用于将数据转为小端存储，写入二进制文件
     * @param bytes
     * @return
     */
    private static int bytesToLittleEndianInt(byte[] bytes){
        return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getInt();
    }
}