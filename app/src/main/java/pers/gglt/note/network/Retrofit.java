package pers.gglt.note.network;

import java.util.concurrent.Executors;
import java.util.logging.LoggingMXBean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public class Retrofit {
    // Retrofit将 Http请求 抽象成 Java接口：采用 注解 描述网络请求参数 和配置网络请求参数，用 动态代理 动态 将该接口的注解“翻译”成一个 Http的url请求，最后再执行 Http 请求

    interface RequestInterface {
        @GET("article/list/{pageNum}/json")
        Call<ResponseBody> getCall(@Part("pageNum") int pageNum);

        Call<ResponseBody> getUser(@Query("email")  String email);
        // @Query表示请求参数，将会以key=value（@Query注解参数名称为key,调用传进来的值为value）的方式拼接在url后面

        @FormUrlEncoded
        @POST("UserServlet")
        Call<ResponseBody>  postUser(@Field("name") String name, @Field("email") String email);
    }

    public class HttpRequest {

        private volatile HttpRequest httpRequest;
        private String baseUrl = "https://www.wanandroid.com/";
        private Retrofit retrofit;
        private RequestInterface requestInterface;

        private HttpRequest() {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .callbackExecutor(Executors.newSingleThreadExecutor()) //使用单独的线程处理 (这很重要,如果是下载文件就会报错)
                    .build();
            requestInterface = retrofit.create(RequestInterface.class);
        }

        public  HttpRequest getInstance() {
            if (httpRequest == null) {
                synchronized (HttpRequest.class) {
                    if (httpRequest == null) {
                        httpRequest = new HttpRequest();
                    }
                }
            }
            return httpRequest;
        }

        public RequestInterface getInterfaceInstance() {
            return requestInterface;
        }

    }
}
