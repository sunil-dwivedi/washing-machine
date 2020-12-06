package com.cts.dao;

import org.springframework.data.repository.CrudRepository;

import com.cts.process.Drying;

public interface DryingRepository extends CrudRepository<Drying, Long> {
    Drying save(Drying process);
}
