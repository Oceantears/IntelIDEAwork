/**
 * <一句话功能简述>
 * <p>
 * 回复图文消息子节点
 *
 * @author sunmeng
 * @create 2020/4/19   23:08
 */
package com.wechatcontext.contextdemo.model.wechatMsgType;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("item")
public class Article {
	@XStreamAlias("Title")
	private String title;
	@XStreamAlias("Description")
	private String description;
	@XStreamAlias("PicUrl")
	private String picUrl;
	@XStreamAlias("Url")
	private String url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Article(String title, String description, String picUrl, String url) {
		this.title = title;
		this.description = description;
		this.picUrl = picUrl;
		this.url = url;
	}
}
