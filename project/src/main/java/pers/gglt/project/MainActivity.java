package pers.gglt.project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import pers.gglt.project.base.BaseActivity;
import pers.gglt.project.databinding.ActivityMainBinding;
import pers.gglt.project.gesture.ImageActivity;
import pers.gglt.project.senor.orientation.OrientationListener;

public class MainActivity extends BaseActivity {
    ActivityMainBinding binding;
    OrientationListener orientationListener;

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public View bindView() {
        return null;
    }

    @Override
    public int bindLayout() {
        return 0;
    }

    @Override
    public void initView(View view) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnImage.setOnClickListener(v -> {
            startActivity(new Intent(this, ImageActivity.class));
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
