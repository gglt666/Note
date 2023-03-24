package pers.gglt.note.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    /**优点*/
    // 性能（减少创建、销毁的开销）
    // 管理（可定时定期执行、控制并发数）

    /**参数*/
    void parameters() {
        int corePoolSize = 0; //
        int maximumPoolSize = 0; //
        long keepAliveTime = 0L;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = null;
        ThreadFactory threadFactory = null;
        new ThreadPoolExecutor(
                corePoolSize, maximumPoolSize, keepAliveTime,
                timeUnit, workQueue, threadFactory);

        // 池内有若干核心和非核心线程, 最大线程数 = 两者之和
    }

    /**关闭流程*/
    void shutdown() {
        // https://cloud.tencent.com/developer/article/1963812
    }

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
