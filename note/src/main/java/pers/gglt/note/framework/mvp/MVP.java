package pers.gglt.note.framework.mvp;
public class MVP {
    /**结构*/
    // Model (提供数据给P)
    // View (展示/接收数据) (不进行业务处理)
    // Presenter (业务逻辑)

    /**优点*/
    // 解耦 (V和M不直接通信) (业务逻辑不在V，在P)
    // 便于逻辑测试 (不依赖V)

    /**缺点*/
    //由于对View的操作放在了Presenter中，所以View和Presenter的交互会过于频繁。如果Presenter过多地操作视图，往往会使得它与特定的 View联系过于紧密。一旦视图需要改变，那么Presenter也需要改变

    //https://cloud.tencent.com/developer/article/2027561?areaSource=103001.1&traceId=SUGRWFiDESrlWEgmszoun
}
