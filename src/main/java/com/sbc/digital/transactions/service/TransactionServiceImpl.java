package com.sbc.digital.transactions.service;

import com.sbc.digital.transactions.models.Transaction;
import io.micronaut.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.List;

@Bean
public final class TransactionServiceImpl implements TransactionService{

    @Override
    public void addTransaction(Transaction transaction) {

    }

    @Override
    public void addTransactions(List<Transaction> transactionList) {

    }

    @Override
    public void updateTransaction(Transaction transaction) {

    }

    @Override
    public void updateTransactions(List<Transaction> transaction) {

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
