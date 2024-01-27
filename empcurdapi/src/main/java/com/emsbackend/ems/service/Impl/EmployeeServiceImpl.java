package com.emsbackend.ems.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

//import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.emsbackend.ems.dto.EmployeeDto;
import com.emsbackend.ems.entity.Employee;
import com.emsbackend.ems.exception.ResourceNotFoundException;
import com.emsbackend.ems.mapper.EmployeeMapper;
import com.emsbackend.ems.repository.EmployeeRepository;
import com.emsbackend.ems.service.EmployeeService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    
	private EmployeeRepository employeeRepository;
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() ->
				new ResourceNotFoundException("Employee does not exist with given id " +  	employeeId));
							
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeRepository.findAll();
		
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
		// TODO Auto-generated method stub
		Employee  employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee does not exist with the given id " + employeeId)	
				);
		
		employee.setFirstName(updateEmployee.getFirstName());
		employee.setLastName(updateEmployee.getLastName());
		employee.setEmail(updateEmployee.getEmail());
		
		Employee updatedEmployeeObj = employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}
    @SuppressWarnings("unused")
	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee does not exist with the given id " + employeeId)	
				);
		
		employeeRepository.deleteById(employeeId);
		
	}

}
