package com.dbtest.DBDemo.DTO;

import com.dbtest.DBDemo.entities.Address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddressDTO {
	
	private int a_id;
	private String a_name;
	private int a_zipcode;
	
	public Address convertToEntity(AddressDTO dto) {
		Address entity = new Address();
		entity.setA_id(dto.getA_id());
		entity.setA_name(dto.getA_name());
		entity.setA_zipcode(dto.getA_zipcode());
		return entity;
	}
	
	public AddressDTO convertToObject(Address address) {
		AddressDTO dto = new AddressDTO();
		dto.setA_id(address.getA_id());
		dto.setA_name(address.getA_name());
		dto.setA_zipcode(address.getA_zipcode());
		return dto;
	}
	
	

}
