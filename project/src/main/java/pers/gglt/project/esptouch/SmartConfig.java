package pers.gglt.project.esptouch;

import android.content.Context;

import com.espressif.iot.esptouch.EsptouchTask;
import com.espressif.iot.esptouch.IEsptouchResult;

import java.util.List;

public class SmartConfig {
    Context context; // Set Application context
    byte[] apSsid = {}; // Set AP's SSID
    byte[] apBssid = {}; // Set AP's BSSID
    byte[] apPassword = {}; // Set AP's password

    EsptouchTask task = new EsptouchTask(apSsid, apBssid, apPassword, context);

    void resultCallback() {
        task.setEsptouchListener(result -> {
            // Result callback
        });
    }

   void ExecuteTask() {
       int expectResultCount = 1;
       List<IEsptouchResult> results = task.executeForResults(expectResultCount);
       IEsptouchResult first = results.get(0);
       if (first.isCancelled()) {
           return;
       }
       if (first.isSuc()) {

       }
   }

   void cancelTask() {
       task.interrupt();
   }
}
