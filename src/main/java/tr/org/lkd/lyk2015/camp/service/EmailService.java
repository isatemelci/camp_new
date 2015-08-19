package tr.org.lkd.lyk2015.camp.service;

public interface EmailService {

	void sendMail(String to, String subject, String content);

}
