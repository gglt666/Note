package pers.gglt.project;

import android.content.Context;
import android.view.OrientationEventListener;

public class OrientationListener extends OrientationEventListener {
    public OrientationListener(Context context) {
        super(context);
    }

    @Override
    public void onOrientationChanged(int i) {
        // 平放时，检测不到有效的角度
        if (i == OrientationEventListener.ORIENTATION_UNKNOWN) return;
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
}
