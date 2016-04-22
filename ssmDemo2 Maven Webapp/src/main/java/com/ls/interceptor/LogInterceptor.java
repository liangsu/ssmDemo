package com.ls.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LogInterceptor implements HandlerInterceptor{

	Log log = LogFactory.getLog(LogInterceptor.class);
	
	//handler执行之前执行
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		log.debug(handler.getClass()+"马上开始执行...");
		return true;
	}

	//返回ModelAndView时执行
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(modelAndView == null){
			log.debug(handler.getClass()+"没有返回的modelAndView，可能返回的是json");
		}else{
			log.debug(handler.getClass()+"返回的modelAndView是"+modelAndView.getViewName());
		}
	}

	//handler执行完成之后执行
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.debug(handler.getClass()+"执行完成!!!");
	}

}
