package com.example.InsuleaseServer.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.InsuleaseServer.Models.InsulinDose;


public interface InsulinDoseRepository extends CrudRepository<InsulinDose, Integer>{
	@Query(value="SELECT * FROM insulin_dose WHERE patient_user_id=:userId",
			nativeQuery=true)
	public List<InsulinDose> findDoseByPatient(@Param("userId") int userId);
	
	@Query(value="SELECT *  FROM insulin_dose WHERE patient_user_id=:userId ORDER BY dose_id DESC  LIMIT :limit", 
			nativeQuery=true)
	public List<InsulinDose> findDoseByPatientLimited(@Param("userId") int userId, @Param("limit") int limit);

}
