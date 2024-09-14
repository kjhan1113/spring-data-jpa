package com.springboot.springdatajpa.repository;

import com.springboot.springdatajpa.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        // Given
        studentRepository.save(new Student("John", "Doe", "john.doe@example.com", 20));
        studentRepository.save(new Student("Jane", "Doe", "jane.doe@example.com", 22));
        studentRepository.save(new Student("John", "Smith", "john.smith@example.com", 25));
        studentRepository.save(new Student("Jim", "JDK", "jim.jdk@example.com", 30));
    }

    @Test
    void testFindStudentByEmail() {
        // When
        Optional<Student> student = studentRepository.findStudentByEmail("john.smith@example.com");

        // Then
        assertTrue(student.isPresent());
        assertEquals("John", student.get().getFirstName());
    }

    @Test
    void testCountByLastName() {
        // When
        long count = studentRepository.countByLastName("Doe");

        // Then
        assertThat(count).isEqualTo(2);
    }

    @Test
    void testFindByAgeLessThanEqual() {
        // When
        List<Student> students = studentRepository.findByAgeLessThanEqual(22);

        // Then
        assertThat(students).hasSize(2);
        assertThat(students).extracting("firstName").containsExactlyInAnyOrder("John", "Jane");
    }

    @Test
    void testFindStudentsByFirstNameAndAgeEquals() {
        // When
        List<Student> students = studentRepository.findStudentsByFirstNameAndAgeEquals("Jane", 22);

        // Then
        assertThat(students).hasSize(1);
        assertThat(students.getFirst().getFirstName()).isEqualTo("Jane");
    }

    @Test
    void testFindByLastNameOrderByLastNameAsc() {
        // When
        List<Student> students = studentRepository.findByLastNameOrderByLastNameAsc("Doe");

        // Then
        assertThat(students).hasSize(2);
        assertThat(students).extracting("firstName").containsExactly("John", "Jane");
    }

    @Test
    void testFindByLastNameAndAgeOrderByFirstNameAsc() {
        // When
        List<Student> students = studentRepository.findByLastNameAndAgeOrderByFirstNameAsc("Doe", 22);

        // Then
        assertThat(students).hasSize(1);
        assertThat(students.getFirst().getFirstName()).isEqualTo("Jane");
    }

    @Test
    void testFindByEmailContaining() {
        // When
        List<Student> students = studentRepository.findByEmailContaining("doe");

        // Then
        assertThat(students).hasSize(2);
        assertThat(students).extracting("firstName").containsExactlyInAnyOrder("John", "Jane");
    }

    @Test
    void testFindByAgeBetween() {
        // When
        List<Student> students = studentRepository.findByAgeBetween(20, 22);

        // Then
        assertThat(students).hasSize(2);
        assertThat(students).extracting("firstName").containsExactlyInAnyOrder("John", "Jane");
    }

    @Test
    void testFindStudentByEmailWithQuery() {
        // When
        Optional<Student> student = studentRepository.findStudentByEmailWithQuery("john.doe@example.com");

        // Then
        assertThat(student).isPresent();
        assertThat(student.get().getFirstName()).isEqualTo("John");
    }

    @Test
    void testFindStudentsByFirstNameEqualsAndAgeIsGreaterThanEqualWithQuery() {
        // When
        List<Student> students = studentRepository.findStudentsByFirstNameEqualsAndAgeIsGreaterThanEqualWithQuery("Jim", 25);

        // Then
        assertThat(students).hasSize(1);
        assertThat(students.getFirst().getFirstName()).isEqualTo("Jim");
    }
}