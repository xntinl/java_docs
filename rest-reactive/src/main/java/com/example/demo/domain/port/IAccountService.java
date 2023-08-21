package com.example.demo.domain.port;

import com.example.demo.infrastructure.repository.Account;
import reactor.core.publisher.Flux;

public interface IAccountService {
     Flux<Account> getAccounts(String username);

}
