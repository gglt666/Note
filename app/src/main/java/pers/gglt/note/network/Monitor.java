package pers.gglt.note.network;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

public class Monitor extends Activity {
    NetworkStateReceiver receiver;

    /**定义*/
    static class NetworkStateReceiver extends BroadcastReceiver {
        NetworkMonitor monitor;
        public void onReceive(Context context, Intent intent) {
            monitor.onNetworkStateChange();
        }

        interface NetworkMonitor {
            void onNetworkStateChange();
        }

        void setMonitor(NetworkMonitor listener) {
            monitor = listener;
        }
    }

    /**使用*/
    void setNetworkMonitor() {
        receiver = new NetworkStateReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

        receiver.setMonitor(() -> {
            // 网络状态已改变
        });

        registerReceiver(receiver, filter);
    }

    void unsetNetworkMonitor() {unregisterReceiver(receiver);}
}
