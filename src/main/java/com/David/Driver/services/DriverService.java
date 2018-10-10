package com.David.Driver.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.David.Driver.models.License;
import com.David.Driver.models.Person;
import com.David.Driver.repositories.LicenseRepository;
import com.David.Driver.repositories.PersonRepository;

@Service
public class DriverService {
	private final LicenseRepository LiRepo;
	private final PersonRepository PeRepo;
	
	public DriverService(LicenseRepository repo1, PersonRepository repo2) {
		this.LiRepo = repo1;
		this.PeRepo = repo2;
	}

	public List<License> allLicense(){
		return LiRepo.findAll();
	}
	
	public List<Person> allPeople(){
		return PeRepo.findAll();
	}
	
	public License createLicense(License s) {
		return LiRepo.save(s);
	}
	
	public Person createPerson(Person s) {
		return PeRepo.save(s);
	}
	
	public Person findPerson(Long id) {
		Optional<Person> maybe = PeRepo.findById(id);
		if(maybe.isPresent()) {
			return maybe.get();
		}
		else {
			return null;
		}
	}
}
