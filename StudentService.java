package com.example.student_management.service;
import com.example.student_management.model.*;
import com.example.student_management.respository.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student addStudent(Student s) {
        return repo.save(s);
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Optional<Student> findByRoll(String rollNumber) {
        return repo.findByRollNumber(rollNumber);
    }

    public Optional<Student> updateByRoll(String roll, Student updated) {
        return repo.findByRollNumber(roll).map(s -> {
            s.setName(updated.getName());
            s.setDepartment(updated.getDepartment());
            return repo.save(s);
        });
    }

    public boolean deleteByRoll(String roll) {
        return repo.findByRollNumber(roll).map(s -> {
            repo.delete(s);
            return true;
        }).orElse(false);
    }
}
