package pers.gglt.note.communication;
import android.os.Looper;

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
    void a() {
        Looper.myQueue();
    }
}
