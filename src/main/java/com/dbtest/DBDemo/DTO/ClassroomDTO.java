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
	
	public Classroom convertToEntity() {
		return null;
	}
	
	public ClassroomDTO convertToObject() {
		return null;
	}

}
