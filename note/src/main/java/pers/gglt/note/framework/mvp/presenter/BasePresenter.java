package pers.gglt.note.framework.mvp.presenter;

import java.lang.ref.WeakReference;

public class BasePresenter<T> {
    protected WeakReference<T> mViewRef; //view引用
    public void attachView(T view) {mViewRef = new WeakReference<T>(view);} //绑定
    public void detachView() {
        mViewRef.clear();
    } //解绑
}