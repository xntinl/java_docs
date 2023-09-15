package com.example.demo;


import com.example.demo.persistence.HelloRepository;
import com.example.demo.rest.JsonPlaceholderServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {
  private final JsonPlaceholderServiceV2 jsonPlaceholderServiceV2;
  private final HelloRepository helloRepository;

  public void saveAll() {
    jsonPlaceholderServiceV2.findAll()
        .forEach(e -> helloRepository.save(e.title()));
  }

}
