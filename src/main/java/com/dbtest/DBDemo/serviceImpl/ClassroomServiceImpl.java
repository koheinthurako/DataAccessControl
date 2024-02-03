package com.dbtest.DBDemo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.dbtest.DBDemo.DTO.ClassroomDTO;
import com.dbtest.DBDemo.Repo.ClassroomRepo;
import com.dbtest.DBDemo.entities.Classroom;
import com.dbtest.DBDemo.service.ClassroomService;

@Configuration
public class ClassroomServiceImpl implements ClassroomService{
	
	@Autowired
	ClassroomRepo classRepo;
	
	ClassroomDTO dto = new ClassroomDTO();

	@Override
	public List<ClassroomDTO> findAll() {
		List<Classroom> classroom = classRepo.findAll();
		List<ClassroomDTO> class_dto = new ArrayList<ClassroomDTO>();
		for(Classroom c : classroom) {
			class_dto.add(dto.convertToObject(c));
		}
		return class_dto;
	}

	@Override
	public ClassroomDTO insert(ClassroomDTO s) {
		Classroom classroom = dto.convertToEntity(s);
		Classroom new_class = classRepo.save(classroom);
		ClassroomDTO class_dto = dto.convertToObject(new_class);
		return class_dto;
	}

	@Override
	public ClassroomDTO retrieve(int id) {
		Classroom classroom = classRepo.findById(id).orElse(null);
		ClassroomDTO class_dto = dto.convertToObject(classroom);
		return class_dto;
	}

	@Override
	public ClassroomDTO updateStd(ClassroomDTO std) {
		Classroom classroom = dto.convertToEntity(std);
		Classroom new_class = classRepo.findById(classroom.getC_id()).orElse(null);
		if(new_class!=null) {
			new_class.setC_id(classroom.getC_id());
			new_class.setC_name(classroom.getC_name());
			new_class = classRepo.save(classroom);
			ClassroomDTO class_dto = dto.convertToObject(new_class);
			return class_dto;
		}
		return null;
	}

	@Override
	public String deleteById(ClassroomDTO std) {
		Classroom classroom = dto.convertToEntity(std);
		Classroom new_class = classRepo.findById(std.getC_id()).orElse(null);
		if(new_class!=null) {
			classRepo.deleteById(classroom.getC_id());
			return "Deleted!";
		} else {
			return "There is no match data in database!";
		}
	}

	
	
}
