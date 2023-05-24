package pers.gglt.note.view;

import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

public class Dispatch_Consume extends AppCompatActivity {
    // https://zhuanlan.zhihu.com/p/495859648
    /**分发流程*/
    // 离用户触摸点最近的控件响应触摸事件,若没有实现响应事件,则向父类传递事件,有view响应时,会将事件流传递给view中的onTouchEvent()
    // 传递 (activity > viewGroup > view)

    // 将点击事件传递到activity中,执行dispatchTouchEvent,分发至viewGroup,vg判断是否拦截,若拦截则act分发结束,反之调用onTouchEvent处理
    //

    /**消费流程*/
    // https://zhuanlan.zhihu.com/p/506890623
    // View > ViewGroup > Activity 从下往上依次调用onTouchEvent()，进行事件响应处理。
    // 事件如果在传递过程中被消费，整个分发流程则直接结束。

    /**分发,消费流程*/
    // act.dispatchTouchEvent > vg.dispatchTouchEvent > act.onTouchEvent
    //         true                      false
    // act.dispatchTouchEvent > vg.dispatchTouchEvent > vg.onInterceptTouchEvent
    //         true                      false                   true
    // act.dispatchTouchEvent > vg.dispatchTouchEvent > vg.onInterceptTouchEvent > v.dispatchTouchEvent > vg.onTouchEvent > act.onTouchEvent
    //         true                      true                    false                      false



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
