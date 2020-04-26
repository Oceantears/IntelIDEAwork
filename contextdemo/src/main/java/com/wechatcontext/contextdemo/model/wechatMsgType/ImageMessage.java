/**
 * <一句话功能简述>
 * <p>
 * 回复微信客户端图片消息
 *
 * @author sunmeng
 * @create 2020/4/19   17:23
 */
package com.wechatcontext.contextdemo.model.wechatMsgType;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

@XStreamAlias("xml")
public class ImageMessage extends BaseMessage {
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public ImageMessage(Map<String, String> requestMap, String mediaId) {
		super(requestMap);
		this.setMsgType("image");
		this.mediaId = mediaId;
	}
}
