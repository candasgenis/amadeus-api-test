package com.candasgenis.amadeusapitest.controller;

import com.amadeus.exceptions.ResponseException;
import com.candasgenis.amadeusapitest.service.AmadeusApiServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class AmadeusApiController {
    private final AmadeusApiServiceImpl amadeusApiServiceImpl;

    public AmadeusApiController(AmadeusApiServiceImpl amadeusApiServiceImpl) {
        this.amadeusApiServiceImpl = amadeusApiServiceImpl;
    }

    @GetMapping("/amadeus/getLocations")
    public String getLocations(@RequestParam String keyword, @RequestParam String subType) throws ResponseException {
        return Arrays.toString(amadeusApiServiceImpl.getLocations(keyword, subType));
    }
}
