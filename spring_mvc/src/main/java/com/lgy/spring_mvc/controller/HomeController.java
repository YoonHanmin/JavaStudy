package com.lgy.spring_mvc.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lgy.spring_mvc.service.Service;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/board")
public class HomeController {
	private Service service;

	@Autowired
	public HomeController(Service service) {
		this.service = service;
	
	}


	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/content")
	public String content() {
		return "board/content";
	}
	
	@RequestMapping("/car")
	public String car() {
		return "board/car";	
	}
	
	@RequestMapping("/student")
	public String student(Model model) {
		
		model.addAttribute("id","youngwoong");
		
		return "board/student";
		
	}
	@RequestMapping("/admin")
	public String admin(Model model,@RequestParam("pw") String pw) {
		model.addAttribute("id","boom");
		model.addAttribute("pw",pw);
		return "board/admin";
		
	}
	
	

}
