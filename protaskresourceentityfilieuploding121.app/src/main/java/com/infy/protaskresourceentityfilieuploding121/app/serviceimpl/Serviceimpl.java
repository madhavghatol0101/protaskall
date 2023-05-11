package com.infy.protaskresourceentityfilieuploding121.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.protaskresoruceentityfileuploding121.app.exception.ApplicantNotFoundException;
import com.infy.protaskresourceentityfilieuploding121.app.Model.Applicant;
import com.infy.protaskresourceentityfilieuploding121.app.repository.ApplicantRepository;
import com.infy.protaskresourceentityfilieuploding121.app.servicei.Servicei;

@Service
public class Serviceimpl implements Servicei{
	@Autowired
	ApplicantRepository ar;

	@Override
	public Applicant saveapp(Applicant ac) {
	
		return ar.save(ac);
	}

	@Override
	public List<Applicant> getData() {
	
		return  ar.findAll();
	
	}

	@Override
	public void deleteApp(int applicantId) {
		
		Applicant aa= ar.findAllByApplicantId(applicantId);
		 
			 if(aa!=null) {
					ar.deleteById(applicantId);
				}
		 
		 else{
				throw new ApplicantNotFoundException("There is no Applicant of this id ...!!!");
			}
		
		
		
	}

}
