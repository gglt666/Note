package pers.gglt.note.framework.mvp.presenter;

import pers.gglt.note.framework.mvp.model.IModel;
import pers.gglt.note.framework.mvp.model.ModelImpl;
import pers.gglt.note.framework.mvp.view.IView;

public class Presenter<T extends IView> extends BasePresenter<T> {
    IModel dataModel = new ModelImpl(); //model层的引用

    public void fetch() { //执行操作(UI)逻辑
        if (mViewRef.get() != null) {
            if (dataModel != null) {
                dataModel.getData1(data -> {
                    mViewRef.get().showData1(data);
                });
                dataModel.getData2(date -> {
                    mViewRef.get().setData2(date);
                });
                dataModel.getData3(data -> {
                    mViewRef.get().setData3(data);
                });
            }
        }
    }
}