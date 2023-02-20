package com.jesusfervid.dotify.repository;

import com.jesusfervid.dotify.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByUsername(String username);
}