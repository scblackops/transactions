package com.sbc.digital.transactions.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class Address {

    private String shortFormatted;

    private String formatted;

    private String addressLine1;

    private String addressLine2;

    @JsonProperty("region")
    private String addressLine3;

    private String townOrCity;

    private String country;

    private String postcode;

    //TODO: Change this to geojson
    private Double latitude;

    private Double longitude;

}
