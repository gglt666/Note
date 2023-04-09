package pers.gglt.note.network.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

//https://ask.qcloudimg.com/http-save/yehe-418957/vuccneccge.png?imageView2/2/w/2560/h/7000
public class Retrofit {
    /**概念*/
    // 将Http请求抽象成Java接口
    // 采用注解描述和配置网络请求参数，用动态代理将该接口的注解“翻译”成一个Http的url请求，最后再执行Http请求

    /**优点*/
    // 可配置HttpClient
    // 注解可定制
    // 可同步/异步
    // 解耦
    // 可配置数据解析工具

    /**流程*/
    // 通过解析网络请求接口的注解配置网络请求参数
    // 通过动态代理生成网络请求对象
    // 通过网络请求适配器将网络请求对象 进行平台适配
    // 通过网络请求执行器发送网络请求
    // 通过数据转换器 解析服务器返回的数据
    // 通过回调执行器切换至主线程
    // 用户在主线程处理返回结果

    interface RequestInterface {
        @GET("article/list/{pageNum}/json")
        Call<ResponseBody> getCall(@Part("pageNum") int pageNum);

        Call<ResponseBody> getUser(@Query("email")  String email);
        // @Query表示请求参数，将会以key=value（@Query注解参数名称为key,调用传进来的值为value）的方式拼接在url后面

        @FormUrlEncoded //将请求参数类型设置为application/x-www-form-urlencoded
        @POST("UserServlet")
        Call<ResponseBody> postUser(@Field("name") String name, @Field("email") String email);

        // @Field(value = "password", encoded = true)
        // 配合@FormUrlEncoded使用，其实就是表单提交的方式
        // (将每一个请求参数都存放至请求体中) (encoded参数为true的话, key-value-pair将被编码，即将中文和特殊字符进行编码转换)

        // @Path
        // 一般是配合url中带有{}使用的
        // @GET("/article/list/{page}/json")
        // 那么在使用@Path的时候，就需要@Path("page")

        // @Query
        // 一般是把key-value拼接到url的后面, ?key=value&key1=value1
    }

    public class HttpRequest {
        private volatile HttpRequest httpRequest;
        private String baseUrl = "https://www.wanandroid.com/"; //需以'/'结尾
        private Retrofit retrofit;
        private RequestInterface requestInterface;

        private HttpRequest() {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(baseUrl)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .callbackExecutor(Executors.newSingleThreadExecutor()) //使用单独的线程处理 (这很重要,如果是下载文件就会报错)
//                    .build();
//            requestInterface = retrofit.create(RequestInterface.class);
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

        public RequestInterface getInterfaceInstance() {return requestInterface;}
    }
}
