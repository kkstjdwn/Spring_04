package com.coo.s4.controller;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		
		try {
			model.addAttribute("serverTime", formattedDate );
			
		} catch (Exception e) {			
			// TODO: handle exception
			
		}
		
		
		String year = "2000";
		String month = "12";
		String day = "24";
		
		Calendar ca = Calendar.getInstance();
		
		ca.set(Calendar.YEAR, Integer.parseInt(year));
		ca.set(Calendar.MONTH, Integer.parseInt(month));
		ca.set(Calendar.DATE, Integer.parseInt(day));
		
		java.sql.Date d = new java.sql.Date(ca.getTimeInMillis());
		
		return "index";
	}
	
}
