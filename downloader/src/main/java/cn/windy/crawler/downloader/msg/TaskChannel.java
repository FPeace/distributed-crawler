package cn.windy.crawler.downloader.msg;

import org.springframework.messaging.SubscribableChannel;

public interface TaskChannel {

    String DOWNLOAD_TASK_INPUT_CHANNEL = "downloadTask";

   // @Input(DOWNLOAD_TASK_INPUT_CHANNEL)
    SubscribableChannel input();

}
