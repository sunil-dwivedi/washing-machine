package com.cts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.WashingMachineRepository;
import com.cts.domain.WashingMachine;
import com.cts.service.WashingMachineService;

@Service
public class WashingMachineServiceImpl implements WashingMachineService {
	private final WashingMachineRepository washingMachineRepository;

	@Autowired
	public WashingMachineServiceImpl(WashingMachineRepository washingMachineRepository) {
		this.washingMachineRepository = washingMachineRepository;
	}

	@Override
	public WashingMachine getFirst() {
		List<WashingMachine> all = washingMachineRepository.findAll();
		return all.size() == 0 ? null : all.get(0);
	}

	@Override
	public WashingMachine save(WashingMachine washingMachine) {
		return washingMachineRepository.save(washingMachine);
	}
}
