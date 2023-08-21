package com.example.simplerest.infrastructure.rest;

import com.example.simplerest.domain.port.IAccountService;
import com.example.simplerest.infrastructure.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AccountController {

    private final IAccountService accountService;

    @GetMapping("/account")
    public Collection<Account> getAccounts(@RequestParam String username){
        return accountService.getAccounts(username);
    }

}
