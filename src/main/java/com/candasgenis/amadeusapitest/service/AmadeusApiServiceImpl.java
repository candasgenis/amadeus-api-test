package com.candasgenis.amadeusapitest.service;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Location;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AmadeusApiServiceImpl implements AmadeusApiService {
    Amadeus amadeus;
    String clientId;
    String clientSecret;

    public AmadeusApiServiceImpl(@Value("${amadeus.client.id}") String clientId, @Value("${amadeus.client.secret}") String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.amadeus = this.getAmadeus(this.clientId, this.clientSecret);
    }

    private Amadeus getAmadeus(String clientId, String clientSecret) {
        return Amadeus
                .builder(clientId, clientSecret)
                .build();
    }

    public JsonObject getLocations(String keyword, String subType) throws ResponseException {
        Params params = Params.with("keyword", keyword).and("subType", subType);
        Location[] locations = this.amadeus.referenceData.locations.get(params);
        return locations[0].getResponse().getResult();
    }

    public JsonObject getFlightOfferSearch(String originLocationCode, String destinationLocationCode,
                                                    String departureDate, String adults) throws ResponseException {
        Params params = Params.with("originLocationCode", originLocationCode)
                .and("destinationLocationCode", destinationLocationCode)
                .and("departureDate", departureDate)
                .and("adults", adults);
        FlightOfferSearch[] flightOffersSearchResult = this.amadeus.shopping.flightOffersSearch.get(params);
        return flightOffersSearchResult[0].getResponse().getResult();
    }
}
