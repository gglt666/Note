package pers.gglt.note.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Broadcast_Receiver {
    /** 静态注册 */
    // 优点   APP 未启动就能收到广播

    /** 动态注册 */
    // 优点   灵活（随时注册/注销）
    // 缺点   APP 启动后才能收到广播
    class receiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
        }
    }
}
