package cn.windy.crawler.common.dto;

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

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    public String getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(String queryParams) {
        this.queryParams = queryParams;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "cookie='" + cookie + '\'' +
                ", headers=" + headers +
                ", queryParams='" + queryParams + '\'' +
                '}';
    }
}
