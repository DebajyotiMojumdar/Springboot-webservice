package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	public StudentRepo repo;
	
	//fetch all students
	public List<Student> getStudent() {
		return repo.findAll();
	}

	//save a new student
	public Student registerStudent(Student student) {
		
		Optional<Student> optionalStudent = repo.findStudentByEmail(student.getEmail());
		if(optionalStudent.isPresent()) {
			throw new IllegalStateException("email taken");
		} else {
			return repo.save(student);
		}
	}

	//to find a student
	public Optional<Student> findStudent(int id) {
		// TODO Auto-generated method stub
		Optional<Student> student = repo.findById(id);
		if(student.isPresent()) {
			return student;
		} else {
			throw new IllegalStateException("Invalid Student Id");
		}
	}

	//delete info of a student
	public String daleteStudent(int id) {
		// TODO Auto-generated method stub
		Student s = repo.getOne(id);
		repo.delete(s);
		return "deleted";
	}

	//save or update a student
	public Student saveOrUpdateStudent(Student student) {
		// TODO Auto-generated method stub
		return repo.save(student);
	}
	
}
