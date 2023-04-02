package pers.gglt.note.async;

import android.annotation.SuppressLint;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.observables.GroupedObservable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxAndroid {
    //https://zhuanlan.zhihu.com/p/617186735

    /**流程*/
    // 创建Observable和Observer
    // Observer订阅Observable
    // Observer接收Observable发出的event

    /**创建Observable*/
    @SuppressLint("CheckResult")
    void createObservable() {
        Observable.create(emitter -> {
            emitter.onNext("");
            emitter.onComplete();
        });
        Observable.just("", "", "", "", ""); //自动回调onNext(),参数将由onNext()中接收
        Observable.fromArray(new List[5]); //多次回调onNext()方法,每次传入一个item
        Observable.defer((Supplier<ObservableSource<?>>) () -> Observable.just("")); //当观察者订阅时,才创建Observable
        Observable.empty(); //不发送任何数据,正常终止
        Observable.never(); //不发送任何数据,不终止
        Observable.error(new Throwable()); //不发射数据,以错误终止
        Observable.timer(1, TimeUnit.SECONDS); //延迟1s发送数据
        Observable.interval(1, TimeUnit.SECONDS); //间隔1s发送数据
        Observable.just("").repeat(200); //重复调用
    }
    /**转换Observable*/
    void transformObservable() {
        Observable.just(123).map(s -> s.toString()); //将发送数据进行类型转化
        Observable.just(1, 2)
                .flatMap((Function<Integer, ObservableSource<?>>) integer -> Observable.just(integer.toString())); //若发送的数据是集合,将重新生成Observable对象，并将数据转换成Observer想要的数据形式

        Observable.just(1, 2, 3, 4, 5)
                .groupBy(integer -> integer % 2 == 0 ? "偶数" : "奇数")
                .subscribe(new Observer<>() {
                    public void onSubscribe(@NonNull Disposable d) {}
                    public void onNext(@NonNull final GroupedObservable<String, Integer> arg0) {
                        arg0.subscribe(new Observer<>() {
                            public void onSubscribe(Disposable d) {}
                            public void onNext(Integer integer) {}
                            public void onError(Throwable e) {}
                            public void onComplete() {}
                        });}
                    public void onError(@NonNull Throwable e) {}
                    public void onComplete() {}
                });

        Observable.just(1, 2, 3, 4, 5,6).buffer(4);
        //收集数据放进List[]后再发送包裹
        //输出  [1,2,3,4],[5,6]

        Observable.range(1, 5).scan((integer, integer2) -> integer + integer2);
        //输出  1 3 6 10 15 (数据累加)

        Observable.range(1, 5).window(5, 1);
    }

    /**过滤Observable*/
    void filterObservable() {
        Observable.create((ObservableOnSubscribe<Integer>) arg0 -> {}).debounce(1, TimeUnit.SECONDS);
        //间隔一定时间内没有做任何操作,会发送数据

        Observable.just(1, 2, 3, 2, 3).distinct(); //不会发送重复数据

        Observable.just(1, 2, 3, 2, 3).elementAt(0); //取出指定位置数据

        Observable.create((ObservableOnSubscribe<Integer>) arg0 -> {}).sample(4, TimeUnit.SECONDS);
        //每4s采集一次数据源并发送

        Observable.just(6, 3, 2, 1).skip(2); //跳过指定列表项数据的指定项数据
    }

    /**创建Observer*/
    void createObserver() {
        new Observer<String>() {
            public void onSubscribe(@NonNull Disposable d) {}
            public void onNext(@NonNull String s) {}
            public void onError(@NonNull Throwable e) {}
            public void onComplete() {}
        };
    }
    /**订阅*/
    void subscribe(Observable observable, Observer observer) {
        observable.subscribe(observer);
    }

    /**使用*/
    void use() {
        Observable.just("", "", "", "", "")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onNext(@NonNull String s) {
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
