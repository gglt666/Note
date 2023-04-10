package pers.gglt.note.screen.rotate;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.provider.Settings;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Rotate {
    /**动态实现*/
    class DynamicRotate extends AppCompatActivity {
        @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR); //在setContentView前调用
            setContentView(null);
        }
        @Override protected void onSaveInstanceState(Bundle outState) { //旋转前调用
            super.onSaveInstanceState(outState);
            outState.putString("key","val");
        }
        @Override protected void onRestoreInstanceState(Bundle savedInstanceState) { //旋转后调用
            super.onRestoreInstanceState(savedInstanceState);
            if(savedInstanceState != null) {savedInstanceState.getInt("key");}
        }
    }
    /**静态实现*/
    // android:screenOrientation="sensor" (由重力传感器决定屏幕方向)
    // android:configChanges="orientation" (不会销毁数据)
    class staticRotate extends AppCompatActivity {
        @Override public void onConfigurationChanged(@NonNull Configuration newConfig) { //旋转后回调
            super.onConfigurationChanged(newConfig);
        }
    }

    /**判断是否开启了屏幕自动旋转*/
    boolean isScreenAutoRotate(Context context) {
        int gravity = 0;
        try {
            gravity = Settings.System.getInt(context.getContentResolver(), Settings.System.ACCELEROMETER_ROTATION);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return gravity == 1;
    }
}
