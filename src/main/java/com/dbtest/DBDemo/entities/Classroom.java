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

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Classroom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int c_id;
	
	@Column(length = 30, nullable = false)
	private String c_name;

}
