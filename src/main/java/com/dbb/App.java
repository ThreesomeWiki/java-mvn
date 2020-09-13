package com.dbb;
import java.io.IOException;
import java.lang.Thread;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        requestBaidu();
    }
    public static void requestBaidu(){
        new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    OkHttpClient client = new OkHttpClient();
                    client.newCall(new Request.Builder().url("https://www.baidu.com").build()).enqueue(new Callback(){
                        @Override
                        public void onFailure(@NotNull Call call, @NotNull IOException e) {

                        }
                        @Override
                        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                            String content = response.body().string();
                            System.out.println(content);
                        }
                    });
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        }).start();
    }
}
