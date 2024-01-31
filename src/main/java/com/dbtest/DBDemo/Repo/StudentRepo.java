package com.dbtest.DBDemo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.dbtest.DBDemo.entities.Student;

@Repository
//	@Repository နဲ့ အောက်က @EnableJpaRepositories လို့ရေးလိုက်တာက Dependency Injection ရချင်လို့ဖြစ်တယ်	
@EnableJpaRepositories
public interface StudentRepo extends JpaRepository<Student, Integer> {
//	JpaRepository<database table name, table primary key ရဲ့ data type> => Spring နဲ့ DB ကို ချိတ်ပေးတဲ့ HIBERNATE
//	HiBernate is an implementation of JPA that provides a high-level API for interacting with databases
//	JpaRepository က Spring framework ကို HiBernate နဲ့လှမ်းချိတ်ပေးပြီး SQL တွေကို သူ့ထဲမှာပဲ run ပေးနိုင်တယ်
//	အဲ့တော့ Student table တစ်ခုကိုဆောက်ပေးနိုင်ဖို့ ဒီ object ကို ဆောက်ဖို့လိုတယ် ဒါပေမယ့် interface ဆိုတော့ ဆောက်မရဘူး
//	ဒါကြောင့် dependency injection နဲ့ auto အလုပ်လုပ်ပေးနိုင်အောင် @Autowired နဲ့ခေါ်ပေးရမယ် သူ့ကို StudentServiceImpl ထဲသွားကြည့်
	
	
//	Customize method working together with repository HIBERNATE 
	public Student findByName(String name);
	
	@Query(value = "select * from student where english>? and myanmar>? and mathematics>?;", nativeQuery = true)
	public List<Student> getDistinction(int mark, int mark1, int mark2);
	
	
	
}
