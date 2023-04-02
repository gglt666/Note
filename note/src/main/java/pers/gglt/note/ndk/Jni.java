package pers.gglt.note.ndk;

public class Jni {
    /**作用*/
    // 调用 C/C++ 代码

    /**优点*/
    // 安全性（so库反编译困难）
    // 方便使用 C/C++ 开源库
    // 提高移植性
    // 提高特定情况下的执行效率

    /**注册 JNI 函数*/
    // 静态注册
    // 动态注册

    static {
        System.loadLibrary("");
    }
}
