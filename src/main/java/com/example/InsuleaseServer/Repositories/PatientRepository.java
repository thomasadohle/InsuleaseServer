package com.example.InsuleaseServer.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.InsuleaseServer.Models.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer>{

}
