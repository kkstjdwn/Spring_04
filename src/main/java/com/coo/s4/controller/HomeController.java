package com.coo.s4.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coo.s4.model.Kind;

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
		
		return "index";
	}
	
	
	@PostMapping("/testAjax")
	public void testAjax(Model model,int num) throws Exception{
		Random r = new Random();
		num = r.nextInt(num);
		model.addAttribute("num", num);
	}
	
	@GetMapping("/selectAnimal")
	public void selectAnimal(Model model,String animal) throws Exception{
		Kind kind = new Kind();
		
		if (animal.equals("dog")) {
			kind.setOp1("치와와");
			kind.setOp2("푸들");
			kind.setOp3("말티즈");
			
		}else if (animal.equals("cat")) {
			kind.setOp1("흰고양이");
			kind.setOp2("검은고양이");
			kind.setOp3("노란고양이");
			
		}else{
			kind.setOp1("비둘기");
			kind.setOp2("참새");
			kind.setOp3("닭");
		}
		
		model.addAttribute("kind", kind);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
