package pers.gglt.note.thread.communication;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

/**
 * 作用  跨线程通信
 *
 * 要素  Message
 *        分类  硬件消息\用户消息
 *      MessageQueue
 *        作用
 *        (会循环判读是否有消息)
 *      Handler
 *        作用  负责消息的发送和处理(Handler.sendMessage()和Handler.handleMessage())
 *             内部使用单链表，先进先出处理消息
 *      Looper
 *        创建时其内部会同时创建消息队列
 *        调用 loop() 时会循环调用 messageQueue.next()
 *        调用 quit() 时会调用 messageQueue.quit() 退出 loop()
 *        作用
 *
 * 流程  主\子线程均持有 Looper 和 Handler
 *      主线程持有 Message, MessageQueue, Handler, Looper
 *      子线程持有 Message2, MessageQueue2, Handler2, Looper2
 *      子线程通过 Handler2 获取 Looper2，再获取 MessageQueue2 后取出 Message2, 通过 Handler2.dispatchMessage 传递给 Handler1, 最终调用 Handler1.handleMessage 处理
 *
 * 1个 Thread 只能持有1个 MessageQueue, 1个 Looper, N个 Handler
 *
 */
public class Handler_ {
    Handler handler = new Handler();

    /**作用*/
    // 发送消息至 MessageQueue
    // 处理 Looper 发来的消息
    void sendMsg() {
        handler.sendMessage(null); //发送给已绑定 Looper 的消息队列
    }
    void handleMsg(@NonNull Message msg) {
       // ...
    }

    void a() {
        Looper mainLooper = Looper.getMainLooper();
        Handler handler1 = new Handler(); //默认绑定主线程的 Looper
        Handler handler2 = new Handler(mainLooper); //绑定了 Looper
    }
}
