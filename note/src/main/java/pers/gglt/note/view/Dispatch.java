package pers.gglt.note.view;

import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

public class Dispatch extends AppCompatActivity {

    /**流程*/
    //离用户触摸点最近的控件响应触摸事件,若没有实现响应事件,则向父类传递事件,有view响应时,会将事件流传递给view中的onTouchEvent()

    @Override public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: break; //事件流开始
            case MotionEvent.ACTION_MOVE: break;
            case MotionEvent.ACTION_UP: break; //事件流结束
            case MotionEvent.ACTION_CANCEL: break; //事件流结束
        }
        return true; //本次事件流在这里消费,不会传递给父类进行处理
    }

    //https://cloud.tencent.com/developer/article/1770258?areaSource=103001.22&traceId=5-e5qS9hH4qylkNs4DdNm
}
