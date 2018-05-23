package com.ksh.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender 
{
	private static String from = "solanki078@gmail.com";
	private static String pass = "Lilykinjal2312*";
	private static String subject = "Someone is looking to hire you";
	private static String[] to = {"solanki078@gmail.com"};
	
	public static boolean sendFromGMail(String body) 
	{
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", "xitij9092@gmail.com");
		props.put("mail.smtp.password", "Temp23Temp*");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props);
		Message message = new MimeMessage(session);
		try 
		{
			message.setFrom(new InternetAddress(from));
			InternetAddress[] toAddress = new InternetAddress[to.length];
			for (int i = 0; i < to.length; i++) {
				toAddress[i] = new InternetAddress(to[i]);
			}
			for (int i = 0; i < toAddress.length; i++) {
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}
			message.setSubject(subject);
			message.setContent(body, "text/html");
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			return true;
		} 
		catch (AddressException ae) 
		{
			ae.printStackTrace();
		} 
		catch (MessagingException me) 
		{
			me.printStackTrace();
		}
		return false;
	}
}
