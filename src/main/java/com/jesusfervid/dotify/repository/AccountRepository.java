package com.jesusfervid.dotify.repository;

import com.jesusfervid.dotify.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}