package com.example.demo.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestCacheService {
//  spring.cache.cache-names=StudentCache, CourseCache
//  spring.cache.caffeine.spec=initialCapacity=50,maximumSize=10,expireAfterAccess=300s
  @Cacheable(value = "test")
  public String test() {
    log.info("reload");
    return "oscar";
  }

}
