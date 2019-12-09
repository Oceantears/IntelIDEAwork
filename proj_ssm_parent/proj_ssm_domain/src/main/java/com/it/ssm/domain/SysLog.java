package com.it.ssm.domain;
/**
 * @author     ：zyx
 * @date       ：Created in 2019/11/6 17:33
 * @description：系统日志
 * @modified By：
 * @version:     $
 * CREATE TABLE sys_log(
 * id BIGINT PRIMARY KEY AUTO_INCREMENT,
 * visitTime VARCHAR(50), -- 访问时间
 * username VARCHAR(50), -- 用户名
 * ip VARCHAR(30), -- 访问ip
 * method VARCHAR(200) -- 访问的方法，类名.方法名
 * )
 */
 
public class SysLog {
    private Long id;
    private String visitTime;
    private String username;
    private String ip;
    private String method;
    public SysLog() {
    }
    public SysLog(Long id, String visitTime, String username, String ip, String method) {
        this.id = id;
        this.visitTime = visitTime;
        this.username = username;
        this.ip = ip;
        this.method = method;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id=" + id +
                ", visitTime='" + visitTime + '\'' +
                ", username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
