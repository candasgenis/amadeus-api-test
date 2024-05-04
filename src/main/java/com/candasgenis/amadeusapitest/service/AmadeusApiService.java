package com.candasgenis.amadeusapitest.service;

import com.amadeus.exceptions.ResponseException;
import com.google.gson.JsonObject;

public interface AmadeusApiService {
    JsonObject getLocations(String keyword, String subType) throws ResponseException;
}
