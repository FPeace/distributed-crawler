package cn.windy.crawler.common.dto;

/**
 * internet proxy
 * @since 2020-9-29 15:41:57
 * @author Zhangfeng
 */
public class Proxy {
    private String ip;
    private int port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
