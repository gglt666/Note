package pers.gglt.note.framework.mvp.model;

public interface IPestModel {
    void getPest(PestGetListener pestGetListener);
    //设计一个内部回调接口
    interface PestGetListener {
        void onComplete(String[] pest);
    }

    void getDate(DateListener dateListener);
    interface DateListener {
        void onComplete(String date);
    }
    //获取当前经纬度数据
    void getLatlng(LatlngListener latlngListener);
    interface LatlngListener {
        void onComplete(String[] latlng);
    }

}