package com.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception e) {
		ModelAndView mav=new ModelAndView();
		if(e instanceof MyException){
			MyException me=(MyException)e;
			mav.addObject("error", me.getMsg());
		}else{
			mav.addObject("error", "报错啦！！！");
		}
		mav.setViewName("error");
		return mav;
	}
}
