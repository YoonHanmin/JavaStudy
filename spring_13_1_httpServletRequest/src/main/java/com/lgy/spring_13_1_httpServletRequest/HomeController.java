package com.lgy.spring_13_1_httpServletRequest;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
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
	
	@RequestMapping("board/confirmId")
//	httpServletRequest 객체에 쿼리스트링으로 넘어온 url 파라미터 값을 담는다.
	public String confirmId(HttpServletRequest httpServletRequest,Model model) {
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		return "board/confirmId"; 
	}
	@RequestMapping("board/checkId")
//	@RequestParam : 쿼리스트링 값이 없을 경우 HTTP 400 에러 발생 
	public String checkId(@RequestParam("id")String id,@RequestParam("pw")String pw,Model model) {
		model.addAttribute("identify",id);
		model.addAttribute("password",pw);
		return "board/checkId";
	}
	
//	@RequestMapping("member/join")
//	public String joinData(@RequestParam("name")String name
//							,@RequestParam("id")String id
//							,@RequestParam("pw")String pw
//							,@RequestParam("email")String email,Model model){
//		Member member = new Member();
//		member.setId(id);
//		member.setName(name);
//		member.setEmail(email);
//		member.setPw(pw);
//		model.addAttribute("member",member);
//		return "member/join";
//							}
	

	@RequestMapping("member/join")
//	member 객체를 파라미터로 받아오기만 해도 자동으로 쿼리스트링 값을 setting하여 넘겨준다.
	public String joinData(Member member) {
		return "member/join";
	}
	
}
