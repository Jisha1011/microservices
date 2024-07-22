package com.employee.employeeservice.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import com.employee.employeeservice.response.AddressResponse;

@FeignClient(name="address-client",url="http://localhost:8083",path="/address-service")
public interface AddressClient {
	
	@GetMapping("/address/{id}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("id") int id);
 

}
