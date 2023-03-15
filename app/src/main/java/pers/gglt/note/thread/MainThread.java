package pers.gglt.note.thread;
/**
 * 子线程不能访问 UI
 *      原因  控件不是线程安全的，若加锁则会导致阻塞
 *
 * ANR
 *      原因  当前 Message 处理超时
 *           Looper.myQueue 中的 Message 未能执行（阻塞）
 *
 * Looper.loop 不会导致 ANR
 *      原因 https://blog.csdn.net/qq_36645832/article/details/88341590
 */

public class MainThread {
}
