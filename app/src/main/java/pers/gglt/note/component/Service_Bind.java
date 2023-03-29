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
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {}
        public void onServiceDisconnected(ComponentName componentName) {}
    };

    /** 使用方式*/
    void register() {} //清单文件注册
    void bindService() {
        context.bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    void stopService() {
        context.unbindService(connection);
    }



    /** 生命周期 */ // onCreate、onBind、运行中、onUnbind、onDestroy
    public void onCreate() {super.onCreate();} //只会调用1次
    public IBinder onBind(Intent intent) {
        return null;
    } //可调用多次
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
    public void onDestroy() {
        super.onDestroy();
        // unbindService
        // Context 不存在（如 Activity.finish()）
    }
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    /**
     * 当 start 后 bind，需调用 stop 而不是 unbind 才能停止服务
     */
}
