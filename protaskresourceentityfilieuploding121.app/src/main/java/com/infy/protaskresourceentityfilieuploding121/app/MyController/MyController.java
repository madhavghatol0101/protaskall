package com.infy.protaskresourceentityfilieuploding121.app.MyController;

import java.io.IOException;
import java.util.List;

import javax.swing.text.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.protaskresourceentityfilieuploding121.app.Model.Applicant;
import com.infy.protaskresourceentityfilieuploding121.app.Model.Documents;
import com.infy.protaskresourceentityfilieuploding121.app.servicei.Servicei;

@RestController
public class MyController {

	@Autowired
	Servicei si;

	@PostMapping(value = "/applicantsave") // uploaded file received in a multipart request
	public Applicant saveapp(@RequestParam("applicantResume") MultipartFile resume,
			@RequestParam("experienceLetter") MultipartFile experience,
			@RequestParam("sallarySlipe") MultipartFile sslip, 
			@RequestParam("pComOffLatter") MultipartFile offerL,
			@RequestParam("applic") String applic) throws IOException {

		Documents doc = new Documents();
		doc.setApplicantResume(resume.getBytes());
		doc.setExperienceLetter(experience.getBytes());
		doc.setSallarySlipe(sslip.getBytes());
		doc.setPComOffLatter(offerL.getBytes());

		ObjectMapper mapp = new ObjectMapper();
		Applicant ac = mapp.readValue(applic, Applicant.class);
		ac.setApplicantDocuments(doc);

		return si.saveapp(ac);

	}

	@GetMapping(value = "/applicants")
	public ResponseEntity<List<Applicant>> getData() {

		List<Applicant> list = si.getData();
		return new ResponseEntity<List<Applicant>>(list, HttpStatus.OK);
	}

	@DeleteMapping(value = "/applicantsdel/{applicantId}")
	public ResponseEntity deleteApp(@PathVariable int applicantId) {

		si.deleteApp(applicantId);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@PutMapping(value = "/applicantup/{applicantId}")
	public ResponseEntity<Applicant> updateApp(@RequestBody Applicant ac, @PathVariable int applicantId) {

		Applicant appli = si.saveapp(ac);
		return new ResponseEntity<Applicant>(appli, HttpStatus.OK);
	}

}
