package com.sbc.digital.transactions.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Value
@JsonIgnoreProperties(ignoreUnknown =true)
@Builder
public class Transaction {

    @NonNull
    String id;

    @NonNull LocalDateTime created;

    @NonNull
    String description;

    String category;

    @NonNull
    NotionalAmount amount;

    NotionalAmount localAmount;

    LocalDateTime settled;

    LocalDateTime updated;

    Map<String, String> metadata;

    List<String> labels;

    Merchant merchant;

    //List<Fee> fees;

    String notes;

    URI image;

    List<URI> attachments;

    String dedupeId;

}
