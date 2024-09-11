package com.springboot.springdatajpa.repository;

import com.springboot.springdatajpa.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        // 테스트 데이터 삽입
        studentRepository.save(new Student("John", "Doe", "john.doe@example.com", 20));
        studentRepository.save(new Student("Jane", "Doe", "jane.doe@example.com", 22));
        studentRepository.save(new Student("John", "Smith", "john.smith@example.com", 19));
    }

    @Test
    void testFindStudentByEmail() {
        Optional<Student> student = studentRepository.findStudentByEmail("john.smith@example.com");
        assertTrue(student.isPresent());
        assertEquals("John", student.get().getFirstName());
    }

    @Test
    void countByLastName() {
    }

    @Test
    void findByAgeLessThanEqual() {
    }

    @Test
    void findStudentsByFirstNameAndAgeEquals() {
    }

    @Test
    void findByLastNameOrderByLastNameAsc() {
    }

    @Test
    void findByLastNameAndAgeOrderByFirstNameAsc() {
    }

    @Test
    void findByEmailContaining() {
    }

    @Test
    void findByAgeBetween() {
    }

    @Test
    void findStudentByEmailWithQuery() {
    }

    @Test
    void findStudentsByFirstNameEqualsAndAgeIsGreaterThanEqualWithQuery() {
    }
}