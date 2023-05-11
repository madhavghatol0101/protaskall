package com.infy.protaskresourceentityfilieuploding121.app.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Applicant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int applicantId;
	private String applicantName;
	private String applicantEmail;
	private long mobileNumber;
	private byte applicantAge;
	private String priviousjob;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Documents applicantDocuments;
}
