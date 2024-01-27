package com.emsbackend.ems.mapper;

import com.emsbackend.ems.dto.EmployeeDto;
import com.emsbackend.ems.entity.Employee;

public class EmployeeMapper {
    
	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail()
				);
	}
	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()
				);
	}
}
