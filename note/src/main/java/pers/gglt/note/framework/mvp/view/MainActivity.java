package pers.gglt.note.framework.mvp.view;

import pers.gglt.note.framework.mvp.presenter.BasePresenter;
import pers.gglt.note.framework.mvp.presenter.Presenter;

public class MainActivity extends BaseActivity implements IView {
    @Override public void showData1(String[] data) {}
    @Override public void setData2(String data) {}
    @Override public void setData3(String[] data) {}
}
