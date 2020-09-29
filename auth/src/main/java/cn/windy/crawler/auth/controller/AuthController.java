package cn.windy.crawler.auth.controller;

import cn.windy.crawler.common.dto.Auth;
import cn.windy.crawler.common.dto.Task;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @RequestMapping(value = "/auth",method = RequestMethod.POST)
    public Auth getAuth(@RequestBody Task task){
        return null;
    }
}
