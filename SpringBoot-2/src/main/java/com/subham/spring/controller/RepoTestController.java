package com.subham.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.subham.spring.service.CurdRepositoryOpration;
import com.subham.spring.service.JpaRepositoryOpration;

@Component
public class RepoTestController implements CommandLineRunner {

	@Autowired
	private final CurdRepositoryOpration opration;

	@Autowired
	private final JpaRepositoryOpration opration2;

	public RepoTestController(CurdRepositoryOpration opration, JpaRepositoryOpration opration2) {
		this.opration = opration;
		this.opration2 = opration2;

	}

	@Override
	public void run(String... args) throws Exception {
		// ======================
		// Using CrudRepository
		// ======================
		// opration.testSave(); 					// Save a single student
		// opration.testSaveAll(); 				// Save multiple students
		 //opration.testFindAll();			 	// Fetch all students
		 //opration.testFindAllById(); 			// Fetch multiple students by IDs
		 opration.testFindById(); 				// Fetch a student by ID
		 opration.testExistsById();		 	// Check if student exists by ID
		 opration.testCount(); 				// Count total number of students
		//opration.testDelete(293);				// Delete a student by ID
		// opration.testDeleteAllById();		 	// Delete multiple students by IDs
		// opration.testDeleteAll(); 			// Delete all students

		// ======================
		// Using JpaRepository (Derived Queries & Custom Queries & Pagination)
		// ======================
		 opration2.findByName("Subham"); 				// Find by name
		 opration2.findByAddress("BBSR"); 				// Find by address
		 opration2.findByNameAndAddress("Subham", "BBSR"); // Find by name AND address
		 opration2.findByNameOrAddress("Subham", "BBSR"); // Find by name OR address
		 opration2.findByAddressIsNull(); 				// Find students with NULL address
		 opration2.findByAddressIsNotNull(); 			// Find students with NON-NULL address

		// LIKE example → will match %Subham%
		 opration2.findByNameLike("%Subham%");

		// StartingWith example → names starting with 'S'
		 opration2.findByNameStartingWith("S");

		// Containing example → names containing 'an'
		 opration2.findByNameContaining("an");

		// OrderByNameDesc → no parameter needed
		 opration2.findByOrderByNameDesc();

		// Exists by Name → should return true if exists
		 opration2.existsByName("Rahul");

		// Exists by Name Ignore Case → 'subham' in lowercase
		 opration2.existsByAllIgnoreCaseName("subham");

		// Exists by Address Ignore Case → 'bhubaneswar' in lowercase
		 opration2.existsByIgnoreCaseAddress("bhubaneswar");

		// Custom query → name or address match
		 opration2.getStudentByNameOrAddress("Ravi", "Mumbai");

		// Custom query → both name and address must match
		 opration2.getStudentByNameAndAddress("Sourav", "Baleswar");

		// Custom query →Search by name using LIKE query
		opration2.searchByName("%a%");
		
		
		
		// pagination
		opration2.paggging1Test();

	}

}
