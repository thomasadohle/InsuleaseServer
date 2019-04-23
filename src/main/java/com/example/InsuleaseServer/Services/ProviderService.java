package com.example.InsuleaseServer.Services;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.InsuleaseServer.Models.Patient;
import com.example.InsuleaseServer.Models.Provider;
import com.example.InsuleaseServer.Repositories.PatientRepository;
import com.example.InsuleaseServer.Repositories.ProviderRepository;


@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://insulease.herokuapp.com"}, allowCredentials = "true")
public class ProviderService {
	@Autowired
	ProviderRepository providerRepository;
	
	@Autowired
	PatientRepository patientRepository;

	@PostMapping("api/provider/register")
	public Provider register(@RequestBody Provider newProvider, HttpSession session) {
		System.out.println("register was called from ProviderService with patient " + newProvider.toString());
		providerRepository.save(newProvider);
		session.setAttribute("currentUser", newProvider);
		session.setAttribute("userType", "provider");
		if (session.getAttribute("currentUser") == null) {
			System.out.println("Registered patient failed to be set to currentUser");
		}
		return newProvider;
	}
	
	@PostMapping("api/patient/{patId}/provider/{proId}")
	public void addProviderToPatient(@PathVariable("proId") int proId, 
			@PathVariable("patId") int patId) {
		Patient patient = patientRepository.findById(patId).get();
		Provider provider = providerRepository.findById(proId).get();
		patient.addProvider(provider);
		patientRepository.save(patient);
	}
	
	@GetMapping("api/provider/{proId}/patient")
	public List<Patient> findPatientsForProvider(@PathVariable("proId") int proId) {
		Provider provider = providerRepository.findById(proId).get();
		return provider.getPatientList();
	}


}
