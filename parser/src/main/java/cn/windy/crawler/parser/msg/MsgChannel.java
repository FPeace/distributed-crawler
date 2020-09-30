package cn.windy.crawler.parser.msg;

import org.springframework.messaging.MessageChannel;

public interface MsgChannel {
    String DOWNLOAD_TASK_INPUT_CHANNEL = "download-task";

   // @Output(DOWNLOAD_TASK_INPUT_CHANNEL)
    MessageChannel output();
}
