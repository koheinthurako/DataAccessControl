package com.dbtest.DBDemo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.dbtest.DBDemo.DTO.AddressDTO;
import com.dbtest.DBDemo.Repo.AddressRepo;
import com.dbtest.DBDemo.entities.Address;
import com.dbtest.DBDemo.service.AddressService;


@Configuration
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	AddressRepo addressRepo;
	
	AddressDTO dto = new AddressDTO();
	
	@Override
	public List<AddressDTO> findAll() {
		List<Address> new_add = addressRepo.findAll();
		List<AddressDTO> dtoList = new ArrayList<	AddressDTO>();
		dtoList.clear();
		for(Address address : new_add) {
			dtoList.add(dto.convertToObject(address));
		}
		return dtoList;
	}

	@Override
	public AddressDTO insert(AddressDTO add_dto) {
		Address address = dto.convertToEntity(add_dto);
//		Implement in Database
		Address new_address = addressRepo.save(address);
//		Entity to Controller
		AddressDTO new_add_dto = dto.convertToObject(new_address);
		return new_add_dto;
	}

	@Override
	public AddressDTO retrieve(int id) {
		Address getAdd = addressRepo.findById(id).orElse(null);
		AddressDTO getAddDto = dto.convertToObject(getAdd);
		return getAddDto;
	}

	@Override
	public AddressDTO updateStd(AddressDTO address) {
		Address old_add = dto.convertToEntity(address);
		Address new_add = addressRepo.findById(old_add.getA_id()).orElse(null);
		if(new_add!=null) {
			new_add.setA_id(old_add.getA_id());
			new_add.setA_name(old_add.getA_name());
			new_add.setA_zipcode(old_add.getA_zipcode());
			new_add = addressRepo.save(old_add);
			AddressDTO old_add_dto = dto.convertToObject(new_add);
			return old_add_dto;
		}
		return null;
	}

	@Override
	public String deleteById(AddressDTO address) {
		Address old_add = dto.convertToEntity(address);
		Address new_add = addressRepo.findById(old_add.getA_id()).orElse(null);
		if(new_add!=null) {
			addressRepo.deleteById(old_add.getA_id());
			return "Deleted!";
		}
		return null;
	}

	
}
