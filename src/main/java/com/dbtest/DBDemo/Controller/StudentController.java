package com.dbtest.DBDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbtest.DBDemo.entities.Student;
import com.dbtest.DBDemo.service.StudentService;

@RestController
@RequestMapping("/std")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Student> getStd(@PathVariable int id) {
		Student get_std = studentService.retrieve(id);
		return (get_std==null) ?
				new ResponseEntity<Student>(HttpStatus.BAD_REQUEST) :
				new ResponseEntity<Student>(get_std, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Student> saveStd(@RequestBody Student std) {
		Student new_std = studentService.insert(std);
		return new ResponseEntity<Student>(new_std, HttpStatus.OK);
	}
	
}
