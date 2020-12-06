package com.cts.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cts.domain.WashingMachine;


public interface WashingMachineRepository extends CrudRepository<WashingMachine, Long> {
    List<WashingMachine> findAll();
    WashingMachine save(WashingMachine appliance);
}
