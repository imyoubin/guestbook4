package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	
	//필드
	
	//생성자
	
	//메소드gs
	
	//메소드일반
	//메소드일반
		@RequestMapping(value="/ User/list", method={RequestMethod.GET, RequestMethod.POST})
		public String select() {
			
			System.out.println("guestbook4/list");
			
		    return "";
		}

		@RequestMapping(value="/ User/remove", method={RequestMethod.GET, RequestMethod.POST})
		public String delete() {
			
			System.out.println("guestbook4/remove");
			
		    return "";
		}

	}