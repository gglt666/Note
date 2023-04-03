package pers.gglt.note.network.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class Single_Thread {

    /**使用*/
    void download(String url, String name, String path) throws Exception {
        File dirFile = new File(path);
        File downloadFile = new File(path + name);
        if (!dirFile.exists()) dirFile.mkdirs();
        if (downloadFile.exists()) downloadFile.delete();

        int len;
        byte[] bs = new byte[1024]; //1K的数据缓冲
        URLConnection con = new URL(url).openConnection();
        InputStream is = con.getInputStream();
        OutputStream os = new FileOutputStream(path + name);
        while ((len = is.read(bs)) != -1) os.write(bs, 0, len);

        os.close();
        is.close();
    }
}
