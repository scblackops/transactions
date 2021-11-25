package com.sbc.digital.transactions.models;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Merchant {

    String id;

    String groupId;

    String created;

    String name;

    String logo;

    String emoji;

    String category;

    Boolean online;

    Boolean atm;

    Address address;

}
