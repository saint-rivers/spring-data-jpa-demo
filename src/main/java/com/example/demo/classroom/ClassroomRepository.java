package com.example.demo.classroom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

    Classroom findByName(String classname);

    List<Classroom> findByFloorOrderByName(Integer floorNumber);

    Boolean findClassroomByNameExists(String name);
}
