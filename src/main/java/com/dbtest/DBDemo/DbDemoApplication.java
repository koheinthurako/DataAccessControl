package com.dbtest.DBDemo;

/*
 	Dependencies
 	1. Spring Web => Build web, including RESTful, applications using Spring MVC
 	(Spring MVC => is a library within the Spring framework that simplifies handling HTTP requests and responses
 	2. Spring Boot DevTools => liveReload
 	3. LomBok => Java annotation library which helps to reduce boilerplate code.
 	4. MySQL Driver => MySQL JDBC Driver
 	5. Spring Data JPA => Java Persistence API using Spring Data and HiBernate
 	
 	Overview start flow => Main - Entity - REPO - Service - ServiceImpl - Controller - DTO 
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dbtest.DBDemo.DTO.AddressDTO;
import com.dbtest.DBDemo.DTO.ClassroomDTO;
import com.dbtest.DBDemo.entities.Address;
import com.dbtest.DBDemo.entities.Classroom;
import com.dbtest.DBDemo.service.AddressService;
import com.dbtest.DBDemo.service.ClassroomService;
import com.dbtest.DBDemo.service.StudentService;

@SpringBootApplication
public class DbDemoApplication implements CommandLineRunner{
	
//	Spring နဲ့ DB ချိတ်မယ်ဆိုအရင်လို Customize လိုက်ရေးနေစရာမလိုပဲ Spring family data ထဲက JPA library ရဲ့ HiBernate တွေကိုသုံးတယ်
//	JPA => Java Persistence API
//	A JPA (Java Persistence API) is a specification of Java which is used to access,
//	manage, and persist data between Java object and relational database
//	It is easier to build Spring-powered applications that use data access technologies
	
//	program အစမှာ Database နဲ့မချိတ်ပေးရင် error တက်မှာမို့ DB နဲ့အရင်ချိတ်ပေးရမယ်
//	ချိတ်မယ်ဆိုရင် application.properties ထဲမှာ ရေးရမယ်
	
//	@Autowired
//	StudentService studentService;
	
//	@Autowired
//	AddressService addressService;
	
	@Autowired
	ClassroomService classService;
	
	public static void main(String[] args) {
		SpringApplication.run(DbDemoApplication.class, args);
	}

//	CommandLineRunner interface ထဲက override run() method ကတော့ Main program run တာနဲ့ auto စ run ပေးတဲ့ method
	@Override
	public void run(String... args) throws Exception {
//		program စတာနဲ့ အပေါ်က @Autowired ကအရင်အလုပ်လုပ်တယ် ပြီးရင် ဒီ method run တယ်
//		အောက်မှာက Student class ကို object ဆောက်ထားပြီး class ထဲကို တန်ဖိုးတွေ ထည့်တယ် အပေါ်မှာ
//		@Autowired လို့ရေးလိုက်တော့ studentService ရဲ့ dependency တွေကိုလိုက်ရှာပြီး ခိုင်းထားတဲ့ annotation တွေအလိုက် inject စလုပ်တယ်
//		Student.java ထဲကိုသွားကြည့်
		
//		Student std = new Student();
//		std.setEmail("koko@gmail.com");
//		std.setName("ko ko");
//		std.setEng(60);
//		std.setMaths(70);
//		std.setMyan(60);
//		Student new_std = studentService.insert(std);
//		
//		System.out.println(new_std);
		
//		AddressDTO add = new AddressDTO();
//		add.setA_name("Yangon");
//		add.setA_zipcode(12345);
//		AddressDTO new_add = addressService.insert(add);
		
//		ClassroomDTO classroom = new ClassroomDTO();
//		classroom.setC_id(1);
//		classroom.setC_name("Class_A");
//		ClassroomDTO new_class = classService.insert(classroom);
		
	}

}
