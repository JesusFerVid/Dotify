package com.jesusfervid.dotify.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	@GetMapping
	public String home() {
		// Profile page redirects to all accounts if not logged in
		return "redirect:/account/profile";
	}
}
