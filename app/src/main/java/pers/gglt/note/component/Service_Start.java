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
        context.stopService(intent);
    }

    /**
     * 生命周期
     */
    // 1
    public void onCreate() {
        super.onCreate();
    }

    // 2
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    // 3 服务运行中

    // 4 服务销毁
    public void onDestroy() {
        super.onDestroy();
    }

    // 不执行
    public IBinder onBind(Intent intent) {
        return null;
    }
}
