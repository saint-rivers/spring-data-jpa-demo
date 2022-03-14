package com.example.demo.simplestudent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleStudentRepository extends JpaRepository<StudentSimple, Long> {
}
