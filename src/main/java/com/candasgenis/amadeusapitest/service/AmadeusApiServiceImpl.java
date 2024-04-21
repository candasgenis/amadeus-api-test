package com.candasgenis.amadeusapitest.service;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Location;
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
        System.out.println("CLIENT ID VE SECRET PRINTLENIYOR");
        System.out.println(this.clientId);
        System.out.println(this.clientSecret);
        this.amadeus = this.getAmadeus(this.clientId, this.clientSecret);
    }

    private Amadeus getAmadeus(String clientId, String clientSecret) {
        return Amadeus
                .builder(clientId, clientSecret)
                .build();
    }

    public Location[] getLocations(String keyword, String subType) throws ResponseException {
        Params params = Params.with("keyword", keyword).and("subType", subType);
        return this.amadeus.referenceData.locations.get(params);
    }
}
