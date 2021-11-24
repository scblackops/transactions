package com.sbc.digital.transactions.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTest_Overseas {

    protected static ObjectMapper mapper;

    @BeforeAll
    public static void configureTime(){
        mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }



    private static final String OVERSEAS_PAYMENT_FIXTURE = """
            {
                  "id": "tx_0000ACmFdpJlCnnTBzjjIf",
                  "created": "2021-10-27T03:29:24.229Z",
                  "description": "HOTEL INDIGO PHUKET PA PHUKET        THA",
                  "amount": {
                    "value": -8438,
                    "currency": "THB"
                    }, 
                  "fees": {},
                  "merchant": {
                    "id": "merch_00009q5Iwtc6NuP1XdwRxB",
                    "group_id": "grp_00009eJlXz1eBiei5w5Azx",
                    "created": "2019-12-18T09:07:39.164Z",
                    "name": "Hotel Indigo Phuket Pa",
                    "logo": "",
                    "emoji": "",
                    "category": "holidays",
                    "online": false,
                    "atm": false,
                    "address": {
                      "short_formatted": "124 Rat U Thit 200 Pee Rd., Tambon Patong, Chang Wat Phuket, 83150, Thailand",
                      "formatted": "124 Rat U Thit 200 Pee Rd., Tambon Patong, Chang Wat Phuket, 83150, Thailand",
                      "addressLine1": "124 RAT U THIT 200 PEE RD.",
                      "townOrCity": "Tambon Patong",
                      "region": "Chang Wat Phuket",
                      "country": "TH",
                      "postcode": "83150",
                      "latitude": 7.899286999999998,
                      "longitude": 98.299809,
                      "zoom_level": 17,
                      "approximate": false
                    },
                    "updated": "2019-12-19T00:33:55.028Z",
                    "metadata": {
                      "created_for_transaction": "tx_00009q5Iwt4QP7SprCBYSf",
                      "enriched_from_settlement": "tx_00009q5Iwt4QP7SprCBYSf",
                      "google_places_icon": "https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png",
                      "google_places_id": "ChIJf6Yyi5Q7UDAREHCHXOoRx90",
                      "google_places_name": "Hotel Indigo Phuket Patong",
                      "suggested_name": "Hotel Indigo Phuket Patong"
                    },
                    "disable_feedback": false
                  },
                  "notes": "",
                  "metadata": {
                    "coin_jar_transaction": "tx_0000ACmFdrkQAeDQh7Ax5V",
                    "ledger_insertion_id": "entryset_0000ACmFdoUMHuAiQssvmD",
                    "mastercard_approval_type": "full",
                    "mastercard_auth_message_id": "mcauthmsg_0000ACmFdo1zzLzlCcQ1yb",
                    "mastercard_card_id": "mccard_0000A8u9VG2RG89PcTUfpa",
                    "mastercard_lifecycle_id": "mclifecycle_0000ACmFdoDLJAVC9x7MzB",
                    "mcc": "7011",
                    "trip_id": "trip_0000ACmEpWYSgvqd7OUEDp"
                  },
                  "labels": null,
                  "attachments": null,
                  "international": null,
                  "category": "holidays",
                  "categories": {
                    "holidays": -8438
                  },
                  "is_load": false,
                  "settled": "2021-10-27T23:38:23.424Z",
                  "local_amount": -382685,
                  "local_currency": "THB",
                  "updated": "2021-10-27T23:38:23.552Z",
                  "account_id": "acc_0000A6wSscpEtiRcBCGFes",
                  "user_id": "user_0000A6wS82kQhWuC2MMkei",
                  "counterparty": {},
                  "scheme": "mastercard",
                  "dedupe_id": "mclifecycle:mclifecycle_0000ACmFdoDLJAVC9x7MzB:MASTERCARD_AUTH:mcauthmsg_0000ACmFdo1zzLzlCcQ1yb",
                  "originator": false,
                  "include_in_spending": true,
                  "can_be_excluded_from_breakdown": true,
                  "can_be_made_subscription": true,
                  "can_split_the_bill": true,
                  "can_add_to_tab": true,
                  "can_match_transactions_in_categorization": true,
                  "virtual_card": {
                    "id": "virtcard_0000A8u9VFVpDO1PkeL2TR",
                    "account_id": "acc_0000A6wSscpEtiRcBCGFes",
                    "name": "Transport",
                    "card_design_id": "mccarddesign_monzo_virtual_sand",
                    "card_details": {
                      "card_id": "mccard_0000A8u9VG2RG89PcTUfpa",
                      "last_digits": "6623",
                      "name": "ALEXANDER BOWERS",
                      "expires": "07/2026"
                    },
                    "source_details": {
                      "type": "",
                      "source_id": "",
                      "name": ""
                    },
                    "created": "2021-07-03T07:29:54.715Z"
                  },
                  "amount_is_pending": false,
                  "atm_fees_detailed": null,
                  "parent_account_id": ""
                }""";

    @Test
    public void testDeserialiseP2Pdata() throws Exception{

        //Arrange

        //Act
        var result = mapper.readValue(OVERSEAS_PAYMENT_FIXTURE, Transaction.class);

        //Assert
        assertEquals("2021-10-27T03:29:24.229", result.getCreated().toString());
        assertEquals(new BigDecimal("-8438"),result.getAmount().getValue());
        assertEquals("THB",result.getAmount().getCurrency().toString());
        assertEquals("tx_0000ACmFdpJlCnnTBzjjIf",result.getId());
        assertEquals("merch_00009q5Iwtc6NuP1XdwRxB",result.getMerchant().getId());
        assertEquals(false,result.getMerchant().getAtm());
        assertEquals("holidays",result.getMerchant().getCategory());
        assertEquals("124 RAT U THIT 200 PEE RD.",result.getMerchant().getAddress().getAddressLine1());
        assertEquals("Tambon Patong",result.getMerchant().getAddress().getTownOrCity());
        assertEquals("83150",result.getMerchant().getAddress().getPostcode());
        assertEquals("Chang Wat Phuket",result.getMerchant().getAddress().getAddressLine3());

    }

}