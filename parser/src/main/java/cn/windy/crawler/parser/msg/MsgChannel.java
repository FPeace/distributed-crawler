package cn.windy.crawler.parser.msg;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MsgChannel {
    String DOWNLOAD_TASK_INPUT_CHANNEL = "downloadTask";

    @Output(DOWNLOAD_TASK_INPUT_CHANNEL)
    MessageChannel output();
}
