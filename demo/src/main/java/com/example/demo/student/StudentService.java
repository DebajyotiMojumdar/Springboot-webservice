package com.example.demo.student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
	
	public List<Student> getStudent();
	public Student registerStudent(Student student);
	public Optional<Student> findStudent(int id);
	public String daleteStudent(int id);
	public Student saveOrUpdateStudent(Student student);

}
