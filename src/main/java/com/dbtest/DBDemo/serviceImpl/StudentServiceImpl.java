package com.dbtest.DBDemo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.dbtest.DBDemo.Repo.StudentRepo;
import com.dbtest.DBDemo.entities.Student;
import com.dbtest.DBDemo.service.StudentService;

@Configuration
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepo studentRepo;

	@Override
	public Student insert(Student s) {
		return studentRepo.save(s);
	}

	@Override
	public Student retrieve(int id) {
		Student getStd = studentRepo.findById(id).orElse(null);
		return getStd;
	}

}
