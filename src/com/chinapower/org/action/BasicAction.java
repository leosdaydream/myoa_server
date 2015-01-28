package com.chinapower.org.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class BasicAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware,ServletContextAware{
	
	private static final long serialVersionUID = 1L;
	public HttpServletRequest request;
	public HttpServletResponse response;
	public ServletContext context;
	public Map session;

	public void setSession(Map session) {
		this.session=session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	public void setServletContext(ServletContext context) {
		this.context=context;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}
	
	

}
