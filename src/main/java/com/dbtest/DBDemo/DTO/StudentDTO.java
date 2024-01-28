package com.dbtest.DBDemo.DTO;

import com.dbtest.DBDemo.entities.Student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
//	Controller ကနေ လာတဲ့ Data တွေကို DB ထဲတိုက်ရိုက်ပေးမလုပ်ပဲ ဒီထဲမှာ Security ကောင်းအောင် တစ်ဆင့်ကြားခံထားခြင်း
public class StudentDTO {

	private int s_id;
	private String name;
	private String email;
	private int myan;
	private int eng;
	private int maths;
	private int total;
	
	public Student convertToEntity(StudentDTO dto) {
//		controller ထဲကဝင်လာတဲ့ Data တွေကို Database ထဲတန်းမဝင်ပဲ StudentDTO ကနေတစ်ဆင့် Student ထဲကို တန်ဖိုးတွေလှမ်းထည့်တယ်
		Student entity = new Student();
		entity.setS_id(dto.s_id);
		entity.setEmail(dto.email);
		entity.setName(dto.name);
		entity.setMyan(dto.myan);
		entity.setEng(dto.eng);
		entity.setMaths(dto.maths);
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
		return dto;
	}
	
	public int getTotal() {
		this.total = myan + eng + maths;
		return total;
	}

}
