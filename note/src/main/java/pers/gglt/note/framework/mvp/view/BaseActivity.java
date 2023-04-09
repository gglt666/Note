package pers.gglt.note.framework.mvp.view;

import android.app.Activity;
import android.os.Bundle;

import pers.gglt.note.framework.mvp.presenter.Presenter;


public abstract class BaseActivity extends Activity {
    Presenter  presenter = new Presenter();
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.attachView(this);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}