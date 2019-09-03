package com.emp.controller;



import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emp.entity.User;

@Controller
public class UserController {
    //跳转到登录页面
	@RequestMapping("/user/toLogin")
	public String tologin(){
		return "Login";     
	}
	
	@RequestMapping("/user/login")
	public String login(User user,Model model){
		
		//获取当前用户Subject主体 调用"/user/login"请求的东西（用户，程序）
		Subject subject=SecurityUtils.getSubject();
		//创建一个令牌对象
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try{
			//为当前用户进行认证，授权
			subject.login(token);
			//重定向到主页员工列表			
			return "redirect:/emp/conditionList";
			
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("msg","用户名或者密码错误");
			return "Login";
		}
	}
	
	


}
