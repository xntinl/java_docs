package com.example.demo;

import com.example.demo.persistence.HelloRepository;
import com.example.demo.persistence.Invoice;
import com.example.demo.rest.JsonPlaceholderServiceV1;
import com.example.demo.rest.JsonPlaceholderServiceV2;
import com.example.demo.rest.TestCacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloController {

  private final HelloRepository helloRepository;
  private final JsonPlaceholderServiceV1 jsonPlaceholderServiceV1;
  private final JsonPlaceholderServiceV2 jsonPlaceholderServiceV2;
  private final TestCacheService testCacheService;


  @GetMapping("/hello")
  public ResponseEntity<Invoice> get() {
//    var data = jsonPlaceholderServiceV2.findAll();
    log.info(testCacheService.test());
    return helloRepository.getComprobante()
        .map(ResponseEntity::ok)
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
  }

}
