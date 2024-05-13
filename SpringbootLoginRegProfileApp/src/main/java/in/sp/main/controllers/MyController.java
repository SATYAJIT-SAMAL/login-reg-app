package in.sp.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.sp.main.beans.Student;
import in.sp.main.service.LoginService;
import in.sp.main.service.RegisterService;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController
{
	@GetMapping("/")
	public String openHomePage()
	{
		return "home-page";
	}
	
	@GetMapping("/homePage")
	public String openHomePagee()
	{
		return "home-page";
	}
	
	@GetMapping("/aboutUsPage")
	public String openAboutUsPage()
	{
		return "about-us-page";
	}
	
	@GetMapping("/contactUsPage")
	public String openContactUsPage()
	{
		return "contact-us-page";
	}
	
	@GetMapping("/loginPage")
	public String openLoginPage()
	{
		return "login-page";
	}
	
	@GetMapping("/registerPage")
	public String openRegisterPage()
	{
		return "register-page";
	}
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/loginForm")
	public String login(@RequestParam("email1") String email, @RequestParam("pass1") String password, HttpSession session, Model model)
	{
		String page = "error-page";
		
		List<Student> students_list = loginService.loginService(email, password);
		if(students_list.size() != 0)
		{
			session.setAttribute("session_name", students_list.get(0).getName());
			session.setAttribute("session_email", students_list.get(0).getEmail());
			session.setAttribute("session_gender", students_list.get(0).getGender());
			session.setAttribute("session_city", students_list.get(0).getCity());
			
			page = "profile-page";
		}
		else
		{
			model.addAttribute("model_message", "Email id and password didnt matched....");
			model.addAttribute("model_pagename", "login");
			
			page = "error-page";
		}
		return page;
	}
	
	@GetMapping("/profilePage")
	public String openProfilePage()
	{
		return "profile-page";
	}
	
	@GetMapping("/logoutPage")
	public String logout(HttpSession session)
	{
		session.invalidate();
		
		return "login-page";
	}
	
	@Autowired
	RegisterService registerService;
	
	@PostMapping("/regForm")
	public String register(
							@RequestParam("name1") String name,
							@RequestParam("email1") String email, 
							@RequestParam("pass1") String password, 
							@RequestParam(name = "gender1", required = false) String gender, 
							@RequestParam("city1") String city,
							Model model)
	{
		String page = "error-page";
		
		Student std = new Student();
		std.setName(name);
		std.setEmail(email);
		std.setPassword(password);
		std.setGender(gender);
		std.setCity(city);
		
		boolean status = registerService.registerService(std);
		if(status)
		{
			model.addAttribute("model_message", "Student Registered Successfully");
			model.addAttribute("model_pagename", "register");
			
			page = "success-page";
		}
		else
		{
			model.addAttribute("model_message", "Student not registered due to some error");
			model.addAttribute("model_pagename", "register");
			
			page = "error-page";
		}
		
		return page;
	}
}
