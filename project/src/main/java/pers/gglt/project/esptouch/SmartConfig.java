package pers.gglt.project.esptouch;

import android.content.Context;
import android.net.wifi.WifiInfo;

import com.blankj.utilcode.util.LogUtils;
import com.espressif.iot.esptouch.EsptouchTask;
import com.espressif.iot.esptouch.IEsptouchResult;
import com.espressif.iot.esptouch.util.ByteUtil;

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

    public SmartConfig setWifiInfo(WifiInfo wifiInfo, String pwd) {
        apPwd = ByteUtil.getBytesByString(pwd);
        apSsid = TouchNetUtil.getRawSsidBytesOrElse(wifiInfo, wifiInfo.getSSID().getBytes());
        apBssid = TouchNetUtil.parseBssid2bytes(wifiInfo.getBSSID());
        return this;
    }

    public void execTask() {
        new Thread(()-> {
            task = new EsptouchTask(apSsid, apBssid, apPwd, context);
            task.setPackageBroadcast(true);
            List<IEsptouchResult> results = task.executeForResults(5);

            for (IEsptouchResult result : results) {
                if (result.isSuc()) {
                    LogUtils.d("ip = " + result.getInetAddress());
                }
            }


        }).start();
    }

    void cancelTask() {
        task.interrupt();
    }
}
