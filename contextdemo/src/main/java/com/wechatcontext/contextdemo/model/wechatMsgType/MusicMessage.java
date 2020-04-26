/**
 * <一句话功能简述>
 * <p>
 * 回复微信客户端传来的音乐信息
 *
 * @author sunmeng
 * @create 2020/4/19   21:05
 */
package com.wechatcontext.contextdemo.model.wechatMsgType;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;
@XStreamAlias("xml")
public class MusicMessage extends BaseMessage {
	private Music music;

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public MusicMessage(Map<String, String> requestMap,Music music) {
		super(requestMap);
		this.setMsgType("music");
		this.music = music;
	}
}
