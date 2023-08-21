package com.example.simplerest.infrastructure.repository;

import com.example.simplerest.infrastructure.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Collection;

public interface AccountRepository extends MongoRepository<Account,String> {

    @Query(value = "{'username': ?0}")
    Collection<Account> findByUsername(String username);

}