package pers.gglt.project;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class TestForAndroid {
    @Test
    public void a() {
        if (NetworkUtils.isWifiConnected()) {
            String ssid = NetworkUtils.getSSID();
            System.out.println(ssid);
        } else {
            LogUtils.e("Wifi没有连接");
        }
    }
}