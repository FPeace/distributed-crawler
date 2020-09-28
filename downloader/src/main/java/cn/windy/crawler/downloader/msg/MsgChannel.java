package cn.windy.crawler.downloader.msg;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MsgChannel {

    String DOWNLOAD_TASK_INPUT_CHANNEL = "downloadTask";

    @Input(DOWNLOAD_TASK_INPUT_CHANNEL)
    SubscribableChannel input();

}
