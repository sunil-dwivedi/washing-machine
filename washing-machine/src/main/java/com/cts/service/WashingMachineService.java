package com.cts.service;

import com.cts.domain.WashingMachine;

public interface WashingMachineService {
    WashingMachine getFirst();
    WashingMachine save(WashingMachine washingMachine);
}
