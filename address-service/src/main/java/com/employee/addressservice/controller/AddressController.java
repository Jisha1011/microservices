package com.employee.addressservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.employee.addressservice.response.AddressResponse;
import com.employee.addressservice.servcie.AddressService;


@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressServcie;

	@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId")int employeeId)
	{
		AddressResponse addressResponse = addressServcie.findAddressByEmployeeId(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
	}
}
