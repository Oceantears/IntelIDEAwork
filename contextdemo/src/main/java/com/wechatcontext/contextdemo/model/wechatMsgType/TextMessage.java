/**
 * <一句话功能简述>
 * <p>
 * 回复微信客户端的文本消息
 *
 * @author sunmeng
 * @create 2020/4/19   15:53
 */
package com.wechatcontext.contextdemo.model.wechatMsgType;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

@XStreamAlias("xml")
public class TextMessage extends BaseMessage {
	@XStreamAlias("Content")
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public TextMessage(Map<String, String> requestMap,String content) {
		super(requestMap);
		//设置文本消息的msgtype为text
		this.setMsgType("text");
		this.content = content;
	}

	@Override
	public String toString() {
		return "TextMessage{" +
				"content='" + content + '\'' +
				"} " + super.toString();
	}
}
