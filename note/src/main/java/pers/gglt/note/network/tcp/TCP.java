package pers.gglt.note.network.tcp;

public class TCP {
    /**OSI七层模型*/
    // ...
    // 会话层
    // 表示层
    // 应用层

    /**TCP/IP五层模型*/
    // 物理层
    // 数据链路层
    // 网络层
    // 传输层
    // 应用层

    /**三次握手流程*/
    // 客户端发送SYN报文给服务器 (起始序列号SEQ=x)
    // 服务端返回确认号和其起始序列号 (ACK=x+1,SEQ=y)
    // 客户端返回确认号 (ACK=y+1)

    /**四次挥手流程*/
    // 客户端发送断连请求报文 (SEQ=x)
    // 服务端返回ACK和SYN报文 (ACK=x+1,SEQ=y)
    // 服务端发送断连请求报文 (SEQ=z, ACK=x+1)
    // 客户端返回确认报文  (SEQ=x+1,ACK=z+1)

    /**三次握手原因/二次握手隐患*/
    // 通信双方各自维护一个序列号 (标识发送的包是否被接收), 通信前需要相互确认双方的起始序列号
    // 只有三次握手才能互相告知序列号起始值并确认接收情况
    // 二次握手只能确认客户端的序列号被确认, 服务端的序列号不能确认

    /**优点*/
    // 可靠 (不会丢包和乱序)

    /**缺点*/
    // 开销大 (粘包问题的解决本质也是产生额外开销)
    // 一对一
}
