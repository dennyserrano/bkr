package org.bkr.web.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigatorController {

	@GetMapping("/")
	public String i()
	{
		return "home.html";
	}
	
	@GetMapping("/login")
	public String index()
	{
		return "index.html";
	}
	
	@GetMapping("/home")
	public String home()
	{
		return "home.html";
	}
	
	@GetMapping("/breadlist")
	public String breadList()
	{
		return "breadlist.html";
	}
	
}
