package com.hlag.exchangemicroservice.search.controller;

import com.hlag.exchangemicroservice.search.model.Search;
import com.hlag.exchangemicroservice.search.service.RateService;
import com.hlag.exchangemicroservice.search.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    private final SearchService searchService;
    private final RateService rateService;

    public SearchController(SearchService searchService, RateService rateService) {
        this.searchService = searchService;
        this.rateService = rateService;
    }

    @GetMapping("/history")
    public ResponseEntity<List<Search>> findAll() {
        return ResponseEntity.ok(searchService.findAll());
    }

    @GetMapping("/{rateDate}")
    public ResponseEntity<String> getRate(@PathVariable String rateDate) {
        String responseText = rateService.getRate(rateDate);
        return ResponseEntity.ok(responseText);
    }
}
