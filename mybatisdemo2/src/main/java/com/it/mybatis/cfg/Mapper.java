/**
 * <一句话功能简述>
 * <p>
 * 用于封装执行的Sql语句和结果类型的全限定类名
 *
 * @author sunmeng
 * @create 2020/1/7   11:12
 */
package com.it.mybatis.cfg;

public class Mapper {
	private String queryString;
	private String resultType;           //实体类的全限定类名

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
}
