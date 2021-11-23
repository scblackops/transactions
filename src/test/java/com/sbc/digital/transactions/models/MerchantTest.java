package com.sbc.digital.transactions.models;

import static org.junit.jupiter.api.Assertions.*;

class MerchantTest {

    private static final String MERCHANT_FIXTURE = """
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
                      "address": "124 RAT U THIT 200 PEE RD.",
                      "city": "Tambon Patong",
                      "region": "Chang Wat Phuket",
                      "country": "THA",
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
                  },""";

}