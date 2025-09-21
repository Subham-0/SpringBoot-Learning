package com.subham.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.subham.spring.service.CurdRepositoryOpration;

@Component
public class RepoTestController implements CommandLineRunner {

	@Autowired
	private final CurdRepositoryOpration opration;

	public RepoTestController(CurdRepositoryOpration opration) {
		this.opration = opration;
	}

	@Override
	public void run(String... args) throws Exception {
//		opration.testSave();
//		opration.testSaveAll();
//		opration.testfindAll();
//		opration.testfindAllById();
//		opration.testFindById();
//		opration.testExistsById();
//		opration.testCount();
//		opration.testDelete(293);
//		opration.testDeleteAllById();
		opration.testDeleteAll();
	}

}
