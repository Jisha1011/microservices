package com.employee.addressservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.addressservice.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{
	@Query(
	        nativeQuery = true,
	        value
	        = "SELECT ea.id, ea.city, ea.state FROM employee.address ea join employee.employee e on e.id = ea.employee_id where ea.employee_id=:employeeId")
	       
	Optional<Address>findAddressByEmployeeId(@Param("employeeId") int employeeId);

}
