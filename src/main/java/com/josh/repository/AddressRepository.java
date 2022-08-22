package com.josh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josh.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	
}