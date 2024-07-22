package com.employee.employeeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;

import com.employee.employeeservice.entity.Employee;
import com.employee.employeeservice.feignClient.AddressClient;
import com.employee.employeeservice.repository.EmployeeRepo;
import com.employee.employeeservice.response.AddressResponse;
import com.employee.employeeservice.response.EmployeeResponse;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AddressClient addressClient;
	
	
	public EmployeeResponse getEmployeeById(int id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
		
		//Using feign client
		ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
		employeeResponse.setAddressResponse(addressResponse.getBody());
		return employeeResponse;
	}
}
