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

import com.dbtest.DBDemo.DTO.AddressDTO;
import com.dbtest.DBDemo.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@GetMapping("")
	public ResponseEntity<List<AddressDTO>> getAll() {
		return new ResponseEntity<List<AddressDTO>>(addressService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<AddressDTO> getStd(@PathVariable int id) {
		AddressDTO get_std = addressService.retrieve(id);
		return (get_std==null) ?
				new ResponseEntity<AddressDTO>(HttpStatus.BAD_REQUEST) :
				new ResponseEntity<AddressDTO>(get_std, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<AddressDTO> saveStd(@RequestBody AddressDTO std) {
		AddressDTO new_std = addressService.insert(std);
		return new ResponseEntity<AddressDTO>(new_std, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<AddressDTO> updateStd(@RequestBody AddressDTO std) {
		AddressDTO update_std = addressService.updateStd(std);
		return (update_std==null) ?
				new ResponseEntity<AddressDTO>(HttpStatus.BAD_REQUEST) :
				new ResponseEntity<AddressDTO>(update_std, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public String deleteById(@RequestBody AddressDTO std) {
		return addressService.deleteById(std);
	}

}
