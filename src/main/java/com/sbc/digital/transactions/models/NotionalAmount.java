package com.sbc.digital.transactions.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Currency;

@Value
public class NotionalAmount {

    Currency currency;

    BigDecimal value;

//    @JsonCreator
//    NotionalAmount(BigDecimal amountInPHP){
//        this.currency = Currency.getInstance("PHP");
//        this.amount = amountInPHP;
//    }

}
