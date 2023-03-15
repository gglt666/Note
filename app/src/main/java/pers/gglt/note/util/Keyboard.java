package pers.gglt.note.util;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

public class Keyboard {
    Context context;

    void hide() {
        LinearLayout ll = new LinearLayout(context);
        InputMethodManager manager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(ll.getWindowToken(), 0);
    }
}
