package com.jesusfervid.dotify.service;

import com.jesusfervid.dotify.model.Account;
import com.jesusfervid.dotify.repository.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

	public Account create(Account user) {
		return repository.save(user);
	}

	public Account update(Account user) {
		return repository.save(user);
	}

	public boolean delete(Long id) {
		if (repository.existsById(id)){
			repository.deleteById(id);
			return true;
		}
		return false;
	}
}
