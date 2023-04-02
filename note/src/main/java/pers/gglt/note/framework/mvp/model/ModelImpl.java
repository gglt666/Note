package pers.gglt.note.framework.mvp.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ModelImpl implements IModel {

    @Override
    public void getData1(DataListener1 dataListener1) {
        Map<String, Object> params = new HashMap<>();
    }

    @Override
    public void getData2(DataListener2 dataListener2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date(System.currentTimeMillis());
        String sDate = simpleDateFormat.format(date);
        dataListener2.onComplete(sDate);
    }

    @Override
    public void getData3(DataListener3 dataListener3) {}
}