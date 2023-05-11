package pers.gglt.note.process;

public class Communication {
    /**分类*/
    // Binder (Intent,Messenger,AIDL,ContentProvider,文件共享)
    // Socket


    /**Intent*/
    // 场景 (4大组件间通信)
    // 优缺点 (便利)(数据类型少)
    // 通过Bundle传递数据

    /**Messenger*/
    // 优缺点 (一对多)(不支持并发)(数据类型少)
    // 原理 (可在不同进程中传递携带数据的messenger对象)
    // 实现 (服务端)(客户端)
    //      服务端Service,通过MessengerHandler处理
    //      客户端绑定Service,通过Messenger向Service发Message
    // https://cloud.tencent.com/developer/beta/article/2195383?areaSource=&traceId=

    /**AIDL*/
    // 优缺点 (一对多)(并发)(需线程同步)

    /**ContentProvider*/
    // 场景 (不同应用间通信)

    // 优缺点 (便利)(不适合高并发)(数据类型少)

    /**文件共享*/
    // 优缺点 (便利)(不适合高并发)(不实时)
    // 实现方式 ()

    /**socket*/
    // 优缺点 (网络传输)(一对多)(并发)(不支持RPC)





}
