package pers.gglt.note.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pers.gglt.note.R;

public class Fragment_ extends Fragment {
    /**与 Activity 通信*/
    //https://www.jianshu.com/p/1b824e26105b/

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(0, container, false);
        view.setClickable(true); //防止点击穿透
        view.setOnTouchListener((v, motionEvent) -> true);
        return view;
    }


    /**防止Activity销毁导致Fg关闭*/
    class avoidDestroyFg extends Fragment {
        @Override public void onAttach(@NonNull Context context) {
            super.onAttach(context);
            setRetainInstance(true);
            //一旦发生Activity重组现象，Fragment会跳过onDestroy直接进行onDetach（界面消失、对象还在）
            // 而Fg重组时候也会跳过onCreate,而onAttach和onActivityCreated还是会被调用。
            // 使用后的Fragment不能加入backstack中。并且该实例不会保持太久，若长时间没有容器会被系统回收
        }
    }
}
