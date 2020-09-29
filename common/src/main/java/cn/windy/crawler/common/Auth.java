package cn.windy.crawler.common;

import java.util.HashMap;

/**
 * some import information to access the url
 * @since 2020-9-29 10:16:46
 * @author Zhangfeng
 */
public class Auth {
    /**
     * cookie
     */
    private String cookie;

    /**
     * headers
     */
    private HashMap<String,String> headers;

    /**
     * queryParams,eg: ?name=Bob
     */
    private String queryParams;

}
