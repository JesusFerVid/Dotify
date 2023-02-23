package com.jesusfervid.dotify.controller;

import com.jesusfervid.dotify.App;
import com.jesusfervid.dotify.model.Account;
import com.jesusfervid.dotify.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class LoginController {
	private final AccountService service;

	public LoginController(AccountService service) {
		this.service = service;
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("account", new Account());
		return "account/login";
	}

	@PostMapping("/login/check")
	public String check(@ModelAttribute("account") Account account) {
		if (account != null) {
			Account found = service.findByUsername(account.getUsername()).orElse(null);
			if (found != null) {
				// No es necesario comprobar el username si hemos llegado aquí
				if (account.getPassword().equals(found.getPassword())) {
					// Guardamos el usuario con sesión iniciada
					App.setLoggedAccount(found);
					return "redirect:/account/profile";
				}
			}
		}
		return "redirect:/auth/login";
	}

	@GetMapping("/logout")
	public String logout() {
		App.setLoggedAccount(null);
		return "redirect:/account/all";
	}
}
