package pers.gglt.note.z_other.network;

public class Socket {
    /**特点*/
    // 可自定义通信协议
    // 服务端可主动向客户端通信

    /**通道模型*/
    // TCP (持续性) (流式通信)
    // Client向Server的输出流写数据后发送，反之
    // Client读取Server数据，实际上就是拿到Server的输入流（inputStream）去读（read），反之

    // UDP (发送的数据报不一定以相同的次序到达接收方)
    // 通过封装 DatagramPacket 通信 (https://ask.qcloudimg.com/http-save/yehe-3147491/jxbddb9d49.png?imageView2/2/w/2560/h/7000)

    /**心跳*/
    // https://cloud.tencent.com/developer/article/2134992?areaSource=103001.7&traceId=0RtArLv60qQ9z72lwiLeR
}
