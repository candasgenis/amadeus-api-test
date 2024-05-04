package com.candasgenis.amadeusapitest.service;

import com.google.gson.JsonObject;

public interface AmadeusApiService {
    JsonObject getLocations(String keyword, String subType) throws Exception;
}
