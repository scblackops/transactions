package com.sbc.digital.transactions.service;

import com.sbc.digital.transactions.models.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

public sealed interface TransactionService permits TransactionServiceImpl{

    Mono<Void> addTransaction(Transaction transaction);

    Mono<Void> addTransactions(List<Transaction> transactionList);

    Mono<Void> updateTransaction(Transaction transaction);

    Mono<Void> updateTransactions(List<Transaction> transaction);

    Flux<Transaction> getTransaction(String transactionId);

    Flux<Transaction> getTransactions(List<String> transactionIdList);

    Flux<Transaction> getTransactionsForCustomer(String customerId);

    Flux<Transaction> getTransactionsForCustomerLimitedNumber(String customerId, Integer numberOfTransactions);

    Flux<Transaction> getTransactionsForCustomerDateRange(String customerId, LocalDate from, LocalDate to);


}
