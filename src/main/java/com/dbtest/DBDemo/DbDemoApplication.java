package com.dbtest.DBDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dbtest.DBDemo.entities.Student;
import com.dbtest.DBDemo.service.StudentService;

@SpringBootApplication
public class DbDemoApplication implements CommandLineRunner{
	
//	Spring နဲ့ DB ချိတ်မယ်ဆိုအရင်လို Customize လိုက်ရေးနေစရာမလိုပဲ Spring family ထဲက JPA library ရဲ့ HiBernate တွေကိုသုံးတယ်
//	JPA => Java Persistence API
//	A JPA (Java Persistence API) is a specification of Java which is used to access,
//	manage, and persist data between Java object and relational database
//	It is easier to build Spring-powered applications that use data access technologies
	
//	program အစမှာ Database နဲ့မချိတ်ပေးရင် error တက်မှာမို့ DB နဲ့အရင်ချိတ်ပေးရမယ်
//	ချိတ်မယ်ဆိုရင် application.properties ထဲမှာ ရေးရမယ်
	
	@Autowired
	StudentService studentService;
	
	public static void main(String[] args) {
		SpringApplication.run(DbDemoApplication.class, args);
	}

//	CommandLineRunner interface ထဲက override run() method ကတော့ Main program run တာနဲ့ auto စ run ပေးတဲ့ method
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
