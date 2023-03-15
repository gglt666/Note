package pers.gglt.note;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 强引用  概念  GC 不会回收该对象，除非没有引用关系 / null
 *        示例  Object obj = new Object()
 *        特点  容易造成内存泄漏
 *
 * 软引用  概念  内存不足时回收该对象（）
 *        特点  GC 回收前需通过算法判断是否回收
 *        场景  保存缓存数据
 *
 * 弱引用  概念  该对象被 GC 发现时回收
 *        特点  更快被 GC 回收
 *        场景  保存缓存数据
 *
 * 虚引用  概念  GC 发现该对象便回收
 *        场景  跟踪垃圾回收过程（当 GC 准备回收一个对象时，若发现有虚引用，就会将其加入引用队列，以通知应用程序对象的回收情况）
 */

/**
 * 弱引用 & 软引用
 *       区别  软引用对象需通过算法检查是否回收。弱引用对象是立即回收
 */
public class Object_ {

    void define() {
        Object obj = new Object(); //声明强引用

        //
        SoftReference<Object> sf = new SoftReference<>(obj);
        //
        WeakReference<Object> wf = new WeakReference<>(obj);
        //
        ReferenceQueue phantomQueue = new ReferenceQueue();
        PhantomReference<Object> pf = new PhantomReference<>(obj, phantomQueue);

        obj = null; //销毁强引用
    }

    void softReference() {
        // 假如有一个应用需要读取大量的本地图片：
        // 如果每次读取图片都从硬盘读取则会严重影响性能，如果一次性全部加载到内存中又可能造成内存溢出。
        // https://www.jianshu.com/p/56106abc1b41
    }
}
