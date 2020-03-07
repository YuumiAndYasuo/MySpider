package Utils;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil {
    public static void sendOkHttpRequest(String address, Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().addHeader("cookie","ID=-NsUQgR9Vz3f7k7o19BP6w").url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
