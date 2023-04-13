package pers.gglt.project.gesture;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import pers.gglt.project.R;
import pers.gglt.project.databinding.ActivityImageBinding;
import pers.gglt.project.databinding.ActivityMainBinding;

public class ImageActivity extends AppCompatActivity {
    private int mode = NONE;
    ActivityImageBinding binding;
    private float oriDis = 1f; //初始的两个手指按下的触摸点的距离
    private static final int NONE = 0;
    private static final int DRAG = 1;
    private static final int ZOOM = 2;
    private Matrix matrix = new Matrix();
    private Matrix savedMatrix = new Matrix();
    private PointF startPoint = new PointF(); //第一个按下的手指的点
    private PointF midPoint = new PointF(); //双指的触摸点的中点

    @SuppressLint("ClickableViewAccessibility")
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImageBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_image);

        binding.iv.setOnLongClickListener(v -> true);
        binding.iv.setOnTouchListener((v, event) -> {
            ImageView view = (ImageView) v;
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN: //单点触控
                    matrix.set(view.getImageMatrix());
                    savedMatrix.set(matrix);
                    startPoint.set(event.getX(), event.getY());
                    mode = DRAG;
                    break;
                case MotionEvent.ACTION_POINTER_DOWN: //多点触控
                    oriDis = distance(event);
                    if (oriDis > 10f) {
                        savedMatrix.set(matrix);
                        midPoint = midPoint(event);
                        mode = ZOOM;
                    }
                    break;
                case MotionEvent.ACTION_MOVE: //滑动事件
                    if (mode == DRAG) { //单指拖动
                        matrix.set(savedMatrix);
                        matrix.postTranslate(event.getX() - startPoint.x, event.getY() - startPoint.y);
                    } else if (mode == ZOOM) { //双指滑动
                        float newDist = distance(event);
                        if (newDist > 10f) {
                            matrix.set(savedMatrix);
                            float scale = newDist / oriDis;
                            matrix.postScale(scale, scale, midPoint.x, midPoint.y);
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_POINTER_UP: //手指放开
                    mode = NONE;
                    break;
            }
            view.setImageMatrix(matrix);
            return true;
        });
    }

    /**
     * 计算两个手指头之间的中心点的位置
     * x = (x1+x2)/2;
     * y = (y1+y2)/2;
     *
     * @param event 触摸事件
     * @return 返回中心点的坐标
     */
    private PointF midPoint(MotionEvent event) {
        float x = (event.getX(0) + event.getX(1)) / 2;
        float y = (event.getY(0) + event.getY(1)) / 2;
        return new PointF(x, y);
    }

    /**
     * 计算两个手指间的距离
     *
     * @param event 触摸事件
     * @return 放回两个手指之间的距离
     */
    private float distance(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);//两点间距离公式
    }
}