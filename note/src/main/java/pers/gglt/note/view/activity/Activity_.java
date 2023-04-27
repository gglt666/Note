package pers.gglt.note.view.activity;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_ extends AppCompatActivity {

    /**生命周期*/
    // 横竖屏切换 (是否设置android:configChanges) (onConfigurationChanged)
    // 锁屏 (pause,stop)
    // 开屏 (start,resume)
    // 退至后台 (pause,stop)
    // 回至前台 (restart,start,resume)
    // 内存不足 (pause,stop,destroy)

    // create (创建)
    // restart (从堆栈中调用)
    // start (可见)
    // resume ()
    // pause (保存状态) (非全屏/透明Act覆盖)
    // stop (不可见) (非透明Act覆盖)
    // destroy (销毁)

    /**设置窗口样式*/
    // android:theme="@android:style/Theme.Dialog"

    /**修改进入和退出动画*/
    // 在清单中指定主题
    // 重写pendingTransition

    /**异常退出*/
    // pause,saveInstanceState,stop,destroy (pause和save顺序不一定)

    /**异常退出后重启*/
    // create,start,restoreInstanceState,resume

    /**onNewIntent*/
    // 时机 (SingleTask/SingleInstance) (当前实例位于栈顶的singleTop)
    // 顺序 (newIntent，restart，start，resume)

    /**启动模式*/
    // standard (每次创建新实例入栈)
    // singleTop (若在栈顶则复用,否则同standard) (复用不会执行create)
    // singleTask (不创建新实例,销毁其他实例成为栈顶) (适用于仅有一个Act的情况,如主页)
    // singleInstance (独占一个栈)

    /**指定启动模式*/
    // 静态 (清单文件指定)
    // 动态 (intent.addFlags()) (优先级高于静态) (无法指定为singleInstance)

    /**跳转时携带页面參数*/
    //https://zhuanlan.zhihu.com/p/449585533

    /**启动销毁速度/用户体验*/
    // create和pause中不能执行耗时操作

    /**标记位*/
    // FLAG_ACTIVITY_NEW_TASK (singleTask)
    // FLAG_ACTIVITY_SINGLE_TOP (singleTop)
    // FLAG_ACTIVITY_CLEAN_TOP (与singleTask作用相同)

    /**Intent传递数据大小限制*/
    // 数据大小在1MB之内

    /**SaveInstanceState*/
    // 调用 (内存不足,Home,异常,锁屏,方向切换,启动新Act)


}
