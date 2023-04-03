package pers.gglt.project;

import org.junit.Test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UnitTest {

    @Test
    public void a() throws ParseException {
        String ruleTime = "2023-03-21 07:44:33";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(new Date()));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d1 = "2023-03-12 07:44:33";
        String d2 = "2023-03-30 17:19:20";
        String innerTime = formatter.format(new Date());

        Date dt1 = formatter.parse(d1);
        Date dt2 = formatter.parse(d2);
        Date stime = dt1.before(dt2) ? dt1 : dt2;
        Date etime = dt1.after(dt2) ? dt1 : dt2;
        Date inner = formatter.parse(innerTime);
        boolean flag = inner.after(stime) && inner.before(etime);

        System.out.println("是否在2个时间之间:" + flag);
    }

    @Test
    public void aa() throws ParseException {
        String ruleTime = "2022-2024,2025-2030";
        String[] timeSlots = ruleTime.split(",");
        SimpleDateFormat yearDf = new SimpleDateFormat("yyyy");
        for (int i = 0; i < timeSlots.length; i++) {
            String[] rangeTimes = timeSlots[i].split("-");
            Date currDate = yearDf.parse(yearDf.format(new Date()));
            Date firstRuleDate = yearDf.parse(rangeTimes[0]);
            Date secondRuleDate = yearDf.parse(rangeTimes[1]);
            System.out.println("当前时间 = " + yearDf.format(new Date()));
            System.out.println("目标时间1 = " + rangeTimes[0]);
            System.out.println("目标时间2 = " + rangeTimes[1]);
            if ((currDate.after(firstRuleDate) || currDate.equals(firstRuleDate)) &&
                    (currDate.before(secondRuleDate) || currDate.equals(secondRuleDate))) {
                System.out.println("pass");
            }
        }
    }

    @Test
    public void b() throws ParseException {
        String passTime = "2023-03-12 07:44:33";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date deadlineDate = stepMonth(df.parse(passTime), Integer.parseInt("1"));

        if (new Date().before(deadlineDate) && new Date().after(df.parse(passTime))) {
            System.out.println("T");
        }

        System.out.println("第一次通行时间 = " + passTime);
        System.out.println("当前时间 = " + df.format(new Date()));
        System.out.println("截止时间 = " + df.format(deadlineDate));
    }


    @Test
    public void c() throws ParseException {
        String passTime = "2023-03-12 07:44:33";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date deadlineDate = stepDay(df.parse(passTime), 21);

        if (new Date().before(deadlineDate) && new Date().after(df.parse(passTime))) {
            System.out.println("T");
        }

        System.out.println("第一次通行时间 = " + passTime);
        System.out.println("当前时间 = " + df.format(new Date()));
        System.out.println("截止时间 = " + df.format(deadlineDate));
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


    @Test
    public void d() {
    }
}