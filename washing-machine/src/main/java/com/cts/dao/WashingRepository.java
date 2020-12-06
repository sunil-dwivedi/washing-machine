package com.cts.dao;

import org.springframework.data.repository.CrudRepository;

import com.cts.process.Washing;


public interface WashingRepository extends CrudRepository<Washing, Long> {
    Washing save(Washing washing);
}
