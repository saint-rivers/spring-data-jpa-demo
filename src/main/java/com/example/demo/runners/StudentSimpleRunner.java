package com.example.demo.runners;

import com.example.demo.simplestudent.SimpleStudentRepository;
import com.example.demo.simplestudent.StudentSimple;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
public class StudentSimpleRunner implements CommandLineRunner {

    private final SimpleStudentRepository simpleStudentRepository;

    public StudentSimpleRunner(SimpleStudentRepository simpleStudentRepository) {
        this.simpleStudentRepository = simpleStudentRepository;
    }

    @Override
    public void run(String... args) {
        insertStudents();
        StudentSimple fetchedStudent = findById();
        updateStudent(fetchedStudent);
        deleteStudent();
    }

    private void deleteStudent() {
        System.out.println("Deleting student");
        simpleStudentRepository.deleteById(1L);
        System.out.println(simpleStudentRepository.findAll());
    }

    private void updateStudent(StudentSimple fetchedStudent) {
        System.out.println("Updating student");
        fetchedStudent.setEmail("tomholland@gmail.com");
        simpleStudentRepository.save(fetchedStudent);
        System.out.println(simpleStudentRepository.findById(1L).orElseThrow());
    }

    private StudentSimple findById() {
        System.out.println("Fetch student");
        StudentSimple fetchedStudent = simpleStudentRepository.findById(1L).orElseThrow();
        System.out.println(fetchedStudent);
        return fetchedStudent;
    }

    private void insertStudents() {
        StudentSimple student = new StudentSimple(null, "Tom", "Holland", "th@gmail.com", 22);
        StudentSimple student2 = new StudentSimple(null, "Daniel", "Caesar", "dc@gmail.com", 22);
        simpleStudentRepository.save(student);
        simpleStudentRepository.save(student2);
        System.out.println("Displaying all students: ");
        List<StudentSimple> students = simpleStudentRepository.findAll();
        System.out.println(students);
    }

}
