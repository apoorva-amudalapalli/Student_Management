package com.example.student_management.controller;
import com.example.student_management.model.*;
import com.example.student_management.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return ResponseEntity.ok(service.addStudent(student));
    }

    // Get all
    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // Get by roll
    @GetMapping("/{roll}")
    public ResponseEntity<?> getByRoll(@PathVariable String roll) {
        return service.findByRoll(roll)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{roll}")
    public ResponseEntity<?> update(@PathVariable String roll, @RequestBody Student student) {
        return service.updateByRoll(roll, student)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("/{roll}")
    public ResponseEntity<?> delete(@PathVariable String roll) {
        return service.deleteByRoll(roll)
                ? ResponseEntity.ok("Deleted successfully")
                : ResponseEntity.notFound().build();
    }
}
