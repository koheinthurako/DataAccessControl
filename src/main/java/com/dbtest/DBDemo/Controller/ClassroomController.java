package com.dbtest.DBDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbtest.DBDemo.DTO.ClassroomDTO;
import com.dbtest.DBDemo.service.ClassroomService;

@RestController
@RequestMapping("class")
public class ClassroomController {
	
	@Autowired
	ClassroomService classService;
	
	@GetMapping("")
	public ResponseEntity<List<ClassroomDTO>> getAll() {
		return new ResponseEntity<List<ClassroomDTO>>(classService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ClassroomDTO> getAddress(@PathVariable int id) {
		ClassroomDTO get_classroom = classService.retrieve(id);
		return (get_classroom==null) ?
				new ResponseEntity<ClassroomDTO>(HttpStatus.BAD_REQUEST) :
				new ResponseEntity<ClassroomDTO>(get_classroom, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<ClassroomDTO> saveAddress(@RequestBody ClassroomDTO classroom) {
		ClassroomDTO new_class = classService.insert(classroom);
		return new ResponseEntity<ClassroomDTO>(new_class, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ClassroomDTO> updateAddress(@RequestBody ClassroomDTO classroom) {
		ClassroomDTO update_class = classService.updateStd(classroom);
		return (update_class==null) ?
				new ResponseEntity<ClassroomDTO>(HttpStatus.BAD_REQUEST) :
				new ResponseEntity<ClassroomDTO>(update_class, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public String deleteById(@RequestBody ClassroomDTO classroom) {
		return classService.deleteById(classroom);
	}

}
