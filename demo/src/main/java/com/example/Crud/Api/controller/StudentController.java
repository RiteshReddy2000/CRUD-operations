package com.example.Crud.Api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Crud.Api.entity.StudentEntity;
import com.example.Crud.Api.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@PostMapping("/api/students")
	public ResponseEntity<StudentEntity> saveStudent(@RequestBody StudentEntity student) {
		return new ResponseEntity<>(studentRepository.save(student),HttpStatus.CREATED);
	}
	
	@GetMapping("/api/students")
	public ResponseEntity<List<StudentEntity>> getStudenEntitys(){
		return new ResponseEntity<>(studentRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/api/students/{id}")
	public ResponseEntity<StudentEntity> getStudentEntity(@PathVariable long id){
		Optional<StudentEntity> student = studentRepository.findById(id);
		if(student.isPresent()){
			return new ResponseEntity<>(student.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/api/students/{id}")
	public ResponseEntity<StudentEntity> updateStudentEntity(@PathVariable long id,@RequestBody StudentEntity stud){
		Optional<StudentEntity> student = studentRepository.findById(id);
		if(student.isPresent()){
			student.get().setStudentName(stud.getStudentName());
			student.get().setStudentAddress(stud.getStudentAddress());
			student.get().setStudentEmail(stud.getStudentEmail());
			return new ResponseEntity<>(studentRepository.save(student.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/api/students/{id}")
	public ResponseEntity<StudentEntity> deleteStudentEntity(@PathVariable long id){
		Optional<StudentEntity> student = studentRepository.findById(id);
		if(student.isPresent()){
			studentRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
