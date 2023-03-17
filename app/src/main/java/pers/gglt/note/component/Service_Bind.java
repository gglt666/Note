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
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    /**
     * 使用方式
     */
    void bindService() {
        context.bindService(intent, connection, 0);
    }

    /**
     * 生命周期
     */
    // 1
    public void onCreate() {
        super.onCreate();
    }

    // 2
    public IBinder onBind(Intent intent) {
        return null;
    }

    // 3 服务运行中

    // 4
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }


    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy() {
        super.onDestroy();
    }


    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }
}
