package com.dbtest.DBDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbtest.DBDemo.entities.Classroom;

public interface ClassroomRepo extends JpaRepository<Classroom, Integer>{

}
