package com.dbtest.DBDemo.service;

import org.springframework.stereotype.Service;

import com.dbtest.DBDemo.entities.Student;

@Service
public interface StudentService {
	// standard ဖြစ်ချင်ရင် insert နေရာမှာ save နဲ့ရေးကြတယ်
	public Student insert(Student s);
	public Student retrieve(int id);
}
