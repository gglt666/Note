package pers.gglt.project.esptouch;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.blankj.utilcode.util.LogUtils;
import com.espressif.iot.esptouch.EsptouchTask;
import com.espressif.iot.esptouch.IEsptouchResult;
import com.espressif.iot.esptouch.util.ByteUtil;
import com.espressif.iot.esptouch.util.TouchNetUtil;

import java.util.List;

import pers.gglt.project.App;

public class SmartConfig {
    EsptouchTask task;
    byte[] apSsid, apBssid, apPwd;
    Context context = App.getContext();


    public static SmartConfig get() {
        return new SmartConfig();
    }

    void resultCallback() {
        task.setEsptouchListener(result -> {
            // Result callback
        });
    }

    public SmartConfig setWifiInfo(String ssid, String bssid, String pwd) {
        apPwd = ByteUtil.getBytesByString(pwd);
        apSsid = ByteUtil.getBytesByString(ssid);
        apBssid = TouchNetUtil.parseBssid2bytes(bssid);
        return this;
    }

    public void execTask() {
        new Thread(()-> {
            int expectResultCount = 1;
            task = new EsptouchTask(apSsid, apBssid, apPwd, context);
            List<IEsptouchResult> results = task.executeForResults(expectResultCount);
            LogUtils.d("666 = " + results);
//            IEsptouchResult first = results.get(0);
//            if (first.isCancelled()) return;
//            if (first.isSuc()) {
//                LogUtils.d("666 = " + first.getInetAddress());
//            }
        }).start();
    }

    void cancelTask() {
        task.interrupt();
    }
}
