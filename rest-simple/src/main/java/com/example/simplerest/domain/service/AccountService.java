package com.example.simplerest.domain.service;

import com.example.simplerest.domain.port.IAccountService;
import com.example.simplerest.infrastructure.entity.Account;
import com.example.simplerest.infrastructure.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;

    @Override
    public Collection<Account> getAccounts(String username) {
        return accountRepository.findByUsername(username).stream().peek(e->{
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(Collectors.toList());
    }
}
