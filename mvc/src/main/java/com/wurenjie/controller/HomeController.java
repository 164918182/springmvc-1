package com.wurenjie.controller;



import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wurenjie.dao.BookDao;
import com.wurenjie.model.Book;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/wurenjie")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private HttpServletRequest request;
	
	@Resource 
	BookDao BookDao;
	
//	@Autowired
//	private HttpServletResponse response;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model,@RequestParam Map<String, Object> param) {
		logger.info("Welcome home! The client locale is {}.", locale);
			
		//String loginCode = (String)param.get("");
		Date date = new Date();
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getServletPath();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("url", url );
		System.out.println(url);
		return "home";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestParam Map<String, Object> param) throws IOException{
		String login = (String)param.get("login_code");
		String password = (String)param.get("password");
		//String urlMenu = "view/success1";
		//ModelAndView view = new ModelAndView(urlMenu);
		if(login.equals("wurenjie")&& password.equals("wurenjie")){
			//model.addAttribute("message","登录成功");
			System.out.println("success");
		}else{
			//model.addAttribute("message","登录失败");
			System.out.println("fail");
		}
		Map map = new HashMap();
		map.put("name", login);
		Book book = BookDao.myThird(login);
		
		return "";
	
		//return "{\"wurenjie\":\"吳仁杰\",\"password\":\"wurenjie\"}";
	}
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView success(Locale locale,@RequestParam Map<String, Object> param) {
		logger.info("Welcome home! The client locale is {}.", locale);
			
		//String loginCode = (String)param.get("");
		Date date = new Date();
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getServletPath();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		ModelAndView view =new ModelAndView("success1");
		view.addObject("serverTime", formattedDate );
		view.addObject("url", url );
		System.out.println(url);
		return view;
	}
	

	
}

