package com.ls.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ls.po.User;

public class LoginInterceptor implements HandlerInterceptor{

	
	//handler执行之前执行
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//1.判断是否访问公开的url地址
		String uri = request.getRequestURI();
		if(uri.indexOf("login") > 0){
			return true;
		}
		
		//2.如果方位的私有地址，判断是否登陆
		User user = (User) request.getSession().getAttribute("user");
		user = new User();
		if(user != null){
			return true;
		}
		
		return false;
	}

	//返回ModelAndView时执行
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	//handler执行完成之后执行
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
