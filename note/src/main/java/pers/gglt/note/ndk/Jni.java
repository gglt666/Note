package pers.gglt.note.ndk;

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

    /**使用so*/
    // jniLibs.srcDirs=['libs'] (将so文件目录指定为libs文件夹)
    // System.loadLibrary("native2-lib");

    // gradle在构建APK时，一定是指定了好几个工程中存放.so文件的目录。在build时，会遍历这些目录，并将指定目录下的.so文件复制到APK包中。如果名字相同的.so文件，则会相互覆盖。由于LibraryA是先build的，所以LibraryA中的.so文件会被ProjectA中的.so文件覆盖。
}
