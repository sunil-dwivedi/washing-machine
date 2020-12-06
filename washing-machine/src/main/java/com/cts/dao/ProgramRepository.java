package com.cts.dao;

import org.springframework.data.repository.CrudRepository;

import com.cts.program.Program;

public interface ProgramRepository extends CrudRepository<Program, Long> {
	Program save(Program program);
}
