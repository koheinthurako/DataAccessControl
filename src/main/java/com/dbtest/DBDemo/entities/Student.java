package com.dbtest.DBDemo.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
// lomBok library က boilerplate code (ထပ်တဲ့code) တွေကို ရှင်းပေးတယ်

@Entity
//	ဒီ class ကို စတာနဲ့ @Entity keyword ကိုစထည့်တယ် သူက JPA library ထဲက feature တစ်ခု
//	သူ့ကိုထည့်လိုက်တာနဲ့ Database ထဲမှာ ဒီ class ကို table အနေနဲ့သိသွားတယ်
//	သို့သော် သတိထားရမှာက Table ဆောက်ပြီဆိုရင် ER Diagram ကိုအရင်ချထားပြီးမှ (one to one/ one to many/ many to many)
//	ဆိုတာကို အရင် frame ချထားမှရမယ် အဲ့တာကို အောက်ဆုံးမှာ သေချာကြည့်ပါ
//	table အနေနဲ့သိသွားပြီဆိုရင် database ထဲမှာ table ဆောက်နိုင်ဖို့ Spring နဲ့ HiBernate ကိုချိတ်ပေးမယ့် interface တစ်ခုလိုတယ်
//	အဲ့ဒီ interface က JPARepository ကို extends လှမ်းလုပ်ပေးရမယ် အဲ့တာကို Student.Repo ထဲမှာသွားကြည့်

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
	
//	Start mapping below (joining tables)
//	Mapping ဆိုတာ Table join တာပဲ table နှစ်ခု join တဲ့အခါ DB ဘက်မှာတော့ column name တွေနဲ့အလုပ်လုပ်ကြပေမယ့်
//	Spring မှာကတော့ Object တွေချိတ်ဆက်ကြတဲ့ပုံစံမျိုးဖြစ်တယ် အဲ့တာကြောင့် ချိတ်မယ့် Object တွေကို import လုပ်ပြီးခေါ်သုံးရတယ်
	
//	@OneToOne(fetch = FetchType.EAGER)
//	FetchType.EAGER က join လုပ်မှ အောက်က address ကိုခေါ်ထုတ်မယ်ဆိုတဲ့ အဓိပ္ပာယ် LAZY ကတော့ ‌Object ကနေမခေါ်လည်း server ပေါ်တင်ပေးတယ်
//	@JoinColumn(name = "address_id", referencedColumnName = "a_id")
//	အပေါ်က name နေရာမှာ ကိုယ်ကြိုက်တဲ့ name ကိုရေးလို့ရတယ် referencedColumnName မှာကတော့ spring ထဲက
//	DB မှာ column အနေနဲ့သိအောင် ပေးထားတဲ့ variable name ကိုပဲထည့်ပေးရမယ်
//	Address address;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="address_id", referencedColumnName = "a_id")
	Address address;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
				name="StdinCLassroom",
				joinColumns = @JoinColumn(name="s_id"),
				inverseJoinColumns = @JoinColumn(name="c_id")
			)
	List<Classroom> classrooms;
	
}
