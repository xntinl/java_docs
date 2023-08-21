package com.example.demo.infrastructure.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(value = "account")
public class Account {
    @Id
    private String id;
    private String owner;
    private String username;

}
