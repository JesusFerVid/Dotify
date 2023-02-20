package com.jesusfervid.dotify.controller;

import com.jesusfervid.dotify.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountRestController {
	private final AccountService service;

	public AccountRestController(AccountService service) {
		this.service = service;
	}


}
