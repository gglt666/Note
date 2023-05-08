package pers.gglt.note.process;

/**
 * 概念  拥有若干线程
 *
 * 销毁时机  内存不足
 * 创建时机  其所属组件运行时
 *
 *
 * 默认情况下，APP的所有组件均在相同的进程中运行
 * 可指定某组件在某进程运行
 *
 * https://cloud.tencent.com/developer/article/1365678?areaSource=103001.2&traceId=Z54wqSoMMOM9nv_6QmI76
 */
public class Process {

    /**分类*/
    // 前台
    // 可见
    // 服务
    // 后台 (stop状态)
    // 空
}
