package com.hlag.exchangemicroservice.search.repository;

import com.hlag.exchangemicroservice.search.model.Search;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SearchRepository extends JpaRepository<Search, Long> {
    @Override
    List<Search> findAll();
}
