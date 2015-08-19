package tr.org.lkd.lyk2015.camp.service.mock;

import org.springframework.stereotype.Service;

import tr.org.lkd.lyk2015.camp.service.EmailService;

@Service
public class MockEmailService implements EmailService {

	@Override
	public void sendMail(String to, String subject, String content) {

		String message = "email doğrulanmadı";

		if (content.contains("a")) {

			message = "mail doğrulama başarılı";

		}

	}

}
