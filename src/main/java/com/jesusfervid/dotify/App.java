package com.jesusfervid.dotify;

import com.jesusfervid.dotify.model.Account;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
	private static Account loggedAccount;

	public static void main(String[] args) {
		loggedAccount = null;
		SpringApplication.run(App.class, args);
	}

	public static Account getLoggedAccount() {
		return loggedAccount;
	}

	public static void setLoggedAccount(Account loggedAccount) {
		App.loggedAccount = loggedAccount;
	}
}
