package cn.windy.crawler.common.dto;

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
    private HttpMethod method = HttpMethod.GET;

    /**
     * auth information
     */
    private Auth auth;

    /**
     * task generation time
     */
    private Date time = new Date();

    /**
     * sometimes the task will retry
     */
    private int executionTimes = 0;

    private String body;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getExecutionTimes() {
        return executionTimes;
    }

    public void setExecutionTimes(int executionTimes) {
        this.executionTimes = executionTimes;
    }

    public enum HttpMethod{
        GET,
        POST
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Task{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", auth=" + auth +
                ", time=" + time +
                ", executionTimes=" + executionTimes +
                '}';
    }
}
