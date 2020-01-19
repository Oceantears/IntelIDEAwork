/**
 * <一句话功能简述>
 * <p>
 * 自定义mybatis配置类
 *
 * @author sunmeng
 * @create 2020/1/7   11:09
 */
package com.it.mybatis.cfg;

import java.util.Map;

public class Configuration {
	private String driver;
	private String url;
	private String username;
	private String password;

	private Map<String,Mapper> mappers;

	public Map<String, Mapper> getMappers() {
		return mappers;
	}

	public void setMappers(Map<String, Mapper> mappers) {
		this.mappers.putAll(mappers);          //此处需要用追加方式，避免覆盖之前的mappers
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
