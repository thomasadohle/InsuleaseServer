package com.example.InsuleaseServer.Services;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://insulease.herokuapp.com"}, allowCredentials = "true")
public class DummyService {
	@GetMapping("/date")
	public Date getDate() {return new Date();}
	
	

}
