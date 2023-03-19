package pers.gglt.note.thread;

public class ThreadPool {
    /**优点*/
    // 性能（减少创建、销毁的开销）
    // 管理（可定时定期执行、控制并发数）


    /**类型*/
    void cacheThreadPool() {
        // 特点  没有核心线程，为每个任务创建新线程或利用空闲线程执行(60s空闲时间)
        // 优点  立即执行任务
        // 场景  大量短时任务

    }

    void fixedThreadPool() {//
        // 特点  全部是核心线程
        // 优点  更快响应外界请求
        // 缺点  占用一定系统资源
    }

    void scheduledThreadPool() {
        // 特点  核心线程数量固定，非核心线程数量不固定
        // 场景  执行定时或固定周期任务
    }

    void singleThreadExecutor() {
        // 特点  只有一个核心线程，任务按顺序执行
        // 优点  无需处理同步问题
    }
}
