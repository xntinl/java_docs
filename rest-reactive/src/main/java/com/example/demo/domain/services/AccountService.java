package com.example.demo.domain.services;

import com.example.demo.domain.port.IAccountService;
import com.example.demo.infrastructure.repository.Account;
import com.example.demo.infrastructure.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;

    public Flux<Account> getAccounts(String username){
        return accountRepository.findByUsername(username).delayElements(Duration.ofMillis(500));
    }

}
