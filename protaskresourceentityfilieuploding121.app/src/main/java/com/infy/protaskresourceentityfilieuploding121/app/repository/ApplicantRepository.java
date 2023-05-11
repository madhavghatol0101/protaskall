package com.infy.protaskresourceentityfilieuploding121.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.protaskresourceentityfilieuploding121.app.Model.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer>{

	public Applicant findAllByApplicantId(int applicantId);
}
