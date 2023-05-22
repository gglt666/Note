package pers.gglt.project;

import org.junit.Test;

import static org.junit.Assert.*;

import android.util.Base64;

import com.blankj.utilcode.constant.TimeConstants;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.EncryptUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.google.gson.JsonObject;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;

public class TestForJava {

    @Test
    public void a() throws Exception {
        if (NetworkUtils.isWifiConnected()) {
            String ssid = NetworkUtils.getSSID();
            System.out.println(ssid);
        } else {
            LogUtils.e("Wifi没有连接");
        }
    }

    @Test
    public void b() throws Exception {
        String ip = "/192.168.33.102";
        System.out.println(ip.replace("/",""));

    }


    public static String getMd5(String text) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(text.getBytes(StandardCharsets.UTF_8));

        StringBuilder builder = new StringBuilder();

        for (byte aByte : bytes) {
            builder.append(Integer.toHexString((0x000000FF & aByte) | 0xFFFFFF00).substring(6));
        }

        return builder.toString();
    }

    /**
     * <p>方法描述：不足8的倍数，后面追加空格</p>
     */
    private static byte[] pkcs5Pad(final String inSouce) throws UnsupportedEncodingException {
        byte[] bySource = inSouce.getBytes("UTF8");

        // 密文和密钥的长度必须是8的倍数
        if (0 == bySource.length % 8) {
            return bySource;
        }

        int length = bySource.length;
        int nPaddedLength = (length / 8 + 1) * 8;
        byte[] byReturn = new byte[nPaddedLength];
        System.arraycopy(bySource, 0, byReturn, 0, length);
        int i = length;
        while (i < nPaddedLength) {
            byReturn[i] = (byte) (nPaddedLength - length);
            i++;
        }
        return byReturn;
    }


    /**
     * ASCII码hex字符串转String明文
     * 每两个字符表示的16进制ASCII码解析成一个明文字符
     *
     * @param hex
     * @return
     */
    public static String hex2Str(String hex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hex.length() - 1; i += 2) {
            String h = hex.substring(i, (i + 2));
            int decimal = Integer.parseInt(h, 16);
            sb.append((char) decimal);
        }
        return sb.toString();
    }

    /**
     * byte数组转hex
     *
     * @param bytes
     * @return
     */
    public static String byteToHex(byte[] bytes) {
        String strHex = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < bytes.length; n++) {
            strHex = Integer.toHexString(bytes[n] & 0xFF);
            sb.append((strHex.length() == 1) ? "0" + strHex : strHex); // 每个字节由两个字符表示，位数不够，高位补0
        }
        return sb.toString().trim();
    }

    /**
     * 大端/小端互转
     */
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

    /**
     * 大端/小端互转
     */
    public static byte[] changeBytesEndian(byte[] x) {
        byte[] y = new byte[x.length];
        for (int i = 0; i < y.length; i++) {
            y[i] = x[y.length - i - 1];
        }
        return y;
    }

    /**
     * 将bytes转为大端数据，返回int
     * c存储二进制文件是用的小端存储，java都是大端存储，因此需要转换，此方法用于将数据转为大端存储，读出二进制文件
     *
     * @param bytes
     * @return
     */
    private static int bytesToBigEndian(byte[] bytes) {
        return ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    /**
     * 将bytes转为小端数据，返回int
     * c存储二进制文件是用的小端存储，java都是大端存储，因此需要转换，此方法用于将数据转为小端存储，写入二进制文件
     *
     * @param bytes
     * @return
     */
    private static int bytesToLittleEndianInt(byte[] bytes) {
        return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getInt();
    }


    int delayMinute;
    StringBuilder detailInfo = new StringBuilder(); //通行结果的详细信息
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String passRule10 = "2023,2024 -1 -1 -1 -1 -1";
    String passRule11 = "2020-2022,2023-2025 -1 -1 -1 -1 -1";
    String passRule12 = "2021/1 -1 -1 -1 -1 -1";
    String passRule20 = "-1 03,04 -1 -1 -1 -1";
    String passRule21 = "-1 03-06,9-11 -1 -1 -1 -1";
    String passRule22 = "-1 2/1 -1 -1 -1 -1";
    String passRule30 = "-1 -1 01,07 -1 -1 -1";
    String passRule31 = "-1 -1 04-6,1-2 -1 -1 -1";
    String passRule32 = "-1 -1 1/1 -1 -1 -1";
    String passRule40 = "-1 -1 -1 07,8 -1 -1";
    String passRule41 = "-1 -1 -1 07-12 -1 -1";
    String passRule42 = "-1 -1 -1 06/2 -1 -1";
    String passRule50 = "-1 -1 -1 -1 09:00-12:30 -1";
    String passRule51 = "-1 -1 -1 -1 09:30-12:30,14:00-18:30 -1";
    String passRule60 = "-1 -1 -1 -1 -1 0;5-30";
    String passRule61 = "-1 -1 -1 -1 -1 1;5";
    String passRule62 = "-1 -1 -1 -1 -1 2;6";

    String passRule1020 = "2023,2024 03,04 -1 -1 -1 -1";
    String passRule1120 = "2020-2022,2023-2025 03,05,04 -1 -1 -1 -1";

    String test = "-1 -1 3-4 21,25 -1 -1";

    public class Result {
        public Result() {
        }

        public Result(boolean canPass, String voiceInfo, String promptInfo) {
            this.canPass = canPass;
            this.voiceInfo = voiceInfo;
            this.promptInfo = promptInfo;
        }

        public boolean canPass;
        public String voiceInfo;
        public String promptInfo;
    }

    @Test
    public void getPassResult() {
        Result result = new Result();
        result.canPass = false;

        String passRule = test;
        int passNum = 0;
        String vipName = "GG";
        String passRuleName = "xxx";
        String lastPassTime = null;
        String firstPassTime = null;

        String[] subRules = passRule.split(" ");
        SimpleDateFormat yearDf = new SimpleDateFormat("yyyy");
        SimpleDateFormat monthDf = new SimpleDateFormat("MM");
        SimpleDateFormat dayDf = new SimpleDateFormat("dd");
        SimpleDateFormat hourDf = new SimpleDateFormat("HH:mm");

        if (checkTimeRule(yearDf, subRules[0]) &&
                checkTimeRule(monthDf, subRules[1]) &&
                checkWeekRule(subRules[2]) &&
                checkTimeRule(dayDf, subRules[3]) &&
                checkTimeRule(hourDf, subRules[4])) {
            if (checkTicketRule(firstPassTime, lastPassTime, passNum, subRules[5])) {
                result.voiceInfo = "请通行";
                result.promptInfo = "请通行" + ", 您当前套餐为" + passRuleName + "套餐, " + detailInfo + "可通行";
                result.canPass = true;
            } else { //不满足票务规则
                result.voiceInfo = "很抱歉, 您的" + passRuleName + "套餐已过期";
                result.promptInfo = "尊敬的" + vipName + ", 很抱歉, 您的" + passRuleName + "套餐" + detailInfo;
            }
        } else { //不满足通行时间规则
            result.voiceInfo = "当前时间段禁止通行";
            result.promptInfo = "尊敬的" + vipName + ", 很抱歉,您的" + passRuleName + "套餐, 当前时间段禁止通行";
        }
        detailInfo = new StringBuilder();
        System.out.println("result = " + result.canPass + ",promptInfo = " + result.promptInfo);
    }

    public boolean checkWeekRule(String ruleTime) {
        int weekDay = getWeekDay(new Date());
        if (ruleTime != null) {
            if (ruleTime.equals("-1")) {
                return true;
            } else if (ruleTime.contains("-")) {
                String[] timeSlots = ruleTime.split(",");
                for (int i = 0; i < timeSlots.length; i++) {
                    String[] rangeTimes = timeSlots[i].split("-");
                    int endWeek = Integer.parseInt(rangeTimes[1]);
                    int startWeek = Integer.parseInt(rangeTimes[0]);
                    if (i == 0) detailInfo.append("每");
                    detailInfo.append("周").append(startWeek).append("至周").append(endWeek).append(", ");
                }
                for (int i = 0; i < timeSlots.length; i++) {
                    String[] rangeTimes = timeSlots[i].split("-");
                    int endWeek = Integer.parseInt(rangeTimes[1]);
                    int startWeek = Integer.parseInt(rangeTimes[0]);
                    if (weekDay >= startWeek && weekDay <= endWeek) {
                        return true;
                    }
                }
            } else if (ruleTime.contains("/")) {
                String[] rules = ruleTime.split("/");
                int interval = Integer.parseInt(rules[1]) + 1;
                int startWeek = Integer.parseInt(rules[0]);
                detailInfo.append("每隔" + Integer.parseInt(rules[1]) + "天, ");
                while (interval < 7) {
                    if (weekDay == startWeek || weekDay == startWeek + interval) return true;
                    interval = interval * 2;
                }
            } else {
                String[] timeSlots = ruleTime.split(",");

                for (int i = 0; i < timeSlots.length; i++) {
                    if (i == 0) detailInfo.append("每周");
                    detailInfo.append(timeSlots[i]).append(",");
                }
                for (int i = 0; i < timeSlots.length; i++) {
                    if (weekDay == Integer.parseInt(timeSlots[i])) return true;
                }
            }
        }
        return false;
    }


    private boolean checkTimeRule(SimpleDateFormat df, String ruleTime) {
        String timeUnit = "";
        switch (df.toPattern()) { // @formatter:off
            case "yyyy":
                timeUnit = "年";
                break;
            case "MM":
                timeUnit = "月";
                break;
            case "dd":
                timeUnit = "日";
                break;
            case "HH:mm":
                timeUnit = "小时";
                break;
        } // @formatter:on
        try {
            if (ruleTime != null) {
                if (ruleTime.equals("-1")) {
                    return true;
                } else if (ruleTime.contains("-")) {
                    String[] timeSlots = ruleTime.split(",");
                    for (int i = 0; i < timeSlots.length; i++) {
                        String[] rangeTimes = timeSlots[i].split("-");
                        Date firstRuleDate = df.parse(rangeTimes[0]);
                        Date secondRuleDate = df.parse(rangeTimes[1]);
                        if (i == 0) detailInfo.append("其中");
                        detailInfo.append(df.format(firstRuleDate)).append("至")
                                .append(df.format(secondRuleDate)).append(timeUnit).append(",");
                    }
                    for (int i = 0; i < timeSlots.length; i++) {
                        String[] rangeTimes = timeSlots[i].split("-");
                        Date currDate = df.parse(df.format(new Date()));
                        Date firstRuleDate = df.parse(rangeTimes[0]);
                        Date secondRuleDate = df.parse(rangeTimes[1]);

                        if ((currDate.after(firstRuleDate) || currDate.equals(firstRuleDate)) &&
                                (currDate.before(secondRuleDate) || currDate.equals(secondRuleDate))) {
                            return true;
                        }
                    }
                } else if (ruleTime.contains("/")) {
                    String[] rules = ruleTime.split("/");
                    int interval = Integer.parseInt(rules[1]) + 1;
                    int startTime = Integer.parseInt(rules[0]);
                    String currDate = df.format(new Date());
                    int currTime = Integer.parseInt(subFrontString(":", currDate));

                    detailInfo.append("从").append(startTime).append(timeUnit).append("开始,每隔")
                            .append(Integer.parseInt(rules[1])).append(timeUnit).append(",");

                    while (interval < 13) {
                        if (currTime == startTime || currTime == startTime + interval) {
                            return true;
                        }
                        interval = interval * 2;
                    }
                } else {
                    StringBuilder infoStr = new StringBuilder();
                    String[] timeSlots = ruleTime.split(",");

                    for (int i = 0; i < timeSlots.length; i++) {
                        if (i == 0) detailInfo.append("其中");
                        infoStr.append(timeSlots[i]).append(",");
                        if (i == timeSlots.length - 1) {
                            String str = infoStr.substring(0, infoStr.length() - 1);
                            detailInfo.append(str).append(timeUnit).append(",");
                        }
                    }

                    for (int i = 0; i < timeSlots.length; i++) {
                        Date currDate = df.parse(df.format(new Date()));
                        Date firstRuleDate = df.parse(timeSlots[i]);
                        if (currDate.equals(firstRuleDate)) return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean checkTicketRule(String firstPassTime, String lastPassTime, int passNum, String combinationRule) {
        try {
            String[] combinationRules = combinationRule.split(";");
            String countRule = combinationRule.substring(combinationRule.indexOf(";") + 1);
            if (firstPassTime == null) firstPassTime = df.format(new Date());

            if (combinationRule != null) {
                if (combinationRule.equals("-1")) {
                    return true;
                } else if (combinationRules[0].equals("0")) { //次卡
                    if (countRule.contains("-")) {
                        String[] countRules = countRule.split("-");
                        int count = Integer.parseInt(countRules[0]);
                        if (passNum < count) {
                            int remainPassNum;
                            delayMinute = Integer.parseInt(countRules[1]);
                            if (lastPassTime == null) {
                                remainPassNum = count - passNum - 1;
                            } else {
                                Date deadlineTime = stepMinute(df.parse(lastPassTime), delayMinute);
                                remainPassNum = (new Date().before(deadlineTime)) ? count - passNum : count - passNum - 1;
                            }
                            detailInfo.append(", 剩余通行次数为" + remainPassNum + "次");
                            return true;
                        }
                        detailInfo.append("剩余通行次数已不足");
                    }
                } else if (combinationRules[0].equals("1")) { //天卡
                    Date deadlineDate = stepDay(df.parse(firstPassTime), Integer.parseInt(combinationRules[1]));
                    if (new Date().before(deadlineDate) && new Date().after(df.parse(firstPassTime))) {
                        return true;
                    }
                    detailInfo.append("已过期, 过期时间" + df.format(deadlineDate));
                } else if (combinationRules[0].equals("2")) { //月卡
                    Date deadlineDate = stepMonth(df.parse(firstPassTime), Integer.parseInt(combinationRules[1]));
                    if (new Date().before(deadlineDate) && new Date().after(df.parse(firstPassTime))) {
                        return true;
                    }
                    detailInfo.append("已过期, 过期时间" + df.format(deadlineDate));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Date stepMinute(Date sourceDate, int minute) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.MINUTE, minute);
        return c.getTime();
    }

    public static Date stepMonth(Date sourceDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }

    public static Date stepDay(Date sourceDate, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.DAY_OF_MONTH, day);
        return c.getTime();
    }

    public static String subFrontString(String subChar, String str) {
        try {
            return str.substring(0, str.indexOf(subChar));
        } catch (Exception e) {
            return str;
        }
    }

    public static int getWeekDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (week == 0) week = 7;
        return week;
    }
}