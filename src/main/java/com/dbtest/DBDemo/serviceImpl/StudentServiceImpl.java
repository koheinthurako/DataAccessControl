package com.dbtest.DBDemo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.dbtest.DBDemo.DTO.StudentDTO;
import com.dbtest.DBDemo.Repo.StudentRepo;
import com.dbtest.DBDemo.entities.Student;
import com.dbtest.DBDemo.service.StudentService;

@Configuration
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepo studentRepo;

	StudentDTO dto = new StudentDTO();
	
	@Override
	public StudentDTO insert(StudentDTO std_dto) {
		Student s = dto.convertToEntity(std_dto);
		Student new_std = studentRepo.save(s);
		StudentDTO new_std_dto = dto.convertToObject(new_std);
		new_std_dto.getTotal();
		return new_std_dto;
	}

	@Override
	public Student retrieve(int id) {
		Student getStd = studentRepo.findById(id).orElse(null);
		return getStd;
	}

	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public Student findByName(String name) {
		return studentRepo.findByName(name);
	}
	
	@Override
	public Student updateStd(Student std) {
		Student old_std = studentRepo.findById(std.getS_id()).orElse(null);
		if(old_std!=null) {
			old_std.setEmail(std.getEmail());
			old_std.setName(std.getName());
			old_std.setMyan(std.getMyan());
			old_std.setEng(std.getEng());
			old_std.setMaths(std.getMaths());
			return studentRepo.save(old_std);
		}
		return old_std;
	}

	@Override
	public String deleteById(Student std) {
		Student old_std = studentRepo.findById(std.getS_id()).orElse(null);
		if(old_std!=null) {
			studentRepo.deleteById(std.getS_id());
			return "Deleted!";
		}
		return null;
	}

	@Override
	public List<Student> getDistinction(int mark) {
		return studentRepo.getDistinction(mark, mark, mark);
	}

	

}
