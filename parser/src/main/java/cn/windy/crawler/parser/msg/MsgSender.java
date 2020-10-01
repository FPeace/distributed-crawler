package cn.windy.crawler.parser.msg;

import cn.windy.crawler.common.dto.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class MsgSender {
    
    @Bean
    public Function<List<Task>, List<Task>> parse(){
        return tasks -> {
            List<Task> taskList = new ArrayList<>();
            for (Task task : tasks) {
                if(!task.getUrl().startsWith("http")){
                    taskList.add(task);
                }
            }
            return taskList;
        };
    }
}
