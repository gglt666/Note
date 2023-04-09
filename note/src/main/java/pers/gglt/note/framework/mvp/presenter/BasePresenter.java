package pers.gglt.note.framework.mvp.presenter;

import java.lang.ref.WeakReference;

public class BasePresenter<T> {
    protected WeakReference<T> viewRef; //view引用
    public void attachView(T view) {viewRef = new WeakReference<>(view);} //绑定
    public void detachView() {viewRef.clear();} //解绑
}