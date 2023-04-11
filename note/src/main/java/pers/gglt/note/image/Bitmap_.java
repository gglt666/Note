package pers.gglt.note.image;

import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.widget.ImageView;

import java.io.IOException;

public class Bitmap_ {
    Bitmap bitmap = Bitmap.createBitmap((Bitmap) null);
    /**概念*/
    // 像素点阵

    /**颜色格式*/
    // ARGB_8888  32bit
    // ARGB_4444  16bit
    // RGB_565    16bit
    // ALPHA_8    8bit
    // 含义  透明度+红+绿+蓝_每个值用几个bit存储

    /**内存计算*/
    // 内存大小 = 分辨率 * 每个像素点大小
    // 系统会根据 drawable 下的不同目录对图片进行分辨率的转换
    //    新图高度 = 原图高度 * (屏幕 dpi / 目录 dpi)
    //    新图宽度 = 原图宽度 * (屏幕 dpi / 目录 dpi)

    // 屏幕 dpi 越高内存越大， 目录 dpi 越低内存越大

    void getMemorySize() {
        bitmap.getByteCount();
        bitmap.getAllocationByteCount();
    }

    /**回收*/
    // 一般情况下，图像数据存在于 JVM 的堆中
    // 可不调用recycle，但要把 bitmap 引用置为 null
    // https://www.jianshu.com/p/76bbdc4bcad8

    void recycle() {
        bitmap.recycle(); //可释放 native 分配的内存
    }
    
    /**加载*/
    //https://cloud.tencent.com/developer/article/1179540?areaSource=103001.5&traceId=5uG8WsCBbTXaH3P37MUSA

    /**优化*/
    // 降低分辨率
    // 减少像素点大小

    /**OOM*/
    //https://blog.csdn.net/leansmall/article/details/50359148

    /**大图加载*/
    //https://cloud.tencent.com/developer/article/1176066?areaSource=103001.2&traceId=nuzKUw9LM2-OPP5n8l65B
    //https://cloud.tencent.com/developer/article/2027965?areaSource=103001.5&traceId=nuzKUw9LM2-OPP5n8l65B

    /**区域加载*/
    // 作用: 只显示大图的一部分
    void regionLoad() throws IOException {
        ImageView imgView = null;
        BitmapRegionDecoder decoder = BitmapRegionDecoder.newInstance("");
        Bitmap bitmap = decoder.decodeRegion(null, null);
        imgView.setImageBitmap(bitmap);
    }
}
