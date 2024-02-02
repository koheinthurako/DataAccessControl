package com.dbtest.DBDemo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int a;
	
	@Column(length = 10)
	private String b;
	
	
	
}
