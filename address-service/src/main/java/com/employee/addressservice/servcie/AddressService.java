package com.employee.addressservice.servcie;


import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.addressservice.entity.Address;
import com.employee.addressservice.repository.AddressRepo;
import com.employee.addressservice.response.AddressResponse;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public AddressResponse findAddressByEmployeeId(int employeeId)
	{
		//Optional<Address> addressByEmployeeId = addressRepo.findAddressByEmployeeId(employeeId);
		AddressResponse ad = new AddressResponse();
		ad.setCity("city");
		ad.setState("state");
		ad.setId(employeeId);
		AddressResponse addressResponse = mapper.map(ad, AddressResponse.class);
		return addressResponse;
	}
	
}
