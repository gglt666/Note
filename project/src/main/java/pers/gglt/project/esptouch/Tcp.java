package pers.gglt.project.esptouch;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Tcp {
    Socket socket;

    public static Tcp get() {
        return new Tcp();
    }

    private byte[] msg = new byte[2];
    final Thread socketThread = new Thread(() -> {
        Socket socket = null;
        //创建socket
        try {
            socket = new Socket("192.168.1.1", 8000); //ip + 端口号

            msg[0] = (byte) 0xaa;
            msg[1] = (byte) 0xdd;

            // 向服务器端发送消息
            OutputStream socketWriter = socket.getOutputStream();
            System.out.println("开始发送");

            socketWriter.write(msg);
            socketWriter.flush();
            System.out.println("发送完毕，开始接收信息");

            // 接收来自服务器端的消息
            InputStream socketReader = socket.getInputStream();
            byte strRxBuf[] = new byte[6];
            int len = socketReader.read(strRxBuf, 0, 6);

            if (len != 0) {
                System.out.println("发送成功");

            } else {
                System.out.println("没有收到消息");
            }

            // 关闭流
            socketWriter.close();
            socketReader.close();
            // 关闭Socket
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    });

    public Tcp connect(String ip, int port) {
        try {
            socket = new Socket(ip, port);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * 打开继电器
     *
     * @param slot   第几路
     * @param millis 持续时间
     */
    void openRelay(int slot, int millis) {
        if (socket == null) return;
        try (OutputStream os = socket.getOutputStream()) {

            //os.write();
            os.flush();
            Thread.sleep(millis);

            //os.write();
            os.flush();
            socket.close();
            socket = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
