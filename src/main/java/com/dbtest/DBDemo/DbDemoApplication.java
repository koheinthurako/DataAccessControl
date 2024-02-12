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
import com.dbtest.DBDemo.DTO.StudentDTO;
import com.dbtest.DBDemo.entities.Address;
import com.dbtest.DBDemo.entities.Classroom;
import com.dbtest.DBDemo.entities.Student;
import com.dbtest.DBDemo.service.AddressService;
import com.dbtest.DBDemo.service.ClassroomService;
import com.dbtest.DBDemo.service.StudentService;

//	Flow အကျဉ်းချုပ်ကို အောက်ဆုံးမှာကြည့်ပါ

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
	
//	@Autowired
//	ClassroomService classService;
	
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
		
//		StudentDTO std = new StudentDTO();
//		std.setEmail("koko@gmail.com");
//		std.setName("ko ko");
//		std.setEng(60);
//		std.setMaths(70);
//		std.setMyan(60);
//		StudentDTO new_std = studentService.insert(std);
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
	
//	ဒီ project က DB ထဲက data တွေကို controller ကနေ လုပ်ချင်သလိုလုပ်နိုင်အောင် ရေးထားတဲ့ project(လူပိန်းမှတ်နည်း)
//	Controller layer, Service Layer and Data Access Layer တွေပါဝင်တယ်
//	project flow ကတော့ controller ကနေ ခိုင်းလိုက်တဲ့အရာကို service ပေးရမယ် service ပေးမယ်ဆိုရင် တစ်ခါတည်း 
//	service implementation နဲ့ controller တိုက်ရိုက် သွားချိတ်ရင်အဆင်မပြေဘူး code ကို manage လုပ်ဖို့ခက်မယ် ဒါကြောင့်
//	Inheritance နည်းလမ်းအရ interface တစ်ခုခံပြီး Implementation နဲ့ချိတ်စေတယ် ဒါဆိုရင် ImPl အမျိုးမျိုးကို interface ကနေ
//	PolyMorphism နည်းလမ်းနဲ့ တစ်စုတစ်စည်းထဲ ထိန်းချုပ်နိုင်သွားမယ် ဒါဆိုရင်တော့ controller ကနေ ခိုင်းတဲ့ဟာတွေကို service interface
//	ကနေတစ်ဆင့် serviceImpl ထဲမှာ အမှန်တကယ် အလုပ်လုပ်နိုင်စေတယ် ပြီးရင်တော့ တကယ် အလုပ်လုပ်မယ်ဆိုရင် database ထဲက data တွေ
//	ပါဝင်လာရတော့မှာမို့ data access layer လိုလာပြီ အဲ့တာကတော့ Database ထဲကို ဆင်းပြီးအလုပ်လုပ်ပေးနိုင်တဲ့ JPA spring library
//	HiberNate ဖြစ်တယ် ဒါကြောင့် JPARepositroy က interface မို့ သူ့ကို extends လုပ်နိုင်မယ့် interface တစ်ခုလိုတယ်
//	HiberNate က java ထဲမှာရေးထားတာမို့ DB နဲ့လှမ်းချိတ်တဲ့အခါ java entity class တစ်ခုလည်းလိုတယ် အဲ့ class ကိုတော့ @Entity
//	@Annonation နဲ့ class level မှာထည့်ပေးရတယ် @Entity ဆိုတဲ့ @Annonation ကတော့
//	spring မှာ DB ရဲ့ table တစ်ခုအနေနဲ့သိစေပြီး အလုပ်လုပ်နိုင်တာမို့ HiberNate က java class(DB Table) တစ်ခုနဲ့
//	Actual MySQL DB ကို ကြားမှာချိတ်ဆက်ပြီးအလုပ်လုပ်ပေးနိုင်စေတယ် ဒါကတော့ Data Access Layer ရဲ့ တာဝန်ဖြစ်တယ် သို့သော်
//	သတိထားရမှာက security အရ Controller ခိုင်းလိုက်တဲ့ အလုပ်တွေမှာ parameter passing ကနေ ဝင်လာတဲ့ data တွေက
//	တကယ့် java မှာရေးထားတဲ့ entity class နဲ့ တိုက်ရိုက်သွားချိတ်ပြီး အလုပ်လုပ်နေတာက အဆင်မပြေဘူး ဘာလို့ဆို အဲ့ဒီ class ကို
//	HiberNate က DB Table တစ်ခုအနေနဲ့ သိနေတာမို့ တကယ့် DB ထဲက data တန်ဖိုးတွေဖြစ်နေတယ် ဒါကြောင့် security မကောင်းတာမို့
//	Controller ကနေလာတဲ့ data တွေကို လုံခြုံစွာသီးခြားလက်ခံနိုင်တဲ့ class တစ်ခုကို ကြားကခံပြီးတော့မှ တကယ့် java entity class နဲ့
//	ကြားကခံထားတဲ့ class နဲ့ ချိတ်ဆက်ပြီးမှ အလုပ်လုပ်စေတာက ပိုကောင်းတယ် အဲ့လိုကြားက security ကောင်းအောင်ခံတဲ့ layer ကို
//	Data Transfer Object Layer(DTO) လို့ခေါ်တယ် ဆိုလိုချင်တာက : 
//	Controller->DTO->Entity / Entity->DTO->Controller
//	ကြားထဲမှာ အလုပ်လုပ်ပေးတဲ့ method တွေကတော့ ခုနက service layer တွေက အမြဲအလုပ်လုပ်ပေးနေမယ် ဒါပဲ!
	
	

}
