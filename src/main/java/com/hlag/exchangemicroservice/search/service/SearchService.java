package com.hlag.exchangemicroservice.search.service;

import com.hlag.exchangemicroservice.search.model.Search;
import com.hlag.exchangemicroservice.search.repository.SearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private final SearchRepository searchRepository;

    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public List<Search> findAll() {
        return searchRepository.findAll();
    }

    public void saveSearch(String exchangeDate, Double exchangeRate) {
        Search search = new Search();
        search.setExchangeRate(exchangeRate);
        search.setRateDate(exchangeDate);
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        search.setSearchDate(date);
        searchRepository.save(search);
    }
}
