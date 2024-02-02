package com.dbtest.DBDemo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.dbtest.DBDemo.DTO.StudentDTO;
import com.dbtest.DBDemo.Repo.StudentRepo;
import com.dbtest.DBDemo.entities.Student;
import com.dbtest.DBDemo.service.StudentService;

@Configuration
public class StudentServiceImpl implements StudentService{
	
//	ဒီ class ကို @Configuration နဲ့ object ဆောက်ခိုင်းထားတယ် အဲ့တော့ သူ့ရဲ့ Parent class တစ်ခုခုကို @Autowired ချိတ်လိုက်တာနဲ့
//	ဒီ class က object ဖြစ်သွားပြီး အောက်က @Autowired ချိတ်ထားတဲ့ StudentRepo ကို အလုပ်လုပ်နိုင်တယ်
//	@Autowired တွေကိုချိတ်လိုက်ပြီဆိုတာနဲ့ သူက Annotation တွေကနေတစ်ဆင့် ခိုင်းထားတဲ့အလုပ်တွေကို လုပ်ပေးသွားတယ်
//	ဒီမှာဆိုရင် ‌DbDemoApplication.java ထဲက studentService ကနေတစ်ဆင့် ဒီထဲကိုရောက်လာတယ် ရောက်လာတော့
//	အပေါ်က @Configuration ဆိုတဲ့အတိုင်း object ဆောက်သွားတယ် ပြီးရင် အောက်က studentRepo ရဲ့
//	@Autowired ကိုသွားတွေ့တယ် ဒါနဲ့ StudentRepo ထဲကိုထပ်ဆင်းသွားပြီးတော့ @Repository နဲ့ @EnableJpaRepositories annotation
//	တွေကနေ extends လုပ်ထားတဲ့ JpaRepository<Student> က အလုပ်လုပ်သွားတယ် ပြီးတော့ ထဲမှာရှိတဲ့ Student class ကို ဝင်သွားပြီး အဲ့ထဲမှာ ရှိတဲ့
//	@Entity ဆိုတဲ့ annotation အရ Student က table တစ်ခုအဖြစ်ယူဆလိုက်ပြီး JpaRepository ထဲက HiBernate ကနေတစ်ဆင့်
//	SQL Statement တွေ run သွားပြီး main program စ run တာနဲ့ Database ထဲကို auto table တွေဆောက်ပေးသွားနိုင်တာဖြစ်တယ်
//	အဓိကကတော့ spring ရဲ့အရေးကြီးတဲ့ concept ဖြစ်တဲ့ @Autowired ဆိုတဲ့ Dependency Injection တွေကနေပဲ auto အလုပ်လုပ်ပေးသွားနိုင်ခြင်းဖြစ်တယ်
//	ပြီးမှ အောက်က data manage လုပ်တဲ့ concept တွေထပ်လာတယ်
	
	@Autowired
	StudentRepo studentRepo;

	StudentDTO dto = new StudentDTO();
	
	@Override
	public StudentDTO insert(StudentDTO std_dto) {
		Student s = dto.convertToEntity(std_dto);
		Student new_std = studentRepo.save(s);
		StudentDTO new_std_dto = dto.convertToObject(new_std);
		new_std_dto.getTotal();
		return new_std_dto;
	}

	@Override
	public Student retrieve(int id) {
		Student getStd = studentRepo.findById(id).orElse(null);
		return getStd;
	}

	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public Student findByName(String name) {
		return studentRepo.findByName(name);
	}
	
	@Override
	public Student updateStd(Student std) {
		Student old_std = studentRepo.findById(std.getS_id()).orElse(null);
		if(old_std!=null) {
			old_std.setEmail(std.getEmail());
			old_std.setName(std.getName());
			old_std.setMyan(std.getMyan());
			old_std.setEng(std.getEng());
			old_std.setMaths(std.getMaths());
			return studentRepo.save(old_std);
		}
		return old_std;
	}

	@Override
	public String deleteById(Student std) {
		Student old_std = studentRepo.findById(std.getS_id()).orElse(null);
		if(old_std!=null) {
			studentRepo.deleteById(std.getS_id());
			return "Deleted!";
		}
		return null;
	}

	@Override
	public List<Student> getDistinction(int mark) {
		return studentRepo.getDistinction(mark, mark, mark);
	}

	

}
