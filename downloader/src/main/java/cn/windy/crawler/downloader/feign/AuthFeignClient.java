package cn.windy.crawler.downloader.feign;

import cn.windy.crawler.common.dto.Auth;
import cn.windy.crawler.common.dto.Task;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "crawler-auth")
public interface AuthFeignClient {
    @RequestMapping(value = "/auth",method = RequestMethod.POST)
    Auth getAuth(@RequestBody Task task);
}
