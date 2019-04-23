package com.example.InsuleaseServer.Services;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@CrossOrigin(origins = {"*"}, allowCredentials = "true", allowedHeaders = "*")
@RestController
public class DummyService {
	@GetMapping("/date")
	public Date getDate() {return new Date();}
	
	

}
