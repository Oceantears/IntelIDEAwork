/**
 * <一句话功能简述>
 * <p>
 * 回复微信端传来的语音消息
 *
 * @author sunmeng
 * @create 2020/4/19   17:30
 */
package com.wechatcontext.contextdemo.model.wechatMsgType;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

@XStreamAlias("xml")
public class VoiceMessage extends BaseMessage {
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public VoiceMessage(Map<String, String> requestMap,String mediaId) {
		super(requestMap);
		this.setMsgType("voice");
		this.mediaId = mediaId;
	}
}
