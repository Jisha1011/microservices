package com.employee.employeeservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {
	
	@Bean
	public ModelMapper modelMapperBean() {
		return new ModelMapper();
	}
	
}
