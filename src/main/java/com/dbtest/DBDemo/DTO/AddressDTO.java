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
	
	public Address convertToEntity() {
		return null;
	}
	
	public AddressDTO convertToObject() {
		return null;
	}
	
	

}
