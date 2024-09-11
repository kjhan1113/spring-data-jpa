package com.springboot.springdatajpa.repository;

import com.springboot.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmailWithQuery(String email);

    @Query("SELECT s FROM Student s WHERE s.firstName = ?1 AND s.age >= ?2")
    List<Student> findStudentsByFirstNameEqualsAndAgeIsGreaterThanEqualWithQuery(String firstName, Integer age);
}