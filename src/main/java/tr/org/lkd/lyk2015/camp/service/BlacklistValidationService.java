package tr.org.lkd.lyk2015.camp.service;

public interface BlacklistValidationService {

	boolean validate(Long tckn, String email, String name, String surname);

}
