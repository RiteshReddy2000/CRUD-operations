package com.example.Crud.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Crud.Api.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
