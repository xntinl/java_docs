package com.demo.servicea;


import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ControllerA {

  private final RestTemplate restTemplate;

  AtomicInteger inc = new AtomicInteger(0);

  @GetMapping("/service/a")
//  @CircuitBreaker(name = "serviceA", fallbackMethod = "getB")
//  @Retry(name = "serviceA")
  @RateLimiter(name = "serviceA")
  public String get() {
    log.info(inc.getAndIncrement() + "");
    return restTemplate.getForObject("http://localhost:8090/service/b", String.class);
  }

  public String getB(Exception e) {
    return "backup";
  }


}
