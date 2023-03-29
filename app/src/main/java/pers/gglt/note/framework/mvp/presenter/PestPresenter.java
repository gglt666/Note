package pers.gglt.note.framework.mvp.presenter;

import pers.gglt.note.framework.mvp.model.IPestModel;
import pers.gglt.note.framework.mvp.model.PestModelImpl;
import pers.gglt.note.framework.mvp.view.IPestView;

public class PestPresenter<T extends IPestView> extends BasePresenter<T> {
    IPestModel pestModel = new PestModelImpl(); //model层的引用

    public void fetch() { //执行操作(UI)逻辑
        if (mViewRef.get() != null) {
            if (pestModel != null) {
                pestModel.getPest(pest -> {
                    mViewRef.get().showPest(pest);
                });
                pestModel.getDate(date -> {
                    mViewRef.get().setDate(date);
                });
                pestModel.getLatlng(latlng -> {
                    mViewRef.get().setLatlng(latlng);
                });
            }
        }
    }
}