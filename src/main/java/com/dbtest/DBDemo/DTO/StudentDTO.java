package com.dbtest.DBDemo.DTO;

import java.util.List;

import com.dbtest.DBDemo.entities.Address;
import com.dbtest.DBDemo.entities.Classroom;
import com.dbtest.DBDemo.entities.Student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
//	Controller ကနေ လာတဲ့ Data တွေကို DB ထဲတိုက်ရိုက်ပေးမလုပ်ပဲ ဒီထဲမှာ Security ကောင်းအောင် တစ်ဆင့်ကြားခံထားခြင်း
//	Controller ထဲကဝင်လာတဲ့ Data တွေကို Database ထဲတန်းမဝင်ပဲ StudentDTO ကနေတစ်ဆင့် Student ထဲကို တန်ဖိုးတွေလှမ်းထည့်တယ်
//	ပြီးရင် DB table ထဲက သက်ဆိုင်တဲ့ student ဆို student တန်ဖိုးတွေကိုယူပြီး ဒီထဲမှာပဲ value တွေပြန်ထည့်ပြီး Calculation တွေလုပ်နိုင်တယ်
public class StudentDTO {

	private int s_id;
	private String name;
	private String email;
	private int myan;
	private int eng;
	private int maths;
	private int total;
	private Address address;
	private List<Classroom> classrooms;
	
//	@RequestBody(Controller) ကနေ ဝင်လာတဲ့ တန်ဖိုးတွေကို class ထဲက တန်ဖိုးတွေဆီ လှမ်းထည့်တာ
	public Student convertToEntity(StudentDTO dto) {
		Student entity = new Student();
		entity.setS_id(dto.s_id);
		entity.setEmail(dto.email);
		entity.setName(dto.name);
		entity.setMyan(dto.myan);
		entity.setEng(dto.eng);
		entity.setMaths(dto.maths);
		entity.setAddress(dto.getAddress());
		entity.setClassrooms(dto.getClassrooms());
		return entity;
	}
	
	public StudentDTO convertToObject(Student std) {
		StudentDTO dto = new StudentDTO();
		dto.setS_id(std.getS_id());
		dto.setEmail(std.getEmail());
		dto.setName(std.getName());
		dto.setMyan(std.getMyan());
		dto.setEng(std.getEng());
		dto.setMaths(std.getMaths());
		dto.setAddress(std.getAddress());
		dto.setClassrooms(std.getClassrooms());
		return dto;
	}
	
	public int getTotal() {
		this.total = myan + eng + maths;
		return total;
	}

}
