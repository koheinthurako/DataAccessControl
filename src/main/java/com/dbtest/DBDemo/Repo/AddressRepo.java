package com.dbtest.DBDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.dbtest.DBDemo.entities.Address;

@Repository
@EnableJpaRepositories
public interface AddressRepo extends JpaRepository<Address, Integer>{

}
