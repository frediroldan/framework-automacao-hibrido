package br.com.itau.friday.framework;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendGmail {
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	private static Properties properties = PropertiesHelper.getProperties();
	private static String userMail = properties.getProperty("userMail");
	private static String password = properties.getProperty("password");

	public static void generateAndSendEmail(String subject, String emailBody, String TO, String CC_or_Null,
			File attachmentPath_Or_Null) throws UnsupportedEncodingException, MessagingException {

		// Step1
		System.out.println("\n1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");

		// Step2
		System.out.println("\n2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.setFrom(new InternetAddress("douglasgelli@gmail.com", "Douglas Gelli"));
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(TO));
		// Se Com Copias
		if (CC_or_Null != null) {
			generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(CC_or_Null));
		}
		generateMailMessage.setSubject(subject);
		// if attachment
		if (attachmentPath_Or_Null == null) {
			generateMailMessage.setContent(emailBody, "text/html");
		} else {
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(emailBody);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(attachmentPath_Or_Null);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(attachmentPath_Or_Null.getName());
			multipart.addBodyPart(messageBodyPart);
			generateMailMessage.setContent(multipart);
		}
		System.out.println("Mail Session has been created successfully..");

		// Step3
		System.out.println("\n3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", userMail, password);
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
		System.out.println("Mail Sended");
	}
}
