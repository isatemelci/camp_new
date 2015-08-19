package tr.org.lkd.lyk2015.camp.service.mock;

import org.springframework.stereotype.Service;

import tr.org.lkd.lyk2015.camp.service.ExamValidationService;

@Service
public class MockExamValidationService implements ExamValidationService {

	@Override
	public boolean validate(Long tckn, String email) {

		boolean deger = true;

		if (tckn.equals(2L)) {
			deger = false;
		}

		return deger;
	}

}
