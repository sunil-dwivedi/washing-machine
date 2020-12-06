package com.cts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.ProgramRepository;
import com.cts.program.Program;
import com.cts.service.ProgramService;


@Service
public class ProgramServiceImpl implements ProgramService {
	private final ProgramRepository programRepository;

	@Autowired
	public ProgramServiceImpl(ProgramRepository programRepository) {
		this.programRepository = programRepository;
	}

	@Override
	public Program save(Program program) {
		return programRepository.save(program);
	}
}
