package pers.gglt.note.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

//https://cloud.tencent.com/developer/article/1874234?areaSource=103001.7&traceId=e4PjBXMfCHiQTtNhgY8dN
public class ViewBinding extends AppCompatActivity {
    /**作用*/
    // 实现优雅地从代码中引用布局文件中的控件

    /**优点*/
    // 简明
    // 编译安全
    // 编译速度

    /**使用*/
    // 开启viewBinding (module的gradle文件)   viewBinding {enabled = true}
    // 调用绑定类的inflate()获取实例对象并使用

    //private ActivityBinding viewBinding; //编译后生成的布局文件绑定类
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //viewBinding = ActivityBinding.inflate(getLayoutInflater());
        //setContentView(viewBinding.getRoot());
        //viewBinding.tvContent.setText("要么停止成长，要么不断向前");
        //viewBinding.imgShow.setImageResource(R.drawable.img);
    }
}
