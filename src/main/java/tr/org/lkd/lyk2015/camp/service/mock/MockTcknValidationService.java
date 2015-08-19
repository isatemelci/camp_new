package tr.org.lkd.lyk2015.camp.service.mock;

import org.springframework.stereotype.Service;

import tr.org.lkd.lyk2015.camp.service.TcknValidationService;

@Service
public class MockTcknValidationService implements TcknValidationService {

	@Override
	public boolean validate(String name, String surname, Long tckn) {

		if (tckn.equals(1L)) {
			return false;
		}

		return false;
	}

}
