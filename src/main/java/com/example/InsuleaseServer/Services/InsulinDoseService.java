package com.example.InsuleaseServer.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.InsuleaseServer.Models.InsulinDose;
import com.example.InsuleaseServer.Models.Patient;
import com.example.InsuleaseServer.Repositories.InsulinDoseRepository;
import com.example.InsuleaseServer.Repositories.PatientRepository;
import com.example.InsuleaseServer.Repositories.UserRepository;
 


@CrossOrigin(origins = {"http://localhost:4200", "http://insulease.herokuapp.com/"}, allowCredentials = "true", allowedHeaders = "*")
@RestController
public class InsulinDoseService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	InsulinDoseRepository insulinDoseRepository;
	
	@GetMapping("/api/patient/{userId}/insulindose")
	public List<InsulinDose> findAllDoses(@PathVariable(value="userId") int userId) {
		List<InsulinDose> doses= insulinDoseRepository.findDoseByPatient(userId);
		return doses;
	}
	
	@GetMapping("/api/patient/{userId}/insulindose/{limit}")
	public List<InsulinDose> findSomeDoses(@PathVariable(value="userId") int userId, @PathVariable(value="limit") int limit){
		List<InsulinDose> doses = insulinDoseRepository.findDoseByPatientLimited(userId, limit);
		return doses;
	}
	
	@PostMapping("/api/patient/{userId}/insulindose")
	public InsulinDose addDose(@PathVariable (value="userId")int userId,
			@RequestBody InsulinDose newDose) {
		Patient patient = patientRepository.findById(userId).get();
		newDose.setPatient(patient);
		patient.addInsulinDose(newDose);
		insulinDoseRepository.save(newDose);
		patientRepository.save(patient);
		return newDose;
	}
	
	@DeleteMapping("/api/insulindose/{doseId}")
	public void deleteInsulinDose(@PathVariable(value="doseId") int doseId) {
		insulinDoseRepository.deleteById(doseId);
	}
	

}
