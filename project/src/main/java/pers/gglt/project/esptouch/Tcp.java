package pers.gglt.project.esptouch;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.LogUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Tcp {
    Socket socket;
    byte[] msgBytes;

    public static Tcp get() {
        return new Tcp();
    }

    public Tcp connect(String ip, int port) {
        try {
            socket = new Socket(ip, port);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * 控制继电器
     *
     * @param hexMsg1 第1次发送的hex指令数据
     * @param hexMsg2 第2次发送的hex指令数据
     * @param millis  发送间隔
     */
    public void ctrlRelay(String hexMsg1, String hexMsg2, int millis) {
        if (socket == null) return;
        try (OutputStream os = socket.getOutputStream()) {
            msgBytes = ConvertUtils.hexString2Bytes(hexMsg1);
            os.write(msgBytes);
            os.flush();
            Thread.sleep(millis);
            msgBytes = ConvertUtils.hexString2Bytes(hexMsg2);
            os.write(msgBytes);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            LogUtils.i("控制继电器,msg1=" + hexMsg1 + ",msg2=" + hexMsg2);
        }
    }

    public void ctrlRelay(String hexMsg) {
        if (socket == null) return;
        try (OutputStream os = socket.getOutputStream()) {
            msgBytes = ConvertUtils.hexString2Bytes(hexMsg);
            os.write(msgBytes);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            LogUtils.i("控制继电器,msg=" + hexMsg);
        }
    }
}
