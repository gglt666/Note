package pers.gglt.note.framework.mvp;
// https://cloud.tencent.com/developer/article/1563098?areaSource=103001.2&traceId=typ8abI7-aR5exGUhgPOt
public class MVP {
    /**结构*/
    // Model (提供数据给P)
    // View (展示/接收数据) (不进行业务处理)
    // Presenter (业务逻辑)
    // https://ask.qcloudimg.com/http-save/yehe-2197533/90zgka7ck4.png?imageView2/2/w/2560/h/7000

    /**优点*/
    // 模型与视图完全分离 (可修改视图而不影响模型)
    // 可将一个视图用于多个视图，而不需要改变Presenter内部的逻辑
    // 可以脱离用户接口进行逻辑测试

    /**缺点*/
    //由于对View的操作放在了Presenter中，所以View和Presenter的交互会过于频繁。如果Presenter过多地操作视图，往往会使得它与特定的 View联系过于紧密。一旦视图需要改变，那么Presenter也需要改变
}
