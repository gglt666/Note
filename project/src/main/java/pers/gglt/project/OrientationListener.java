package pers.gglt.project;

import android.content.Context;
import android.util.Log;
import android.view.OrientationEventListener;

public class OrientationListener extends OrientationEventListener {
    public OrientationListener(Context context) {
        super(context);
    }

    @Override
    public void onOrientationChanged(int i) {
        if (i == OrientationEventListener.ORIENTATION_UNKNOWN) return; //平放
        if (i > 350 || i < 10) { //0度
            i = 0;
        } else if (i > 80 && i < 100) { //90度
            i = 90;
        } else if (i > 170 && i < 190) { //180度
            i = 180;
        } else if (i > 260 && i < 280) { //270度
            i = 270;
        }
    }

    //相机持续正向  https://cloud.tencent.com/developer/article/1193462?areaSource=103001.2&traceId=RQKkG4F29u73QskfAwNOP
}
