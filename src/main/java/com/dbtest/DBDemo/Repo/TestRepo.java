package com.dbtest.DBDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbtest.DBDemo.entities.Test;

public interface TestRepo extends JpaRepository<Test, Integer>{
	
}
