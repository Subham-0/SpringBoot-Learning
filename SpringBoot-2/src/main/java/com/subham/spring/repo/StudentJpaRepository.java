package com.subham.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.subham.spring.entity.Student;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Integer> {

	Student findByName(String name);

	Student findByAddress(String address);

	Student findByNameAndAddress(String name, String address);

	List<Student> findByNameOrAddress(String name, String address);

	List<Student> findByAddressIsNull();

	List<Student> findByAddressIsNotNull();

	List<Student> findByNameLike(String name);

	List<Student> findByNameStartingWith(String name);

	List<Student> findByNameContaining(String name);

	List<Student> findByOrderByNameDesc();

	boolean existsByName(String name);

    boolean existsByNameIgnoreCase(String name);

    boolean existsByAddressIgnoreCase(String address);

	@Query("select st from Student st where st.name=:n or st.address=:a")
	List<Student> getStudentByNameOrAddress(@Param("n") String name,@Param("a") String address);

	@Query("select st from Student st where st.name=?1 and st.address=?2")
	Student getStudentByNameAndAddress(String name, String address);

	@Query("select st from Student st where st.name like :n")
	List<Student> searchByName(@Param("n") String name);

}
