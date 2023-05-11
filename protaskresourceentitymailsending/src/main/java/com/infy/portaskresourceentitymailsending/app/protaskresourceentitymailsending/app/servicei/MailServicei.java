package com.infy.portaskresourceentitymailsending.app.protaskresourceentitymailsending.app.servicei;

import org.springframework.web.multipart.MultipartFile;

import com.infy.portaskresourceentitymailsending.app.protaskresourceentitymailsending.app.Model.MailSender;

public interface MailServicei {

	public void sendMail(MailSender mail);

	public void sendAttachment(MailSender e, MultipartFile file1);


	

}
