/**
 * <一句话功能简述>
 * <p>
 * 连接微信服务器控制层
 *
 * @author sunmeng
 * @create 2020/4/17   16:15
 */
package com.wechatcontext.contextdemo.controller;

import com.wechatcontext.contextdemo.service.impl.WeChatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class WeChatController {

	/**
	 * 与微信服务器连接测试
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	// @RequestMapping("/getMsg")
	// @ResponseBody
	// public String getMsg(String signature, String timestamp, String nonce, String echostr , HttpServletRequest request) throws IOException {
	//
	// 	// System.out.println(signature);
	// 	// System.out.println(timestamp);
	// 	// System.out.println(nonce);
	// 	// System.out.println(echostr);
	// 	if(WeChatService.check(timestamp,nonce,signature)){
	// 		return echostr;
	// 	}
	// 	else {
	// 		System.out.println("连接失败！！");
	// 		return null;
	// 	}
	// }

	/**
	 *接收微信客户端的消息并返回响应
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/getMsg")
	@ResponseBody
	public String getMsg(HttpServletRequest request) throws IOException {
		// ServletInputStream is = request.getInputStream();
		// byte[] b = new byte[1024];
		// int len;
		// StringBuilder sb = new StringBuilder();
		// while ((len=is.read(b))!=-1){
		// 	sb.append(new String(b,0,len));
		// }
		// System.out.println(sb.toString());

		Map<String,String> requestMap = WeChatService.parseRequest(request.getInputStream());
		// System.out.println("==========requestMap=========>"+requestMap);

		// String responseXml = WeChatService.getResponse(requestMap);

		return WeChatService.getResponse(requestMap);
	}
}
