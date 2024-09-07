package com.springboot.springdatajpa.repository;

import com.springboot.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);

    long countByLastName(String lastName);

    List<Student> findByAgeLessThanEqual(int age);
    List<Student> findStudentsByFirstNameAndAgeEquals(String firstName, Integer age);
    List<Student> findByLastNameOrderByLastNameAsc(String lastName);
    List<Student> findByLastNameAndAgeOrderByFirstNameAsc(String lastName, int age);
    List<Student> findByEmailContaining(String keyword); // like query
    List<Student> findByAgeBetween(int startAge, int endAge); // between query
}
