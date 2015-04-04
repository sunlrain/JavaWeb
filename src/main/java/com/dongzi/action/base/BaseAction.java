package com.dongzi.action.base;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import java.io.IOException;

@ParentPackage("dongzi")
@Namespace("/")
public class BaseAction {
	private static final Logger logger = Logger.getLogger(BaseAction.class);
	/**
	 * 将对象转换成JSON字符串，并响应回前台
	 * 
	 * @param object
	 * @throws java.io.IOException
	 */
		public void writeJson(Object object) {
			try {
				String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
				ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
				ServletActionContext.getResponse().getWriter().write(json);
				ServletActionContext.getResponse().getWriter().flush();
				ServletActionContext.getResponse().getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
		}
	}
}
