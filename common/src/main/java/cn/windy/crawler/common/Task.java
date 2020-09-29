package cn.windy.crawler.common;

import java.util.Date;

/**
 * define the task body
 * @since 2020-9-29 10:17:46
 * @author Zhangfeng
 */
public class Task {
    /**
     * the target url to crawl
     */
    private String url;

    /**
     * http method
     */
    private String method;

    /**
     * auth information
     */
    private Auth auth;

    /**
     * task generation time
     */
    private Date time;

    /**
     * sometimes the task will retry
     */
    private int executionTimes;
}
