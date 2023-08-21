package com.example.demo.infrastructure.rest;


import com.example.demo.domain.port.IAccountService;
import com.example.demo.infrastructure.repository.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AccountController {

    private final IAccountService accountService;

    @GetMapping("/account")
    public Flux<Account> getAccounts(@RequestParam String username){
        return accountService.getAccounts(username);
    }

}
