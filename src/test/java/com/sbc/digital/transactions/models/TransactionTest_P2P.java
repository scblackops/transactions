package com.sbc.digital.transactions.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest_P2P {

    protected static ObjectMapper mapper;

    @BeforeAll
    public static void configureTime(){
        mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    private static final String P2P_TRANSACTION_FIXTURE = """
            {
              "id": "tx_0000A77O7GEEpdtOLGnLt3",
              "created": "2021-05-10T21:00:41.488Z",
              "description": "Harrods Lui",
              "amount": {
                "value": 5000,
                "currency": "GBP"
                }, 
              "fees": {},
              "merchant": null,
              "notes": "",
              "metadata": {
                "p2p_initiator": "p2p",
                "p2p_transfer_id": "p2p_0000A77O7E6MjxBSd37Csb"
              },
              "labels": null,
              "attachments": null,
              "international": null,
              "category": "general",
              "categories": null,
              "is_load": false,
              "settled": "2021-05-10T21:00:41.488Z",
              "local_amount": 5000,
              "local_currency": "GBP",
              "updated": "2021-05-10T21:00:41.688Z",
              "account_id": "acc_0000A6wSscpEtiRcBCGFes",
              "user_id": "",
              "counterparty": {
                "account_id": "acc_0000A2yFh95u0CKV3a7Ubh",
                "name": "Harrods Lui",
                "preferred_name": "Harrods Lui",
                "user_id": "user_0000A2yEuCe00zLeu5zyXh"
              },
              "scheme": "p2p_payment",
              "dedupeId": "p2p-payment:acc_0000A6wSscpEtiRcBCGFes:acc_0000A2yFh95u0CKV3a7Ubhuser_0000A2yEuCe00zLeu5zyXh:3E02CB07-7FFF-4847-8446-BCCB52F4976F",
              "originator": false,
              "include_in_spending": false,
              "can_be_excluded_from_breakdown": false,
              "can_be_made_subscription": false,
              "can_split_the_bill": false,
              "can_add_to_tab": false,
              "can_match_transactions_in_categorization": false,
              "amount_is_pending": false,
              "atm_fees_detailed": null,
              "parent_account_id": ""
            }""";


    @Test
    public void testDeserialiseP2Pdata() throws Exception{

        //Arrange


        //Act
        Transaction result = mapper.readValue(P2P_TRANSACTION_FIXTURE, Transaction.class);

        //Assert
        assertEquals("Harrods Lui", result.getDescription());
        assertEquals("tx_0000A77O7GEEpdtOLGnLt3", result.getId());
        assertEquals("p2p-payment:acc_0000A6wSscpEtiRcBCGFes:acc_0000A2yFh95u0CKV3a7Ubhuser_0000A2yEuCe00zLeu5zyXh:3E02CB07-7FFF-4847-8446-BCCB52F4976F", result.getDedupeId());
        assertEquals("5000", result.getAmount().getValue().toString());
        assertEquals("GBP", result.getAmount().getCurrency().getCurrencyCode());
        assertEquals(2, result.getMetadata().size());

        List<String> metadataKeysResult = result.getMetadata().keySet().stream().collect(Collectors.toList());

        assertEquals("p2p_initiator", metadataKeysResult.get(0));
        assertEquals("p2p_transfer_id", metadataKeysResult.get(1));

        List<String> metadaValuesResult = result.getMetadata().values().stream().collect(Collectors.toList());

        assertEquals("p2p", metadaValuesResult.get(0));
        assertEquals("p2p_0000A77O7E6MjxBSd37Csb", metadaValuesResult.get(1));

        assertEquals(LocalDateTime.parse("2021-05-10T21:00:41.488"), result.getCreated());
        assertEquals(LocalDateTime.parse("2021-05-10T21:00:41.488"), result.getSettled());
        assertEquals(LocalDateTime.parse("2021-05-10T21:00:41.688"), result.getUpdated());



    }

}