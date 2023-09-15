package com.example.demo.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Collection;

@Slf4j
@Service
public class JsonPlaceholderServiceV1 {
  private final RestClient restClient;

  public JsonPlaceholderServiceV1() {
    this.restClient = RestClient.builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .build();
  }

  public Collection<Post> findAll(){
    return restClient.get().uri("/posts")
        .retrieve()
        .body(new ParameterizedTypeReference<>() {
        });
  }

}
