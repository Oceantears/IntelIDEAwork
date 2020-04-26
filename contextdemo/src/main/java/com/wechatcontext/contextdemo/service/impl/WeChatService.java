/**
 * <一句话功能简述>
 * <p>
 * 微信服务层
 *
 * @author sunmeng
 * @create 2020/4/17   16:34
 */
package com.wechatcontext.contextdemo.service.impl;

import com.thoughtworks.xstream.XStream;
import com.wechatcontext.contextdemo.model.wechatMsgType.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class WeChatService {
	private static final String TOKEN = "smzs";
	/**
	 * 验证签名
	 * @param timestamp
	 * @param nonce
	 * @param signature
	 * @return
	 */
	public static boolean check(String timestamp, String nonce, String signature) {
		//1）将token、timestamp、nonce三个参数进行字典序排序
		String[] strs = new String[]{TOKEN,timestamp,nonce};
		Arrays.sort(strs);
		//2）将三个参数字符串拼接成一个字符串进行sha1加密
		String str = strs[0]+strs[1]+strs[2];
		String mysig = sha1(str);
		// System.out.println("=======mysig==========>"+mysig);
		// System.out.println("=======signature==========>"+signature);
		//3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信

		return mysig.equals(signature);
	}

	/**
	 * 进行sha1加密
	 * @param str
	 * @return
	 */
	private static String sha1(String str) {
		try {
			//获取一个加密对象
			MessageDigest md = MessageDigest.getInstance("sha1");
			//加密
			byte[] digest = md.digest(str.getBytes());
			char[] chars = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
			StringBuilder sb = new StringBuilder();
			//处理加密结果
			for (byte b:digest) {
				/**
				 * 这里分别对digest加密后数组的前4位和后四位进行处理
				 * 前四位是数组整体右移四位，然后让结果跟00001111(即15)进行按位与运算，得到前四位
				 * 后四位是数组直接跟00001111(即15)进行按位与运算，得到后四位
				 */
				sb.append(chars[(b>>4)&15]);
				sb.append(chars[b&15]);
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解析XML数据包
	 * @param is
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,String> parseRequest(InputStream is) {
		Map<String,String> map = new HashMap<>();
		SAXReader reader = new SAXReader();
		try {
			//读取输入流获取文档对象
			Document document = reader.read(is);
			//根据文档对象获取根节点
			Element root = document.getRootElement();
			//获取根节点的所有子节点(在 intellij idea 编辑器中，把一个Map类型的数据，强制类型转换的时候需要用@SuppressWarnings("unchecked"))
			List<Element> elements = root.elements();
			for (Element e:elements) {
				map.put(e.getName(),e.getStringValue());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 用于处理所有的事件和消息的回复
	 * @param requestMap
	 * @return 返回xml数据包
	 */
	public static String getResponse(Map<String, String> requestMap) {
		BaseMessage message = null;
		String msgType = requestMap.get("MsgType");
		switch (msgType){
			//处理文本消息
			case "text":
				message = dealTextMessage(requestMap);
				break;
			case "image":

				break;
			case "voice":
				break;
			case "video":
				break;
			case "shortvideo":
				break;
			case "location":
				break;
			case "link":
				break;
			case "event":

				break;
			default:
				break;
		}
		// 把消息对象处理为xml
		if(message!=null){
			return beanToXml(message);
		}else {
			return null;
		}
	}

	/**
	 * 把消息对象处理为xml
	 * @param message
	 * @return
	 */
	private static String beanToXml(BaseMessage message) {
		XStream stream = new XStream();
		// 设置需要处理XStreamAlias("xml")注释的类
		stream.processAnnotations(TextMessage.class);
		stream.processAnnotations(ImageMessage.class);
		stream.processAnnotations(MusicMessage.class);
		stream.processAnnotations(NewsMessage.class);
		stream.processAnnotations(VideoMessage.class);
		stream.processAnnotations(VoiceMessage.class);

		String xml = stream.toXML(message);
		// System.out.println("============================"+xml);
		return xml;
	}

	/**
	 * 处理文本消息
	 * @param requestMap
	 * @return
	 */
	private static BaseMessage dealTextMessage(Map<String, String> requestMap) {
		String msg = requestMap.get("Content");
		if(msg.equals("图文")){
			List<Article> articles = new ArrayList<>();
			articles.add(new Article("海军女剑士",
					"很像索隆的青梅竹马",
					"http://mmbiz.qpic.cn/mmbiz_jpg/txj0gJRicbrqickicY9ico9V6RLwDd3r9uc8iaAYBFLdGA3hdqS4RdSfUicFmBGpcWA5LENCPEicbwCic2CGgic70JjqmCg/0",
					"www.baidu.com"));
			NewsMessage nm = new NewsMessage(requestMap,articles);
			return nm;
		}
		String content = chat(msg);
		TextMessage tm = new TextMessage(requestMap,content);
		return tm;
	}

	/**
	 * 获取微信发来信息，返回文本信息
	 * @param msg
	 * @return
	 */
	private static String chat(String msg) {
		String backMsg = null;
		if(msg.equals("你好")){
			backMsg = "你好啊，你叫什么？";
		}
		// else if(msg.equals("田志强")){
		// 	backMsg = "原来是受先生";
		// }else if(msg.equals("闫宝宁")){
		// 	backMsg = "田志强的救星来了！！！";
		// }else if(msg.equals("孙勐")){
		// 	backMsg = "主人来了，我好想你！";
		// }else if(msg.equals("想我么？")){
		// 	backMsg = "超想的，你想我了么？";
		// }
		// else if(msg.equals("明天出去玩吧")){
		// 	backMsg = "好啊，好久没吃肉了~";
		// }else if(msg.equals("陈宇")){
		// 	backMsg = "主人，么么哒~";
		// }
		else {
			backMsg = "我什么都不知道，别问我┭┮﹏┭┮";
		}

		return backMsg;
	}
}
