package com.dbtest.DBDemo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int a_id;
	
	@Column(length = 30, nullable = false)
	private String a_name;
	
	@Column(length = 5, nullable = false)
	private int a_zipcode;
	
//	@JsonIgnore
//	@OneToOne(mappedBy = "address")
//	mappedBy = "address" ဆိုတာက Student.java ထဲမှာ ဆောက်ထားတဲ့ address object နဲ့ အောက်က student object တို့ချိတ်မယ်ဆိုတဲ့သဘော
//	ဒါဆိုရင် student & address တို့ one to one mapping ချိတ်သွားပြီ
//	Student student;

	@JsonIgnore
	@OneToMany(mappedBy = "address")
	List<Student> students;
	
}
