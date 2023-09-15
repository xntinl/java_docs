package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Locale;

@SpringBootTest
class Demo3ApplicationTests {

  @Test
  void testMapOperator() {
    Flux<String> mapExample = Flux.just("one","two","three")
        .map(s->s.toUpperCase(Locale.ROOT).concat(" EXAMPLE"))
        .log();
    StepVerifier.create(mapExample)
        .expectNext("ONE EXAMPLE","TWO EXAMPLE","THREE EXAMPLE")
        .expectComplete()
        .verify();
  }

  @Test
  void testFlatMapOperator(){
    Flux<String> flatMapExample = Flux.just("one","two")
        .flatMap(s->Flux.just(s.toUpperCase(Locale.ROOT).split("")))
        .log();
    StepVerifier.create(flatMapExample)
        .expectNext("O","N","E","T","W","O")
        .expectComplete()
        .verify();
  }

  @Test
  void testSwitchIfEmptyOperator() {
    Flux<Object> switched = Flux.empty()
        .switchIfEmpty(Mono.just("switched"))
        .log();
    StepVerifier.create(switched)
        .expectSubscription()
        .expectNext("switched")
        .expectComplete()
        .verify();
  }

  @Test
  void testContactOperator(){
    Flux<String> flux1 = Flux.just("a","b","c");
    Flux<String> flux2 = Flux.just("d","e");
    Flux<String> concatFlux = Flux.concat(flux1,flux2).log();
    StepVerifier.create(concatFlux)
        .expectSubscription()
        .expectNext("a","b","c","d","e")
        .expectComplete()
        .verify();
  }

  @Test
  void testZipOperator(){
    Flux<String> flux1 = Flux.just("1","2","3");
    Flux<String> flux2 = Flux.just("a","b","c");
    Flux<String> zip = Flux.zip(flux1,flux2,(a,b)->a+" "+b).log();
    StepVerifier.create(zip)
        .expectSubscription()
        .expectNext("1 a","2 b","3 c")
        .expectComplete()
        .verify();
  }

}
