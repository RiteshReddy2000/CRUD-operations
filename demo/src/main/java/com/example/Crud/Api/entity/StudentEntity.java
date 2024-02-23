package com.example.Crud.Api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	 
	private String studentName;
	private String studentEmail;
	private String studentAddress;
}
