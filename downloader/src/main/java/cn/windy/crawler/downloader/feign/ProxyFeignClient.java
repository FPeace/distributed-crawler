package cn.windy.crawler.downloader.feign;

import cn.windy.crawler.common.dto.Proxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "crawler-proxy")
public interface ProxyFeignClient {
    @RequestMapping(value = "/proxy",method = RequestMethod.POST)
    Proxy getProxy(@RequestParam String url);
}
