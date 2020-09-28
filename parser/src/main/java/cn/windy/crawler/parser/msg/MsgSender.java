package cn.windy.crawler.parser.msg;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(MsgChannel.class)
@EnableScheduling
public class MsgSender {

    private final MessageChannel messageChannel;

    public MsgSender(@Qualifier(MsgChannel.DOWNLOAD_TASK_INPUT_CHANNEL) MessageChannel messageChannel) {
        this.messageChannel = messageChannel;
    }

    @Scheduled(fixedDelay = 1000)
    public void send(){
        messageChannel.send(MessageBuilder.withPayload("SSSSSS").build());
    }
}
