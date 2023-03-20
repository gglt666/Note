package pers.gglt.note.thread;

import java.util.concurrent.locks.LockSupport;

public class Thread_ {
    Thread thread = new Thread();
    /**概念*/
    // 某进程中一个单独运行的程序

    /**状态*/
    // New
    // Runnable
    // Blocked
    void blocked() {
        synchronized (this) {
        }
    }
    // Waiting
    void waiting() throws InterruptedException {
        thread.wait();
        thread.wait(100);
        thread.join();
        thread.join(100);
        LockSupport.park();
        LockSupport.parkNanos(100);
        LockSupport.parkUntil(100);
    }
    // Terminated

}
