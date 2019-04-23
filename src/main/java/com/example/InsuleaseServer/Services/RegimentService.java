package com.example.InsuleaseServer.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.InsuleaseServer.Models.Patient;
import com.example.InsuleaseServer.Models.Regiment;
import com.example.InsuleaseServer.Repositories.PatientRepository;
import com.example.InsuleaseServer.Repositories.RegimentRepository;
import com.example.InsuleaseServer.Repositories.UserRepository;


@CrossOrigin(origins = {"*"}, allowCredentials = "true", allowedHeaders = "*")
@RestController
public class RegimentService {
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	RegimentRepository regimentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/api/patient/{userId}/regiment")
	public Regiment findRegiment(@PathVariable (value="userId") int userId) {
		Patient patient = (Patient)userRepository.findById(userId).get();
		return patient.getRegiment();
	}
	
	@PostMapping("/api/patient/{userId}/regiment")
	public Regiment assignRegiment(@PathVariable (value="userId") int userId, 
			@RequestBody Regiment newRegiment) {
		regimentRepository.save(newRegiment);
		Patient patient = (Patient)userRepository.findById(userId).get();
		patient.setRegiment(newRegiment);
		patientRepository.save(patient);
		return newRegiment;
	}
	

}
