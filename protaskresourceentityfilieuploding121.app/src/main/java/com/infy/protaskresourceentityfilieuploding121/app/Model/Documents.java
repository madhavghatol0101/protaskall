package com.infy.protaskresourceentityfilieuploding121.app.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Documents {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int documentId;
	@Lob
	private byte[] applicantResume;
	@Lob
	private byte[] experienceLetter;
	@Lob
	private byte[] sallarySlipe;
	@Lob
	private byte[] pComOffLatter;

}
