package pers.gglt.note.framework.mvp.view;

import android.app.Activity;
import android.os.Bundle;

import pers.gglt.note.framework.mvp.presenter.BasePresenter;


public abstract class BaseActivity<V, T extends BasePresenter<V>> extends Activity {
    public T presenter;
    protected abstract T createPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}