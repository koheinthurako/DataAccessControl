package com.dbtest.DBDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbtest.DBDemo.entities.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
