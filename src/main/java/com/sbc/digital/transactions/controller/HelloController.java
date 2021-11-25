package com.sbc.digital.transactions.controller;

import com.sbc.digital.transactions.service.TransactionService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import jakarta.inject.Inject;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller("/hello") 
public class HelloController {

    @Inject
    TransactionService transactionService;

    @Get("/plain")
    @Produces(MediaType.TEXT_PLAIN) 
    public String index() {
        return transactionService.beep();
    }


    @Get("/reactive/mono")
    @Produces(MediaType.TEXT_PLAIN)
    public Mono<Integer> mono() {
        return Mono.just(1);
    }

    @Get("/reactive/flux")
    @Produces(MediaType.TEXT_PLAIN)
    public Flux<Integer> flux() {
        return Flux.just(1,2,3,4);
    }
}

