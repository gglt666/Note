package pers.gglt.note.screen.rotate;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class AccelerationSenorListener implements SensorEventListener {
    Sensor sensor;
    Activity activity;
    SensorManager sensorManager;
    float lastX, lastY, lastZ;

    public void enableSensor() { //onResume调用
        sensorManager = (SensorManager) activity.getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public void disableSensor() { //onPause调用
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            sensorManager = null;
        }
    }

    @Override public void onSensorChanged(SensorEvent event) {
        if (event.sensor == null) return;
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            lastX = event.values[SensorManager.DATA_X];
            lastY = event.values[SensorManager.DATA_Y];
            lastZ = event.values[SensorManager.DATA_Z];

            //角度计算 https://cloud.tencent.com/developer/article/1730602?areaSource=103001.4&traceId=6DDDU8Ww2f3aDltwQ8Osx

            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @Override public void onAccuracyChanged(Sensor sensor, int i) {}
}
