package com.hs.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.hs.util.Page;

public class PageTag extends SimpleTagSupport{
	private String action;//标签参数
	
	@Override
	public void doTag() throws JspException, IOException {
		//获取jsp内置对象pageContext
		PageContext pageContext = (PageContext) this.getJspContext();
		Page page = (Page) pageContext.getRequest().getAttribute("page");
		String path = pageContext.getRequest().getServletContext().getContextPath();
		String basePath = pageContext.getRequest().getScheme()+"://"
						+pageContext.getRequest().getServerName()+":"
						+pageContext.getRequest().getServerPort()+path+"/";
		//获取分页工具条的html字符串
		String pageBar = page.getPageBar(action, basePath);
		pageContext.getOut().println(pageBar);
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
}