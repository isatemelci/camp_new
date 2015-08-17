package tr.org.lkd.lyk2015.camp.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

@Entity
public class Student extends AbstractUser {

	public enum Sex {
		MALE, FEMALE
	}

	@Enumerated(EnumType.STRING)
	private Sex sex;

	@OneToMany(mappedBy = "owner")
	private Set<ApplicationForm> applicationForms;

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Set<ApplicationForm> getApplicationForms() {
		return applicationForms;
	}

	public void setApplicationForms(Set<ApplicationForm> applicationForms) {
		this.applicationForms = applicationForms;
	}

}
