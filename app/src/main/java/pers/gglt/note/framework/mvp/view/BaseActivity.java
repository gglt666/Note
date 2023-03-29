package pers.gglt.note.framework.mvp.view;

import android.app.Activity;
import android.os.Bundle;

import pers.gglt.note.framework.mvp.presenter.BasePresenter;


public abstract class BaseActivity<V, T extends BasePresenter<V>> extends Activity {

    //表示层的引用
    public T pestPresenter;
    protected abstract T createPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pestPresenter = createPresenter();
        pestPresenter.attachView((V) this);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        pestPresenter.detachView();
    }
}