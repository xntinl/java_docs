package com.example.demo;

import java.util.Objects;

public record Book(Integer id) {
  public Book {
    Objects.requireNonNull(id,"id not null");
  }
}
