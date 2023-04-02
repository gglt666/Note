package pers.gglt.note.framework.mvp.view;

import android.os.Bundle;

import pers.gglt.note.framework.mvp.presenter.BasePresenter;
import pers.gglt.note.framework.mvp.presenter.Presenter;

public class MainActivity extends BaseActivity {
    Presenter presenter = new Presenter();
    @Override
    protected BasePresenter createPresenter() {
        return presenter;
    }
}
