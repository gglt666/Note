package pers.gglt.note.async;

import android.annotation.SuppressLint;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxAndroid {
    //https://zhuanlan.zhihu.com/p/617186735

    // Observer接收Observable发出的event (Observer需订阅Observable)

    /**创建被观察者*/
    @SuppressLint("CheckResult")
    void createObservable() {
        Observable.create(emitter -> {
            emitter.onNext("");
            emitter.onComplete();
        });
        Observable.just("", "", "", "", "");
    }

    void use() {
        Observable.just("", "", "", "", "")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onNext(@NonNull String s) {}

                    @Override
                    public void onError(@NonNull Throwable e) {}

                    @Override
                    public void onComplete() {}
                });
    }
}
