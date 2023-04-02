package pers.gglt.note.storage;

import android.database.ContentObserver;
import android.os.Handler;

public class ContentObserver_ extends ContentObserver {
    public ContentObserver_(Handler handler) {
        super(handler);
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
    }
}
