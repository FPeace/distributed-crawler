package cn.windy.crawler.downloader.msg;


import cn.windy.crawler.common.dto.Auth;
import cn.windy.crawler.common.dto.Task;
import cn.windy.crawler.downloader.feign.AuthFeignClient;
import cn.windy.crawler.downloader.feign.ProxyFeignClient;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@EnableBinding({TaskChannel.class })
public class TaskListener {

    private final AuthFeignClient authFeignClient;
    private final ProxyFeignClient proxyFeignClient;

    public TaskListener(AuthFeignClient authFeignClient,ProxyFeignClient proxyFeignClient) {
        this.authFeignClient = authFeignClient;
        this.proxyFeignClient = proxyFeignClient;
    }

    OkHttpClient httpClient = new OkHttpClient.Builder().proxySelector(new ProxySelector() {
        @Override
        public List<Proxy> select(URI uri) {
            List<Proxy> proxyList = new ArrayList<>();
            cn.windy.crawler.common.dto.Proxy proxy = proxyFeignClient.getProxy(uri.toString());
            if(proxy != null){
                if(StringUtils.isNotBlank(proxy.getIp())){
                    proxyList.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxy.getIp(),proxy.getPort())));
                    return proxyList;
                }
            }
            return null;
        }
        @Override
        public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {

        }
    }).build();

    @StreamListener(TaskChannel.DOWNLOAD_TASK_INPUT_CHANNEL)
    private void receive(Task task){

        if (task == null){
            return;
        }
        String url = task.getUrl();
        if(StringUtils.isEmpty(url)){
            return;
        }
        Task.HttpMethod method = task.getMethod();
        if(method == null){
            method = Task.HttpMethod.GET;
        }
        Auth auth = authFeignClient.getAuth(task);
        Request.Builder builder =  new Request.Builder();
        builder.url(url);
        if(auth != null){
            String queryParams = auth.getQueryParams();
            if(StringUtils.isNotBlank(queryParams)){
                url = url + queryParams;
            }
            builder.url(url);
            HashMap<String,String> headers = auth.getHeaders();
            if(headers != null){
                headers.forEach(builder::addHeader);
            }
            String cookie = auth.getCookie();
            if(StringUtils.isNotBlank(cookie)){
                builder.addHeader("cookie",cookie);
            }
        }

        Request request = builder.build();
        try {
            Response response = httpClient.newCall(request).execute();
            task.setExecutionTimes(task.getExecutionTimes() + 1);
            String stringBody = response.body().string();
            response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
