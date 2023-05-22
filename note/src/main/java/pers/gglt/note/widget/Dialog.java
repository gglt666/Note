package pers.gglt.note.widget;

import android.app.AlertDialog;

public class Dialog {
    // 分类 (AlertDialog)(PopupWindow)


    /***
     * 使用 {@link #useAlertDlg()}
     * 使用 {@link #usePopWindow()}
     */
    void useAlertDlg() {
        new AlertDialog.Builder(null)
                .setTitle("")
                .setMessage("")
                .setCancelable(false)
                .setNeutralButton("", null)
                .setNegativeButton("", null)
                .setPositiveButton("", null)
                .create().show();
    }

    void usePopWindow() {

    }

}
