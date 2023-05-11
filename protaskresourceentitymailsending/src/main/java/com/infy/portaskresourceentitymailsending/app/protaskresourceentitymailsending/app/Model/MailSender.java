package com.infy.portaskresourceentitymailsending.app.protaskresourceentitymailsending.app.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MailSender {
	
	private String to;
	private String from;
	private String subject;
	private String textBodymsg;

}
