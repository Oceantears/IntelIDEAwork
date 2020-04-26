/**
 * <一句话功能简述>
 * <p>
 * musicMessage的标签内类
 *
 * @author sunmeng
 * @create 2020/4/19   22:55
 */
package com.wechatcontext.contextdemo.model.wechatMsgType;

public class Music {
	private String title;
	private String description;
	private String musicURL;
	private String hQMusicURL;
	private String thumbMediaId;

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

	public String getMusicURL() {
		return musicURL;
	}

	public void setMusicURL(String musicURL) {
		this.musicURL = musicURL;
	}

	public String gethQMusicURL() {
		return hQMusicURL;
	}

	public void sethQMusicURL(String hQMusicURL) {
		this.hQMusicURL = hQMusicURL;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public Music(String title, String description, String musicURL, String hQMusicURL, String thumbMediaId) {
		this.title = title;
		this.description = description;
		this.musicURL = musicURL;
		this.hQMusicURL = hQMusicURL;
		this.thumbMediaId = thumbMediaId;
	}
}
