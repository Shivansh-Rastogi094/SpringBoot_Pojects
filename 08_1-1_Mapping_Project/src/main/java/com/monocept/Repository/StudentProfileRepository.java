package com.monocept.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.model.StudentProfile;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {

	public boolean existsByEmail(String email);
	public boolean existsByEmailAndIdNot(String email, Long id);

}
