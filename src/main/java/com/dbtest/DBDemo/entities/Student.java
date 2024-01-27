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
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int s_id;

	@Column(length = 30, nullable = false)
	private String name;

	@Column(unique = true)
	private String email;

	@Column(name = "Myanmar")
	private int myan;

	@Column(name = "English")
	private int eng;

	@Column(name = "Mathematics")
	private int maths;

}
