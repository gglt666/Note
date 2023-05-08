package pers.gglt.note.thread.communication;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

public class HandlerThread_ {
    /**特点*/
    // 线程内部实现了 Looper，可以在子线程中分发和处理消息

    /**使用*/
    void use() {
        HandlerThread handlerThread = new HandlerThread("");
        handlerThread.start();

        // 主线程
        Handler handler = new Handler(handlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };

        handlerThread.quit();
        handlerThread.quitSafely();
    }
}
