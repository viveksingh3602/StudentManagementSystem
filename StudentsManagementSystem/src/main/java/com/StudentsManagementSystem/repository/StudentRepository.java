package com.StudentsManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentsManagementSystem.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student, Integer> {

}
