package pers.gglt.note.thread;

import com.blankj.utilcode.util.LogUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class Thread_ {
    Thread thread = new Thread();

    /**概念*/
    // 某进程中一个单独运行的程序

    /**类型*/
    void daemon() { //守护线程（为用户线程提供服务）
        thread.setDaemon(true);
    }
    // 用户线程 (主/子)

    /**状态*/
    void newState() {Thread thread = new Thread(() -> {});}
    void runnable() {thread.start();}
    void blocked() {synchronized (this) {}}
    void waiting() throws InterruptedException {
        thread.wait();
        thread.wait(100);
        thread.join();
        thread.join(100);
        LockSupport.park();
        LockSupport.parkNanos(100);
        LockSupport.parkUntil(100);
    }
    void terminated() {}

    /**调度*/
    void sleep() throws InterruptedException {
        Thread.sleep(1000);
        TimeUnit.SECONDS.sleep(1);
        TimeUnit.MILLISECONDS.sleep(1000);
    }
    void join() throws InterruptedException {
        Thread joinThread = new Thread(() -> LogUtils.d("has sub thread join"));

        LogUtils.d("main thread start");
        joinThread.join();
        LogUtils.d("main thread end");
        // 输出 start -> join -> end
        // 线程A调用join后，原来的线程B将暂停（插队）
    }
    void yield() {
        new Thread(() -> {}, "1").start();
        new Thread(() -> {}, "2").start();
        // 暂停当前线程，执行其他线程 (可能不会暂停)
    }
    void interrupt() {
        // 中断
    }

    /**安全*/
    volatile boolean flag;
    void volatile_() {
        new Thread(() -> {
            try {
                Thread.sleep(100);
                flag = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                LogUtils.d(flag);
            }
        }).start();
        // 输出  若不加 volatile, 100ms 后仍输出 false
        // 原因  while(true) 执行效率太高，没有机会去内存取值
        // 可见性  多个线程同时使用一个对象，其中某个线程改变了该对象，其他线程需要感知其变化
    }
    void synchronized_() { //https://cloud.tencent.com/developer/article/1963334
        synchronized (this) {} //对象锁 (锁代码块)
        class T {
            synchronized void synchronized_() {} //对象锁 (锁方法)
            void m() {
                synchronized (T.class) {} //类锁 (用于锁静态方法/变量)(静态的在内存只有1份)
            }
        }
        // 所有对象都自带一个互斥锁，由 JVM 自动获取和释放
        // 进入 synchronized 方法时获取对象锁，若锁被占用则等待其释放

        // 原子性  一系列操作将会全部执行/不执行
        // 可见性  释放锁会写入内存，获取锁会读取内存
        // 有序性
    }
    void lock() {}
    void reentrantLock() {}
    void reentrantReadWriteLock() {}

    /**优先级*/
    void priority() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) LogUtils.d(Thread.currentThread().getName());
        }, "1");
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) LogUtils.d(Thread.currentThread().getName());
        }, "2");

        thread1.setPriority(Thread.MIN_PRIORITY); //1
        thread2.setPriority(Thread.MAX_PRIORITY); //10

        thread1.start();
        thread2.start();
        // 输出  2 -> 1 -> 2 -> 2 -> 1 -> 1
        // 优先级高的线程获取cpu资源的概率较大，不是绝对优先，它取决于cpu的调度算法
    }
}
