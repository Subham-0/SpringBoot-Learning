package com.subham.spring.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.subham.spring.entity.Student;

@Repository
public interface StudentCurdRepository extends CrudRepository<Student,Integer>{

}

