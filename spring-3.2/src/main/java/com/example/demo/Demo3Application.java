package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
@EnableCaching
@RequiredArgsConstructor
public class Demo3Application {

  private final HelloService helloService;

  public static void main(String[] args) {
    SpringApplication.run(Demo3Application.class, args);
  }


  @Bean
  CommandLineRunner test() {

    return e -> {
    };
  }
}
