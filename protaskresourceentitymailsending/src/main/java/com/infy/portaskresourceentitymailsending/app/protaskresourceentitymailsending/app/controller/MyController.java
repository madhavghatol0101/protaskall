package com.infy.portaskresourceentitymailsending.app.protaskresourceentitymailsending.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.portaskresourceentitymailsending.app.protaskresourceentitymailsending.app.Model.MailSender;
import com.infy.portaskresourceentitymailsending.app.protaskresourceentitymailsending.app.servicei.MailServicei;
@CrossOrigin("*")
@RestController
public class MyController {
	@Autowired
	MailServicei msi;
	
	@Value("${spring.mail.username}")
	String username;
	
	@PostMapping(value = "/sendmail")
	public String sendMail(@RequestBody MailSender mail){
		mail.setFrom(username);
		try {
			System.out.println("AAAA");
			msi.sendMail(mail);
		}catch(Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "Send mail successfully";
		
	}
	
	@PostMapping(value = "/sendattachment")
	public String sendAttachment(@RequestPart("file") MultipartFile file,
			@RequestPart("data") String data) {
		System.out.println("callled");
		try {
			ObjectMapper m = new ObjectMapper();
				MailSender e = m.readValue(data, MailSender.class);
			e.setFrom(username);
			
			msi.sendAttachment(e,file);			
		}catch(Exception ee) {
			System.out.println("this is catch block");
			ee.printStackTrace();
			return "fail...";
		}
		return "send mail successfully...";
		
	}
		

}
