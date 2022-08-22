package com.josh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.josh.model.Address;
import com.josh.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public List<Address> getAllAddresses() {
		return addressRepository.findAll();
	}
	
	public Address getAddressById(Long id) {
		return addressRepository.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No Address found with id: "+id) );
	}
	
	public void addAddress(Address address) {
		addressRepository.save(address);
	}
	
	public Address updateAddress(Address address) {
		addressRepository.findById(address.getAddressId())
		.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No Address found with id: "+address.getAddressId()) );
	return addressRepository.save(address);
	}
	
	public void deleteAddressById(Long id) {
		addressRepository.deleteById(id);
	}
	
}