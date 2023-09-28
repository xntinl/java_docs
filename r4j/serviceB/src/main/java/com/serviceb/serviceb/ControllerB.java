package com.serviceb.serviceb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerB {


  @GetMapping("/service/b")
  public String get() {
    return "service b";
  }

}
