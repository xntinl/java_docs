package com.example.simplerest.domain.port;

import com.example.simplerest.infrastructure.entity.Account;

import java.util.Collection;

public interface IAccountService {

    Collection<Account> getAccounts(String username);
}
