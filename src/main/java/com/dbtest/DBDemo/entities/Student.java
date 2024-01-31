package com.dbtest.DBDemo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
// lomBok library က boilerplate code (ထပ်တဲ့code) တွေကို ရှင်းပေးတယ်

@Entity
//	ဒီ class ကို စတာနဲ့ @Entity keyword ကိုစထည့်တယ် သူက JPA library ထဲက feature တစ်ခု
//	သူ့ကိုထည့်လိုက်တာနဲ့ Database ထဲမှာ ဒီ class ကို table အနေနဲ့သိသွားတယ်
//	table အနေနဲ့သိသွားပြီဆိုရင် main program ကို စ run တာနဲ့ Database Table တွေကို auto တန်းဆောက်ပေးသွားတယ်
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {
	
//	အပေါ်မှာ @Entity ကိုရေးပြီးရင် ဒီ class ကို table မှန်းသိသွားပြီမို့ အောက်က DB annotation အနေနဲ့ DDL တွေကို အလွယ်တကူလိုက်ရေးလို့ရပြီ

	@Id
//	@Id ဆိုတာ primary key အနေနဲ့ထားနိုင်တဲ့ name
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.AUTO) => Auto Increment
	private int s_id;

	@Column(length = 30, nullable = false)
	private String name;

	@Column(unique = true)
//	unique ဆိုရင်တော့ email တွေထပ်လို့မရဘူး
	private String email;

	@Column(name = "Myanmar")
//	java ထဲမှာတော့ အောက်က myan အနေနဲ့ အလုပ်လုပ်ပြီး DB ထဲမှာတော့ Myanmar ဖြစ်မယ်
	private int myan;

	@Column(name = "English")
	private int eng;

	@Column(name = "Mathematics")
	private int maths;

}
