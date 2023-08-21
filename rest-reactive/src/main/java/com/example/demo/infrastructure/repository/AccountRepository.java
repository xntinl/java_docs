package com.example.demo.infrastructure.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface AccountRepository extends ReactiveMongoRepository<Account,String> {

    @Query(value = "{'username': ?0}")
    Flux<Account> findByUsername(String username);

}