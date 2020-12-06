package com.cts.dao;

import org.springframework.data.repository.CrudRepository;

import com.cts.process.Squeaking;

public interface SqueakingRepository extends CrudRepository<Squeaking, Long> {
	Squeaking save(Process Squeaking);
}
