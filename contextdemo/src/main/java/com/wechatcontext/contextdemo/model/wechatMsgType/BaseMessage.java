/**
 * <一句话功能简述>
 * <p>
 * 回复微信客户端信息的基类
 *
 * @author sunmeng
 * @create 2020/4/19   15:50
 */
package com.wechatcontext.contextdemo.model.wechatMsgType;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

public class BaseMessage {
	@XStreamAlias("ToUserName")
	private String toUserName;
	@XStreamAlias("FromUserName")
	private String fromUserName;
	@XStreamAlias("CreateTime")
	private String createTime;
	@XStreamAlias("MsgType")
	private String msgType;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public BaseMessage(Map<String,String> requestMap) {
		this.toUserName = requestMap.get("FromUserName");
		this.fromUserName = requestMap.get("ToUserName");
		//+""是将时间转化成字符串
		this.createTime = System.currentTimeMillis()/1000+"";
	}

	@Override
	public String toString() {
		return "BaseMessage{" +
				"toUserName='" + toUserName + '\'' +
				", fromUserName='" + fromUserName + '\'' +
				", createTime='" + createTime + '\'' +
				", msgType='" + msgType + '\'' +
				'}';
	}
}
