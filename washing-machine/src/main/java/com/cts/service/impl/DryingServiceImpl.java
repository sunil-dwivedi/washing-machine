package com.cts.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.DryingRepository;
import com.cts.process.Drying;
import com.cts.service.DryingService;

@Service
public class DryingServiceImpl implements DryingService {
    private final DryingRepository dryingRepository;

    @Autowired
    public DryingServiceImpl(DryingRepository dryingRepository) {
        this.dryingRepository = dryingRepository;
    }

    @Override
    public Drying save(Drying drying) {
        return dryingRepository.save(drying);
    }
}
