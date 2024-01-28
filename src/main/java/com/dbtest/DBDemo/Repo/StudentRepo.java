package com.dbtest.DBDemo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.dbtest.DBDemo.entities.Student;

//	JpaRepository<database table name, table primary key ရဲ့ data type> => Spring နဲ့ DB ကို ချိတ်ပေးတဲ့ HIBERNATE
@Repository
@EnableJpaRepositories
public interface StudentRepo extends JpaRepository<Student, Integer> {
//	Customize method working together with repository HIBERNATE 
	public Student findByName(String name);
	
	@Query(value = "select * from student where english>? and myanmar>? and mathematics>?;", nativeQuery = true)
	public List<Student> getDistinction(int mark, int mark1, int mark2);
	
	
	
}
