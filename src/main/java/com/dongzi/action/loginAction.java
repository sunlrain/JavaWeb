package com.dongzi.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;


//import com.dongzi.daoimp.UserDaoImp;
@ParentPackage("dongzi")
@Namespace("/")
//@Action(value = "login")
public class loginAction extends ActionSupport implements 
ServletRequestAware,ServletResponseAware {
/**
* 
*/
	private static final long serialVersionUID = 1L;


	HttpServletRequest request;
	HttpServletResponse response;

	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}

	@Action(value = "login", results = {@Result(type = "json") })
	public void  login(){
		try {

			this.response.setContentType("text/html;charset=utf-8");
			this.response.setCharacterEncoding("UTF-8");

			Map<String,String> json=new HashMap<String,String>();

			String username=this.request.getParameter("userName");
			String password=this.request.getParameter("password");
			//UserDaoImp userDaoImp=new UserDaoImp();
			//boolean b=userDaoImp.login(username,password);
			//if (b)
			if(username != null)
			{
				if(username.equals("kevin"))
				{
					json.put("message", "OK");
				}
				else
				{
					json.put("message", "NOK");
				}
			} else {
				json.put("message", "NOK");
			}


			byte[] jsonBytes = json.toString().getBytes("utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String userLogin() {
		return "userLogin";
	}

}
