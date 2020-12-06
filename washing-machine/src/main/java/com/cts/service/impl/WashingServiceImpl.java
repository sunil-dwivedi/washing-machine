package com.cts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.WashingRepository;
import com.cts.process.Washing;
import com.cts.service.WashingService;


@Service
public class WashingServiceImpl implements WashingService {
    private final WashingRepository washingRepository;

    @Autowired
    public WashingServiceImpl(WashingRepository washingRepository) {
        this.washingRepository = washingRepository;
    }

    @Override
    public Washing save(Washing washing) {
        return washingRepository.save(washing);
    }
}
