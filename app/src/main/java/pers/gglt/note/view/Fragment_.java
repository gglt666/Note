package pers.gglt.note.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

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
}
