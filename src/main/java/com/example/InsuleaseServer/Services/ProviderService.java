package com.example.InsuleaseServer.Services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.InsuleaseServer.Models.Provider;
import com.example.InsuleaseServer.Repositories.ProviderRepository;

@CrossOrigin(allowCredentials="true")
@RestController
public class ProviderService {
	@Autowired
	ProviderRepository providerRepository;
	

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

}