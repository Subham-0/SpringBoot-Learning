package com.subham.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subham.spring.entity.Mobile;
@Repository
public interface MobileRepo extends JpaRepository<Mobile, Integer> {

}
