package com.emsbackend.ems.service;

import java.util.List;

import com.emsbackend.ems.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee);
	
	void deleteEmployee(Long employeeId);
}
