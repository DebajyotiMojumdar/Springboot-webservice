package com.example.demo.student;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${app.name}")
	public String appName;
	
	@Autowired
	private StudentService studentService;
	
	//show all student
	@GetMapping("/all")
	@ResponseBody
	public ResponseEntity<List<Student>> getStudent() {
		List<Student> list = this.studentService.getStudent();
		if(list.size() <= 0) { 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		System.out.println(list);
		return ResponseEntity.of(Optional.of(list));
	}
	
	//to register a new student
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.registerStudent(student);
	}
	
	//fetch student using id
	@RequestMapping("/{id}")
	public Optional<Student> findStudent(@PathVariable("id") int  id) {
		return studentService.findStudent(id);
	}
	
	//delete student data 
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable("id") int  id) {
		return studentService.daleteStudent(id);
	}
	
	//save or update student 
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return this.studentService.saveOrUpdateStudent(student);
	}
	
	@RequestMapping("/test")
	public String test() {
//		ErrorMsg errorMsg = new ErrorMsg("test msg");
		logger.info("=========================this is my test logger run===================");
		return "test working";
	}

}
