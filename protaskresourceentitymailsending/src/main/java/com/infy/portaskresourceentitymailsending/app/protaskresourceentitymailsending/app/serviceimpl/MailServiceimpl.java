package com.infy.portaskresourceentitymailsending.app.protaskresourceentitymailsending.app.serviceimpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.infy.portaskresourceentitymailsending.app.protaskresourceentitymailsending.app.Model.MailSender;
import com.infy.portaskresourceentitymailsending.app.protaskresourceentitymailsending.app.servicei.MailServicei;

@Service
public class MailServiceimpl implements MailServicei {

	@Autowired
	JavaMailSender sender;

	@Override
	public void sendMail(MailSender mail) {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		
		System.out.println("QQQ");
		msg.setTo(mail.getTo());
		msg.setFrom(mail.getFrom());
		msg.setSubject(mail.getSubject());
		msg.setText(mail.getTextBodymsg());
	
		sender.send(msg);
		System.out.println("sent...");
	}

	@Override
	public void sendAttachment(MailSender e, MultipartFile file1) {
		MimeMessage mimeMessage = sender.createMimeMessage();
		
		try {
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
		
			helper.setTo(e.getTo());
			helper.setFrom(e.getFrom());
			helper.setSubject(e.getSubject());
			helper.setText(e.getTextBodymsg());
			
			helper.addAttachment(file1.getOriginalFilename(), file1);
			System.out.println("this is controller.....");
			
		}catch(Exception ea) {
			System.out.println("WWWW");
			ea.printStackTrace();
		}
		sender.send(mimeMessage);
	}
	

}
 