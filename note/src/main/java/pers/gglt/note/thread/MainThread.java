package pers.gglt.note.thread;

/**
 * 流程  1.依次执行 onCreate、onStart、onResume
 *      2.阻塞在 onResume 中（通过 Looper.loop()）
 *      3.收到消息执行 onPause、onStop、onDestroy
 */

/**
 * 子线程不能访问 UI
 *      原因  控件不是线程安全的，若加锁则会导致阻塞
 *
 * Looper.loop 不会导致 ANR
 *      原因
 */

//https://www.jianshu.com/p/6d855e984b99
//https://blog.csdn.net/zx54633089/article/details/115320309
public class MainThread {

    /**ANR原因*/
    // 主线程导致 (事件处理超时)
    // 子线程导致 (子线程持有锁/崩溃，主线程等待超时)

    /**ANR时间*/
    // 5s  (Activity,Service)
    // 10s (BroadCastReceiver)

    /**ANR避免*/
    // 子线程执行耗时操作 (访问网络,文件读写,数据库读写,复杂逻辑计算)

}
