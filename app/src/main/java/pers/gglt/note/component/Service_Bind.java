package pers.gglt.note.component;


import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import pers.gglt.note.application.Application_;


public class Service_Bind extends Service {
    Intent intent = new Intent();
    Context context = Application_.getContext();
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {}

        @Override
        public void onServiceDisconnected(ComponentName componentName) {}
    };

    /** 使用方式*/
    void bindService() {
        context.bindService(intent, connection, 0);
    }

    void stopService() {
        context.unbindService(connection);
    }

    /** 生命周期 */
    // onCreate、onBind、运行中、onUnbind、onDestroy

    // 只会调用 1 次
    public void onCreate() {
        super.onCreate();
    }

    //
    public IBinder onBind(Intent intent) {
        return null;
    }

    //
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    // unbindService
    // Context 不存在（如 Activity.finish()）
    public void onDestroy() {
        super.onDestroy();
    }

    // 不会调用
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    //
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    /**
     * 当 start 后 bind，需调用 stop 而不是 unbind 才能停止服务
     */
}
