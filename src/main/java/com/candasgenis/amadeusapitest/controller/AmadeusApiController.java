package com.candasgenis.amadeusapitest.controller;

import com.amadeus.exceptions.ResponseException;
import com.candasgenis.amadeusapitest.service.AmadeusApiServiceImpl;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmadeusApiController {
    private final AmadeusApiServiceImpl amadeusApiServiceImpl;

    public AmadeusApiController(AmadeusApiServiceImpl amadeusApiServiceImpl) {
        this.amadeusApiServiceImpl = amadeusApiServiceImpl;
    }

    @GetMapping("/amadeus/locations")
    public JsonObject getLocations(@RequestParam String keyword, @RequestParam String subType) throws ResponseException {
        return amadeusApiServiceImpl.getLocations(keyword, subType);
    }

    @GetMapping("/amadeus/shopping/flight-offers")
    public JsonObject flightOffersSearch(@RequestParam String originLocationCode, @RequestParam String destinationLocationCode,
                                     @RequestParam String departureDate, @RequestParam String adults) throws ResponseException {
        return amadeusApiServiceImpl.getFlightOfferSearch(originLocationCode, destinationLocationCode,
                departureDate, adults);
    }
}
