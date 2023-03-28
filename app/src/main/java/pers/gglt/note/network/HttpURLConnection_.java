package pers.gglt.note.network;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpURLConnection_ {
    /**使用*/
    String post(String url, String user, String passwd) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("POST");
        conn.setUseCaches(false); //Post不能缓存，需手动设置
        conn.setDoOutput(true);conn.setDoInput(true); //允许输入参数输出
        conn.setConnectTimeout(6 * 1000);conn.setReadTimeout(6 * 1000);
        if (conn.getResponseCode() == 200) {
            InputStream is = conn.getInputStream();
            ByteArrayOutputStream os = new ByteArrayOutputStream();

            int len;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1) os.write(buffer, 0, len);

            is.close();
            os.close();
            return os.toString();
        }
        return null;
    }
}
