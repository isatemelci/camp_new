package tr.org.lkd.lyk2015.camp.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;

@Entity
public class Student extends AbstractUser {

	public enum Sex {
		MALE, FEMALE
	}

	@Enumerated(EnumType.STRING)
	private Sex sex;

	@ManyToMany(mappedBy = "owner")
	private Set<Application> application = new HashSet<>();

	public Sex getSex() {
		return this.sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Set<Application> getApplication() {
		return this.application;
	}

	public void setApplication(Set<Application> application) {
		this.application = application;
	}

}
