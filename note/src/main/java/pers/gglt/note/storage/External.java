package pers.gglt.note.storage;

import android.os.Environment;

public class External {

    void getAbsolutePath() {
        Environment.getExternalStorageDirectory().getAbsolutePath(); //"/storage/emulated/0"
    }
}
