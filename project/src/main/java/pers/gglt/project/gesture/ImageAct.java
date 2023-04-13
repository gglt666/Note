package pers.gglt.project.gesture;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import androidx.appcompat.app.AppCompatActivity;

import pers.gglt.project.databinding.ActImageBinding;

public class ImageAct extends AppCompatActivity {
    ActImageBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.iv.setOnTouchListener(new TouchListener());
    }

    class TouchListener implements OnTouchListener {
        private PointF startPoint = new PointF();
        private Matrix matrix = new Matrix();
        private Matrix currentMatrix = new Matrix(); //存放照片当前的矩阵
        private int mode; //确定是放大还是缩小
        private static final int DRAG = 1; //拖拉模式
        private static final int ZOOM = 2; //缩放模式
        private float startDis; //开始距离
        private PointF midPoint; //中心点

        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction() & MotionEvent.ACTION_MASK) { //得到低八位才能获取动作，所以要屏蔽高八位(通过与运算&255)
                case MotionEvent.ACTION_DOWN: //手指下压
                    mode = DRAG;
                    currentMatrix.set(binding.iv.getImageMatrix()); //记录当前的移动位置
                    startPoint.set(event.getX(), event.getY());
                    break;
                case MotionEvent.ACTION_MOVE: //手指在屏幕移动,该事件会不断被调用
                    if (mode == DRAG) {
                        float dx = event.getX() - startPoint.x; //得到在x轴的移动距离
                        float dy = event.getY() - startPoint.y; //得到在y轴的移动距离
                        matrix.set(currentMatrix); //在没有进行移动之前的位置基础上进行移动
                        matrix.postTranslate(dx, dy);
                    } else if (mode == ZOOM) { //缩放模式
                        float endDis = distance(event); //结束距离
                        if (endDis > 10f) { //防止不规则手指触碰
                            float scale = endDis / startDis; //结束距离除以开始距离得到缩放倍数
                            //通过矩阵实现缩放
                            //参数：1.2.指定在xy轴的放大倍数;3,4以哪个参考点进行缩放
                            //开始的参考点以两个触摸点的中心为准
                            matrix.set(currentMatrix); //在没有进行缩放之前的基础上进行缩放
                            matrix.postScale(scale, scale, midPoint.x, midPoint.y);
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP: //手指离开屏幕
                case MotionEvent.ACTION_POINTER_UP: //双指其中之一离开屏幕
                    mode = 0;
                    break;
                case MotionEvent.ACTION_POINTER_DOWN: //第二只手指触屏
                    mode = ZOOM;
                    startDis = distance(event);
                    if (startDis > 10f) { //防止不规则手指触碰
                        midPoint = mid(event);
                        currentMatrix.set(binding.iv.getImageMatrix());//记录ImageView当前的缩放倍数
                    }
                    break;
                default:
                    break;
            }
            binding.iv.setImageMatrix(matrix); //将imageView的矩阵位置改变
            return true;
        }
    }

    //计算两点之间的距离(勾股定理)
    public float distance(MotionEvent event) {
        float dx = event.getX(1) - event.getX(0);
        float dy = event.getY(1) - event.getY(0);
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    //计算两个点的中心点
    public static PointF mid(MotionEvent event) {
        float midx = (event.getX(1) + event.getX(0)) / 2;
        float midy = (event.getY(1) + event.getY(0)) / 2;
        return new PointF(midx, midy);
    }
} 