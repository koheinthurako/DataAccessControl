package com.dbtest.DBDemo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.dbtest.DBDemo.DTO.StdAvg;
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
//	@Autowired ကိုသွားတွေ့တယ် ဒါနဲ့ StudentRepo ထဲကိုထပ်ဆင်းသွားပြီးတော့ အလုပ်လုပ်သွားတယ်
//	အဓိကကတော့ spring ရဲ့အရေးကြီးတဲ့ concept ဖြစ်တဲ့ @Autowired ဆိုတဲ့ Dependency Injection တွေကနေပဲ auto အလုပ်လုပ်ပေးသွားနိုင်ခြင်းဖြစ်တယ်
//	ပြီးမှ အောက်က data manage လုပ်တဲ့ concept တွေထပ်လာတယ်
	
	@Autowired
	StudentRepo studentRepo;

	StudentDTO dto = new StudentDTO();
	
	@Override
	public List<StudentDTO> findAll() {
		List<Student> new_std = studentRepo.findAll();
		List<StudentDTO> dtoList = new ArrayList<StudentDTO>();
		dtoList.clear();
		for(Student std : new_std) {
			dtoList.add(dto.convertToObject(std));
		}
		return dtoList;
	}
	
	@Override
	public StudentDTO insert(StudentDTO std_dto) {
//		Controller to Entity
		Student s = dto.convertToEntity(std_dto);
//		Implement in Database
		Student new_std = studentRepo.save(s);
//		Entity to Controller
		StudentDTO new_std_dto = dto.convertToObject(new_std);
		new_std_dto.getTotal();
		return new_std_dto;
	}

	@Override
	public StudentDTO retrieve(int id) {
		Student getStd = studentRepo.findById(id).orElse(null);
		StudentDTO getStdDto = dto.convertToObject(getStd);
		return getStdDto;
	}

	@Override
	public StudentDTO findByName(String name) {
		Student std = studentRepo.findByName(name);
		StudentDTO std_dto = dto.convertToObject(std);
		return std_dto;
	}
	
	@Override
	public StudentDTO updateStd(StudentDTO std) {
		Student old_std = dto.convertToEntity(std);
		Student new_std = studentRepo.findById(old_std.getS_id()).orElse(null);
		if(new_std!=null) {
			new_std.setEmail(old_std.getEmail());
			new_std.setName(old_std.getName());
			new_std.setMyan(old_std.getMyan());
			new_std.setEng(old_std.getEng());
			new_std.setMaths(old_std.getMaths());
			new_std = studentRepo.save(old_std);
			StudentDTO old_std_dto = dto.convertToObject(new_std);
			return old_std_dto;
		}
		return null;
	}

	@Override
	public String deleteById(StudentDTO std) {
		Student old_std = dto.convertToEntity(std);
		Student new_std = studentRepo.findById(old_std.getS_id()).orElse(null);
		if(new_std!=null) {
			studentRepo.deleteById(old_std.getS_id());
			return "Deleted!";
		}
		return null;
	}

	@Override
	public List<StudentDTO> getDistinction(int mark) {
		List<Student> stdList = studentRepo.getDistinction(mark, mark, mark);
//		List<Student> stdList = studentRepo.getPass(mark);
		List<StudentDTO> dtoList = new ArrayList<StudentDTO>();
		dtoList.clear();
		for(Student std : stdList) {
			dtoList.add(dto.convertToObject(std));
		}
		
		return dtoList;
	}

	@Override
	public StdAvg getAvg() {
		return studentRepo.getAvg();
	}

	

}
