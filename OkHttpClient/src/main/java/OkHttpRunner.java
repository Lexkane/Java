import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;


public class OkHttpRunner {

    public static OkHttpClient client= new OkHttpClient();

    public static void main(String[] args) throws Exception  {

        String result= run ("http:/hawttrends.appspot.com/api/terms");
        System.out.println(result);

    }


    private static String run (String url) throws IOException{
        Request request = new Request.Builder().url(url).build();
        Response response =client.newCall(request).execute();
        return response.body().string();
    }


}
