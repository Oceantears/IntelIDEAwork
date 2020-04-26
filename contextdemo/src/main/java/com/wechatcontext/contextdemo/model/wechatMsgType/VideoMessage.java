/**
 * <一句话功能简述>
 * <p>
 * 回复微信客户端视频信息
 *
 * @author sunmeng
 * @create 2020/4/19   18:04
 */
package com.wechatcontext.contextdemo.model.wechatMsgType;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

@XStreamAlias("xml")
public class VideoMessage extends BaseMessage {
	private String mediaId;
	private String title;
	private String description;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

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

	public VideoMessage(Map<String, String> requestMap,String mediaId,String title,String description) {
		super(requestMap);
		this.setMsgType("video");
		this.mediaId = mediaId;
		this.title = title;
		this.description = description;
	}
}
