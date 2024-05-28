package com.example.demo001;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.File;

@SpringBootTest
class Demo001ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private JavaMailSender sender;          //邮件发送器
	private String from = "1743769392@qq.com";    //发件人
	private String to = "jerry_test@sohu.com";      //收件人
	private String subject = "This is a test Mail"; //标题
	private String message = "Hello,Java Mail"; //正文
	

	@Test
	public void testSendSimpleMail() {
		SimpleMailMessage mail = new SimpleMailMessage();   //简单邮件
		mail.setSubject(subject);
		mail.setText(message);
		mail.setFrom(from);
		mail.setTo(to);
		sender.send(mail);  //发送邮件
		System.out.println("邮件发送成功！");
	}

	@Test
	public void testSendMimeMail() throws MessagingException {
		MimeMessage mail = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail,true);
		helper.setSubject(subject);
		helper.setText(message+"<img src=''/>",true);
		helper.setFrom(from);
		helper.setTo(to);
		File file = new File("");
		helper.addAttachment(file.getName(),file);
		sender.send(mail);
		System.out.println("邮件发送成功！");

	}

}
