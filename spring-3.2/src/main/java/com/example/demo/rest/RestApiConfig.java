package com.example.demo.rest;


import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.concurrent.TimeUnit;

@Configuration

public class RestApiConfig {

  @Bean
  JsonPlaceholderServiceV2 jsonPlaceholderService() {
    RestClient restClient = RestClient
        .create("https://jsonplaceholder.typicode.com");
    HttpServiceProxyFactory factory = HttpServiceProxyFactory
        .builderFor(RestClientAdapter.create(restClient))
        .build();
    return factory.createClient(JsonPlaceholderServiceV2.class);
  }


  @Bean
  public CacheManager cacheManager() {
    CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
    caffeineCacheManager.setCaffeine(Caffeine.newBuilder()
        .expireAfterWrite(5, TimeUnit.SECONDS));
    return caffeineCacheManager;
  }

}
