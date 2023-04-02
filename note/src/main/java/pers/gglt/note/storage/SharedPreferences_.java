package pers.gglt.note.storage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import org.junit.Test;

public class SharedPreferences_ extends Activity {

    /**
     * 用法
     */
    @Test
    void sp() {
        // 存储
        SharedPreferences sp = getSharedPreferences("", Context.MODE_PRIVATE);
        SharedPreferences.Editor spEditor = sp.edit();
        spEditor.putString("k","v").apply();
        spEditor.putString("k","v").commit();

        //取出
        String str = sp.getString("k",null);
    }
}
