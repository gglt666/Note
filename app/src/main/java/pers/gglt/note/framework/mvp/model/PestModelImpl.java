package pers.gglt.note.framework.mvp.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PestModelImpl implements IPestModel {


    /**害虫的名字
     * @param pestGetListener
     */
    @Override
    public void getPest(final PestGetListener pestGetListener) {
        Map<String, Object> params = new HashMap<>();
    }

    /**
     * 当前日期
     * @param dateListener
     */
    @Override
    public void getDate(DateListener dateListener) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("  yyyy/MM/dd  ");// yyyy/MM/dd  HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        String sDate = simpleDateFormat.format(date);
        dateListener.onComplete(sDate);
    }

    /**
     * 经纬度数据
     * @param latlngListener
     */
    @Override
    public void getLatlng(LatlngListener latlngListener) {

    }
}