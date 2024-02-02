package com.dbtest.DBDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dbtest.DBDemo.DTO.StudentDTO;
import com.dbtest.DBDemo.entities.Student;

@Service
//	@Service လို့ထည့်တာက Dependency Injection ရချင်လို့ဖြစ်တယ်
public interface StudentService {
	public List<StudentDTO> findAll();
	// standard ဖြစ်ချင်ရင် insert နေရာမှာ save နဲ့ရေးကြတယ်
	public StudentDTO insert(StudentDTO s);
	public StudentDTO retrieve(int id);
	public StudentDTO findByName(String name);
	public StudentDTO updateStd(StudentDTO std);
	public String deleteById(Student std);
	public List<Student> getDistinction(int mark);
}
