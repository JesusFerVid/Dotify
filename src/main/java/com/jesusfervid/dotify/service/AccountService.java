package com.jesusfervid.dotify.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.jesusfervid.dotify.model.Account;
import com.jesusfervid.dotify.repository.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
	private final AccountRepository repository;

	public AccountService(AccountRepository repository) {
		this.repository = repository;
	}

	public List<Account> findAll() {
		return repository.findAll();
	}

	public List<Account> findAll(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Account> page = repository.findAll(pageable);
		if (page.hasContent())
			return page.getContent();
		return null;
	}

	public Optional<Account> findById(Long id){
		return repository.findById(id);
	}

	public Optional<Account> findByUsername(String username) {
		return repository.findByUsername(username);
	}

	public Account create(Account account) {
		return repository.save(account);
	}

	public Account update(Account account) {
		return repository.save(account);
	}

	public boolean delete(Long id) {
		if (repository.existsById(id)){
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	public String exportToJson(String username) {
		Account account = repository.findByUsername(username).orElse(null);
		if (account != null) {
			try{
				ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
				String json = writer.writeValueAsString(account);
				File file = new File("export/json/%s.json".formatted(account.getUsername()));
				FileWriter fw = new FileWriter(file);
				fw.write(json);
				return "Generated file: " + file.getPath();
			} catch (IOException e) {
				e.printStackTrace();
		    }
		}
		return "File wasn't generated";
	}
}
