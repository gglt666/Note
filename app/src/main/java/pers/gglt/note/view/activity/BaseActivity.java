package pers.gglt.note.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean isSteepStatusBar = true; //沉浸状态栏
    private boolean mAllowFullScreen = true; //全屏
    private boolean isAllowScreenRotate = false; //旋转
    private View contextView = null; //当前Activity渲染的View
    protected final String TAG = this.getClass().getSimpleName();

    public abstract void widgetClick(View v);
    public abstract void initParams(Bundle params);
    public abstract View bindView();
    public abstract int bindLayout();
    public abstract void initView(final View view);
    public abstract void setListener();
    public abstract void doBusiness(Context mContext);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParams(getIntent().getExtras());
        View view = bindView();
        if (isSteepStatusBar) steepStatusBar();
        if (mAllowFullScreen) requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (!isAllowScreenRotate) setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        contextView = bindView() == null ? LayoutInflater.from(this).inflate(bindLayout(), null) : view;
        initView(contextView);
        setContentView(contextView);
        setListener();
        doBusiness(this);
    }

    /**
     * [沉浸状态栏]
     */
    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION); //透明导航栏
        }
    }

    /**
     * [绑定控件] *
     * @param resId *
     * @return
     */
    protected <T extends View> T $(int resId) {
        return (T) super.findViewById(resId);
    }

    @Override
    public void onClick(View v) {
        widgetClick(v);
    }

    /**
     * [页面跳转]
     * * @param clz
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(BaseActivity.this, clz));
    }

    /**
     * [携带数据的页面跳转]
     * * @param clz * @param bundle
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);

        }
        startActivity(intent);
    }

    /** * [含有Bundle通过Class打开编辑界面]
     * * @param cls
     * @param bundle
     * @param requestCode
     */
    public void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    /**
     * [简化Toast]
     * @param msg
     */
    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * [是否允许屏幕旋转] *
     * @param isAllowScreenRoate
     */
    public void setScreenRotate(boolean isAllowScreenRoate) {
        this.isAllowScreenRotate = isAllowScreenRoate;
    }


    /**
     * [是否允许全屏] *
     * @param allowFullScreen */
    public void setAllowFullScreen(boolean allowFullScreen) {
        this.mAllowFullScreen = allowFullScreen;
    }

    /**
     * [是否设置沉浸状态栏] *
     * @param isSetStatusBar
     */
    public void setSteepStatusBar(boolean isSetStatusBar) {
        this.isSteepStatusBar = isSetStatusBar;
    }
}