package com.sbc.digital.transactions.service;

import io.micronaut.context.annotation.Bean;

@Bean
public class TransactionService {

    public String beep(){
        return "BEEP";
    }

}
