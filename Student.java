package com.example.student_management.model;
import jakarta.persistence.*;
@Entity
@Table(name = "students")
public class Student {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String name;

	    @Column(unique = true, nullable = false)
	    private String rollNumber;

	    private String department;

	    public Student() {}

	    public Student(String name, String rollNumber, String department) {
	        this.name = name;
	        this.rollNumber = rollNumber;
	        this.department = department;
	    }

	    // Getters and setters
	    public Long getId() { return id; }
	    public String getName() { return name; }
	    public String getRollNumber() { return rollNumber; }
	    public String getDepartment() { return department; }

	    public void setId(Long id) { this.id = id; }
	    public void setName(String name) { this.name = name; }
	    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }
	    public void setDepartment(String department) { this.department = department; }

}
