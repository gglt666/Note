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
 * ANR
 *      场景  5s 内无法响应用户输入事件
 *           BroadcastReceiver 在 10s 内无法结束
 *      原因  主线程导致（事件处理超时）
 *           子线程导致（子线程持有锁/崩溃，主线程等待超时）
 *
 *
 *
 *
 * Looper.loop 不会导致 ANR
 *      原因
 */

//https://www.jianshu.com/p/6d855e984b99
public class MainThread {

    void anr() {
        // 文件读写
        // 数据库读写
        // 网络查询
    }
}
