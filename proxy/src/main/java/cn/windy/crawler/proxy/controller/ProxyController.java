package cn.windy.crawler.proxy.controller;

import cn.windy.crawler.common.dto.Proxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {
    @RequestMapping(value = "/proxy",method = RequestMethod.POST)
    public Proxy getProxy(@RequestParam String url){
        return null;
    }
}
