/**
 * <一句话功能简述>
 * <p>
 * 回复图文消息
 *
 * @author sunmeng
 * @create 2020/4/19   23:29
 */
package com.wechatcontext.contextdemo.model.wechatMsgType;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@XStreamAlias("xml")
public class NewsMessage extends BaseMessage {
	@XStreamAlias("ArticleCount")
	private String articleCount;
	@XStreamAlias("Articles")
	private List<Article> articles = new ArrayList<>();

	public String getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(String articleCount) {
		this.articleCount = articleCount;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public NewsMessage(Map<String, String> requestMap,List<Article> articles) {
		super(requestMap);
		this.setMsgType("news");
		this.articleCount = articles.size()+"";
		this.articles = articles;
	}
}
