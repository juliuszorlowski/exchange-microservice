package com.hlag.exchangemicroservice.search.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.simple.JSONObject;

@Service
public class RateService {
    private final RestTemplate restTemplate;
    private final SearchService searchService;

    public RateService(RestTemplate restTemplate, SearchService searchService) {
        this.restTemplate = restTemplate;
        this.searchService = searchService;
    }

    public String getRate(String rateDate) {
        JSONObject forEntity = restTemplate.getForEntity("https://www.frankfurter.app/" + rateDate + "?to=USD", JSONObject.class).getBody();
        String exchangeDate = forEntity.get("date").toString();
        String exchangeRate = forEntity.get("rates").toString().substring(5,11).trim();
        searchService.saveSearch(exchangeDate,Double.parseDouble(exchangeRate));
        return exchangeRate;
    }
}
