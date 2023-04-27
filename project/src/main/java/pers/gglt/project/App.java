package pers.gglt.project;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class App extends Application {
    private static App app;
    private static Context context;
    private MutableLiveData<String> broadcastData;

    @Override public void onCreate() {
        super.onCreate();
        app = this;
        context = getApplicationContext();
        broadcastData = new MutableLiveData<>();
    }

    public static App get() {return app;}

    public static Context getContext() {return context;}

    public void observeBroadcast(LifecycleOwner owner, Observer<String> observer) {
        broadcastData.observe(owner, observer);
    }
}
