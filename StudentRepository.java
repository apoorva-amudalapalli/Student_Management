package com.example.student_management.respository;
import com.example.student_management.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface StudentRepository extends JpaRepository<Student, Long> {
	Optional<Student> findByRollNumber(String rollNumber);
    void deleteByRollNumber(String rollNumber);

}
