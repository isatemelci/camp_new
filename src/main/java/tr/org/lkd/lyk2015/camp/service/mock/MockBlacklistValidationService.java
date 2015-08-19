package tr.org.lkd.lyk2015.camp.service.mock;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import tr.org.lkd.lyk2015.camp.service.BlacklistValidationService;

@Service
@Transactional
public class MockBlacklistValidationService implements BlacklistValidationService {

	@Override
	public boolean validate(Long tckn, String email, String name, String surname) {

		boolean deger = true;

		if (tckn.equals(22L)) {

			deger = false;

		}

		if (email.equals("isa@isa.com")) {
			deger = false;
		}

		return deger;
	}

}
