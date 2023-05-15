package pers.gglt.note.thread.communication;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class HandlerThread_ {
    /**特点*/
    // 线程内部实现了Looper,可以在子线程中分发和处理消息

    /**使用 {@link #use()}*/




    void use() {
        HandlerThread handlerThread = new HandlerThread("");
        handlerThread.start();

        Handler handler = new Handler(handlerThread.getLooper()) { //关联HandlerThread的Looper,实现消息处理操作
            @Override public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };

        handler.sendMessage(null);

        handlerThread.quit();
        handlerThread.quitSafely();
    }
}
