package com.dbtest.DBDemo.service;

import java.util.List;

import com.dbtest.DBDemo.DTO.ClassroomDTO;

public interface ClassroomService {
	
	public List<ClassroomDTO> findAll();
	public ClassroomDTO insert(ClassroomDTO s);
	public ClassroomDTO retrieve(int id);
	public ClassroomDTO updateStd(ClassroomDTO std);
	public String deleteById(ClassroomDTO std);

}
