package com.jesusfervid.dotify.controller;

import com.jesusfervid.dotify.App;
import com.jesusfervid.dotify.model.Account;
import com.jesusfervid.dotify.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
	private final AccountService service;

	public AccountController(AccountService service) {
		this.service = service;
	}

	@GetMapping("/all")
	public String getAll(Model model) {
		model.addAttribute("accounts", service.findAll());
		return "account/all";
	}

	@GetMapping("/profile")
	public String profile(Model model) {
		Account loggedAccount = App.getLoggedAccount();
		if (loggedAccount != null) {
			model.addAttribute("account", service.findById(loggedAccount.getId()));
			return "account/profile";
		}
		return "redirect:/login";
	}
}
