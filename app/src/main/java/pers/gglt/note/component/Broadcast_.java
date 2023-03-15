package pers.gglt.note.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/**
 * 作用  组件间通信（同/不同 APP，同/不同进程内的组件）
 *
 * 种类  无序  由 context.sendBroadcast() 发送，不可拦截
 *      有序  由 context.sendOrderBroadcast() 发送，可拦截并修改数据后发送给下一接收者
 *      本地  由 localBroadcastManager.sendBroadcast() 发送，只在本 APP 中广播
 */

/**
 * 接收器
 * 注册方式  静态
 *            概念
 *            优点  APP 未启动就能收到广播
 *         动态
 *            使用  某类继承 BroadcastReceiver，重写 onReceive()
 *            优点  灵活（随时注册/注销）
 *            缺点  APP 启动后才能收到广播
 */

public class Broadcast_ {

    // 发送本地广播
    static void sendLocalBroadcast(Context context, String action) {
        Intent intent = new Intent(action); //action = Intent.ACTION_XXX
        LocalBroadcastManager manager = LocalBroadcastManager.getInstance(context);
        manager.sendBroadcast(intent);
    }

    // 动态注册接收器
    class Receiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {}
    }
}
