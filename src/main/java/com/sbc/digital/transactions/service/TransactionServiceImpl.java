package com.sbc.digital.transactions.service;

import com.sbc.digital.transactions.models.Transaction;
import io.micronaut.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

@Bean
public final class TransactionServiceImpl implements TransactionService{



    @Override
    public Mono<Void> addTransaction(Transaction transaction) {
        return Mono.just(null);
    }

    @Override
    public Mono<Void> addTransactions(List<Transaction> transactionList) {
        return Mono.just(null);
    }

    @Override
    public Mono<Void> updateTransaction(Transaction transaction) {
        return Mono.just(null);

    }

    @Override
    public Mono<Void> updateTransactions(List<Transaction> transaction) {
        return Mono.just(null);

    }

    @Override
    public Flux<Transaction> getTransaction(String transactionId) {
        return null;
    }

    @Override
    public Flux<Transaction> getTransactions(List<String> transactionIdList) {
        return null;
    }

    @Override
    public Flux<Transaction> getTransactionsForCustomer(String customerId) {
        return null;
    }

    @Override
    public Flux<Transaction> getTransactionsForCustomerLimitedNumber(String customerId, Integer numberOfTransactions) {
        return null;
    }

    @Override
    public Flux<Transaction> getTransactionsForCustomerDateRange(String customerId, LocalDate from, LocalDate to) {
        return null;
    }
}
