package pers.gglt.note.component;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import pers.gglt.note.application.Application_;

public class Service_Start extends Service {
    Intent intent = new Intent();
    Context context = Application_.getContext();

    void startService() {
        context.startService(intent);
    }

    void stopService() {
        this.stopSelf();
        context.stopService(intent);
    }

    /**
     * 生命周期
     *    onCreate、onStart、运行中、onDestroy
     */
    // 只会调用 1 次（单例）
    public void onCreate() {
        super.onCreate();
    }

    // 能调用多次
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    // 3 服务运行中

    // 只会调用 1 次
    public void onDestroy() {
        super.onDestroy();
    }

    // 不执行
    public IBinder onBind(Intent intent) {
        return null;
    }
}
