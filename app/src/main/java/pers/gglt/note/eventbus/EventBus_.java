package pers.gglt.note.eventbus;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class EventBus_ {

    /**使用步骤*/
    // 定义事件订阅者
    @Subscribe
    void onMessageEvent(String str) {}

    // 注册与注销事件订阅者
    class MyActivity extends Activity {
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EventBus.getDefault().register(this); //
        }
        protected void onDestroy() {
            super.onDestroy();
            EventBus.getDefault().unregister(this); //
        }
    }

    // 发布事件
    void postEvent() {
        EventBus.getDefault().post("");
    }

    /**使用*/
    //  https://cloud.tencent.com/developer/article/2099430?areaSource=103001.1&traceId=qKoE4iaYpIke3jcbf65_4

    /**原理*/
    // https://cloud.tencent.com/developer/article/2180928?areaSource=103001.3&traceId=qKoE4iaYpIke3jcbf65_4
}
