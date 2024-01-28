package com.dbtest.DBDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dbtest.DBDemo.DTO.StudentDTO;
import com.dbtest.DBDemo.entities.Student;

@Service
public interface StudentService {
	// standard ဖြစ်ချင်ရင် insert နေရာမှာ save နဲ့ရေးကြတယ်
	public StudentDTO insert(StudentDTO s);
	public Student retrieve(int id);
	public List<Student> findAll();
	public Student findByName(String name);
	public Student updateStd(Student std);
	public String deleteById(Student std);
	public List<Student> getDistinction(int mark);
}
