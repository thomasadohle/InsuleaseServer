package com.example.InsuleaseServer.Services;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@CrossOrigin(origins = {"http://localhost:4200", "http://insulease.herokuapp.com/", "http://intense-journey-85451.herokuapp.com/"}, allowCredentials = "true", allowedHeaders = "*")
@RestController
public class DummyService {
	@GetMapping("/date")
	public Date getDate() {return new Date();}
	
	

}
