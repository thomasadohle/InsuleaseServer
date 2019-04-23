package com.example.InsuleaseServer.Services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.InsuleaseServer.Models.Patient;
import com.example.InsuleaseServer.Models.Regiment;
import com.example.InsuleaseServer.Models.User;
import com.example.InsuleaseServer.Repositories.PatientRepository;
import com.example.InsuleaseServer.Repositories.UserRepository;


@RestController
@CrossOrigin(origins = "*")
public class PatientService {
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("api/patient/register")
	public Patient register(@RequestBody Patient newPatient, HttpSession session) {
		System.out.println("register was called from PatientService with patient " + newPatient.toString());
		patientRepository.save(newPatient);
		session.setAttribute("currentUser", newPatient);
		session.setAttribute("userType", "patient");
		if (session.getAttribute("currentUser") == null) {
			System.out.println("Registered patient failed to be set to currentUser");
		}
		return newPatient;
	}
	


}
