package pers.gglt.project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.blankj.utilcode.util.FragmentUtils;

import pers.gglt.project.base.BaseActivity;
import pers.gglt.project.databinding.ActMainBinding;
import pers.gglt.project.gesture.ImageAct;
import pers.gglt.project.senor.orientation.OrientationListener;

public class MainActivity extends BaseActivity {
    ActMainBinding binding;
    OrientationListener orientationListener;

    @Override public void widgetClick(View v) {

    }

    @Override public void initParams(Bundle params) {}


    @Override public void bindLayout() {
        binding = ActMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public void initView(View view) {
        binding.btnImage.setOnClickListener(v -> {
//            FragmentUtils.add(getSupportFragmentManager(), new Fragment());
            startActivity(new Intent(this, ImageAct.class));
        });
    }

    @Override
    public void setListeners() {
        orientationListener = new OrientationListener(this);
        if (orientationListener.canDetectOrientation()) orientationListener.enable();
    }

    @Override
    public void unsetListeners() {
        orientationListener.disable();
    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
