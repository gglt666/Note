package pers.gglt.note.framework.mvp.model;

public interface IModel {
    void getData1(DataListener1 dataListener1);
    interface DataListener1 {
        void onComplete(String[] data);
    }

    void getData2(DataListener2 dataListener2);
    interface DataListener2 {
        void onComplete(String date);
    }

    void getData3(DataListener3 dataListener3);
    interface DataListener3 {
        void onComplete(String[] data);
    }

}