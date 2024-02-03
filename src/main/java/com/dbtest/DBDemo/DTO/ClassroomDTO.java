package com.dbtest.DBDemo.DTO;

import com.dbtest.DBDemo.entities.Classroom;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ClassroomDTO {
	
	private int c_id;
	private String c_name;
	
	public Classroom convertToEntity(ClassroomDTO class_dto) {
		Classroom entity = new Classroom();
		entity.setC_id(class_dto.getC_id());
		entity.setC_name(class_dto.getC_name());
		return entity;
	}
	
	public ClassroomDTO convertToObject(Classroom classroom) {
		ClassroomDTO dto = new ClassroomDTO();
		dto.setC_id(classroom.getC_id());
		dto.setC_name(classroom.getC_name());
		return dto;
	}

}
