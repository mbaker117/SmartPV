/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Class MainController.
 */
@Controller
public class MainController {
	

	
	 /**
	 * Index.
	 *
	 * @return the string
	 */
 	@RequestMapping("/")
	 public String index() {
		 return "index";
	 }
	 
}
	 

