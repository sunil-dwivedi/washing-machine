package com.cts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.SqueakingRepository;
import com.cts.process.Squeaking;
import com.cts.service.SqueakingService;

@Service
public class SqueakingServiceImpl implements SqueakingService {
    private final SqueakingRepository squeakingRepository;

    @Autowired
    public SqueakingServiceImpl(SqueakingRepository squeakingRepository) {
        this.squeakingRepository = squeakingRepository;
    }

    @Override
    public Squeaking save(Squeaking squeaking) {
        return squeakingRepository.save(squeaking);
    }
}
