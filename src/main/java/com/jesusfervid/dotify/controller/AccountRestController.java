package com.jesusfervid.dotify.controller;

import com.jesusfervid.dotify.model.Account;
import com.jesusfervid.dotify.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class AccountRestController {
	private final AccountService service;

	public AccountRestController(AccountService service) {
		this.service = service;
	}

	@Operation(summary = "Show all accounts")
	@ApiResponses(value = {
		@ApiResponse(
			responseCode = "200",
			description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Account.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("all")
	public List<Account> getAll() {
		return service.findAll();
	}

	@Operation(summary = "Show account by id")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Account.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("{id}")
	public Optional<Account> getById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@PostMapping
	public Account create(@RequestBody Account account) {
		return service.create(account);
	}

	@PutMapping
	public Account update(@RequestBody Account account) {
		return service.update(account);
	}

	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable("id") Long id) {
		return service.delete(id);
	}
}
