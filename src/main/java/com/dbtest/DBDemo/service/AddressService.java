package com.dbtest.DBDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dbtest.DBDemo.DTO.AddressDTO;

@Service
public interface AddressService {
	
	public List<AddressDTO> findAll();
	// standard ဖြစ်ချင်ရင် insert နေရာမှာ save နဲ့ရေးကြတယ်
	public AddressDTO insert(AddressDTO s);
	public AddressDTO retrieve(int id);
	public AddressDTO updateStd(AddressDTO std);
	public String deleteById(AddressDTO std);

}
