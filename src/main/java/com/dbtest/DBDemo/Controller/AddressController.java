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
	public ResponseEntity<AddressDTO> getAddress(@PathVariable int id) {
		AddressDTO get_address = addressService.retrieve(id);
		return (get_address==null) ?
				new ResponseEntity<AddressDTO>(HttpStatus.BAD_REQUEST) :
				new ResponseEntity<AddressDTO>(get_address, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<AddressDTO> saveAddress(@RequestBody AddressDTO address) {
		AddressDTO new_address = addressService.insert(address);
		return new ResponseEntity<AddressDTO>(new_address, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<AddressDTO> updateAddress(@RequestBody AddressDTO address) {
		AddressDTO update_address = addressService.updateStd(address);
		return (update_address==null) ?
				new ResponseEntity<AddressDTO>(HttpStatus.BAD_REQUEST) :
				new ResponseEntity<AddressDTO>(update_address, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public String deleteById(@RequestBody AddressDTO address) {
		return addressService.deleteById(address);
	}

}
