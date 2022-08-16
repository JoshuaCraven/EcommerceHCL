package com.josh.config;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.josh.email.EmailConfig;
import com.josh.model.User;

@Service
public class EmailService {
	
	@Autowired
	private EmailConfig emailConfig;
	private String imageUrl = "https://res.cloudinary.com/hcl-technology-ecom/image/upload/v1660346541/sample.jpg";
	
	
	public void sendEmail(User user) throws MessagingException {
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		mailSender.setHost(this.emailConfig.getHost());
		mailSender.setPort(this.emailConfig.getPort());
		mailSender.setUsername(this.emailConfig.getUsername());
		mailSender.setPassword(this.emailConfig.getPassword());
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper msgHelper =  new MimeMessageHelper(message, true);
		msgHelper.setFrom("ecommerce@josh.com");
		msgHelper.setTo(user.getEmail());
		msgHelper.setSubject(user.getFirstName()+"thanks for registering");
		msgHelper.setText("<html>"
				+"<body style='display: flex; flex-direction:column; align-items: center; justify-content:center; background color:lightblue;"
				+"font-family: arial, Helevetica, sans-serif;'><div style='background-color:lightblue; padding:1em; "
				+ "width: fit-content; text-align: center; border-radius: 5em'>"
				+ "<h1>Welcome "+ user.getFirstName()+"</h1>"
				+ "<h2 style='font-weight:lighter'>You have been successfully registered</h2>"+ "</div><img src'"+this.imageUrl
				+ "' alternate='Image'" + "style='width:40em; height:40em; border-radius:5em'>"+"</body>"+"</html>", true);
		
		mailSender.send(message);
		System.out.println("Successfully Email");
		
		
		
	}

}