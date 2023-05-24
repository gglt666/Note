package pers.gglt.project;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import pers.gglt.project.base.BaseActivity;
import pers.gglt.project.databinding.ActMainBinding;
import pers.gglt.project.esptouch.SmartConfig;
import pers.gglt.project.esptouch.TouchNetUtil;
import pers.gglt.project.gesture.ImageAct;
import pers.gglt.project.senor.orientation.OrientationListener;

public class MainActivity extends BaseActivity {
    ActMainBinding binding;
    OrientationListener orientationListener;

    @Override
    public void widgetClick(View v) {
    }

    @Override
    public void initParams(Bundle params) {
    }


    @Override
    public void bindLayout() {
        binding = ActMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public void initView(View view) {
        binding.btnImage.setOnClickListener(v -> {
            startActivity(new Intent(this, ImageAct.class));
        });


        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 1; i <= 5; i++) {
            System.out.println("queue = " + i);
            try {
                Thread.sleep(2000);
                pool.execute(() -> {
                    try {
                        Thread.sleep(12000);
                        System.out.println(666);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            return;
//        } else {
//            NetworkUtils.registerNetworkStatusChangedListener(new NetworkUtils.OnNetworkStatusChangedListener() {
//                @Override
//                public void onDisconnected() {}
//
//                @Override
//                public void onConnected(NetworkUtils.NetworkType networkType) {
//                    LogUtils.e("type = " + networkType);
//                }
//            });
//            NetworkUtils.addOnWifiChangedConsumer(wifiScanResults -> {
//                LogUtils.d(wifiScanResults);
//                LogUtils.d(wifiScanResults.getAllResults());
//            });
//        }

    }

    @Override
    public void setListeners() {
        orientationListener = new OrientationListener(this);
        if (orientationListener.canDetectOrientation()) orientationListener.enable();
    }

    @Override
    public void unsetListeners() {
        orientationListener.disable();
    }

    @Override
    public void doBusiness(Context mContext) {
    }
}
