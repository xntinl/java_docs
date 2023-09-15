package com.example.demo.rest;

import org.springframework.web.service.annotation.GetExchange;

import java.util.Collection;

public interface JsonPlaceholderServiceV2 {
  @GetExchange("/posts")
  Collection<Post> findAll();

}
