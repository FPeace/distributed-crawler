package cn.windy.crawler.downloader.msg;


import cn.windy.crawler.downloader.msg.MsgChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({MsgChannel.class })
public class MsgListener {

    @StreamListener(MsgChannel.DOWNLOAD_TASK_INPUT_CHANNEL)
    private void receive(String msg){
        System.out.println(System.currentTimeMillis() + msg);
    }
}
