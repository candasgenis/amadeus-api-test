package com.candasgenis.amadeusapitest.service;

import com.amadeus.resources.Location;

public interface AmadeusApiService {
    Location[] getLocations(String keyword, String subType) throws Exception;
}
