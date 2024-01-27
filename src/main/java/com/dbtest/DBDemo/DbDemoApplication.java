package com.dbtest.DBDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dbtest.DBDemo.entities.Student;
import com.dbtest.DBDemo.service.StudentService;

@SpringBootApplication
public class DbDemoApplication implements CommandLineRunner{
	
	@Autowired
	StudentService studentService;
	
	public static void main(String[] args) {
		SpringApplication.run(DbDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Student std = new Student();
//		std.setEmail("koko@gmail.com");
//		std.setName("ko ko");
//		std.setEng(60);
//		std.setMaths(70);
//		std.setMyan(60);
//		Student new_std = studentService.insert(std);
//		
//		System.out.println(new_std);
	}

}
