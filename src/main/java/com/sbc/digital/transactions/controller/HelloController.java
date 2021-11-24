package com.sbc.digital.transactions.controller;

import com.sbc.digital.transactions.service.TransactionService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import jakarta.inject.Inject;

@Controller("/hello") 
public class HelloController {

    @Inject
    TransactionService transactionService;

    @Get 
    @Produces(MediaType.TEXT_PLAIN) 
    public String index() {
        return transactionService.beep();
    }
}