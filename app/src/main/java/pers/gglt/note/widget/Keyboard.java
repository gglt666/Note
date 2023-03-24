package pers.gglt.note.widget;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

public class Keyboard {
    /**禁止 EditText 自动弹出*/
    void forbidPopup() {
        // 在布局文件的 <EditText> 中 (取消自动获取焦点)
        // android:focusable="true" 和 android:focusableInTouchMode="true"

        // 在清单文件的 <Activity> 中
        // android:windowSoftInputMode="adjustResize|stateHidden"

        // getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    void hide(Context context, View view) {
        InputMethodManager manager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
