package com.sbc.digital.transactions.models;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class Address {

    @NonNull
    String addressLine1;

    @NonNull
    String addressLine2;

    String addressLine3;

    String addressLine4;

    String postCode;

    @NonNull
    Country country;

    @NonNull
    LocalDate atAddressSince;

}
