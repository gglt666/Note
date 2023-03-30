package pers.gglt.note.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {
    /**获取时间*/
    void currentTimeMillis() {
        System.currentTimeMillis();
    }
    void calendar() {
        Calendar.getInstance().get(Calendar.YEAR);
    }
    void simpleDateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.format(new Date());
    }

    /**SimpleDateFormat格式*/
    // yyyy ()  YYYY ()
    // MM (月)  mm (分)
    // ss (秒)
    //D : 一年中的第一几天
    //F : 一个月中的第几个星期(通过这个月的天数除7,例如5号那就是属于第一个星期)
    //W : 一个月中的第几个星期(根据实际情况计算)
    //w : 一年中的第几个星期

}
