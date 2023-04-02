package pers.gglt.note.ndk;
//https://cloud.tencent.com/developer/article/1394197?areaSource=103001.4&traceId=VnfqWD1vHhX5ZRjNEr7Gj
public class Jni {
    /**核心*/
    // 生成和使用so文件 (share object,是机器可共享的二进制代码)

    /**作用*/
    // 调用C/C++代码 (Java通过Interface调用Native代码)

    /**优点*/
    // 安全性 (so库反编译困难)
    // 方便使用C/C++开源库
    // 提高移植性
    // 提高特定情况下的执行效率

    /**注册Jni函数*/
    // 静态注册

    static { //动态注册
        System.loadLibrary(""); //so文件在程序运行时加载
    }

    /**生成so*/
    // build.gradle添加externalNativeBuild和ndk配置
    // 编写CMakeLists
    // 写JNI接口
    // 写c++

}
