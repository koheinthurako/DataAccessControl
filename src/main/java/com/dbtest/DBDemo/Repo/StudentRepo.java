package com.dbtest.DBDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbtest.DBDemo.entities.Student;

//	JpaRepository<database table name, table primary key ရဲ့ data type> => Spring နဲ့ DB ကို ချိတ်ပေးတဲ့ HIBERNATE
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	
}
