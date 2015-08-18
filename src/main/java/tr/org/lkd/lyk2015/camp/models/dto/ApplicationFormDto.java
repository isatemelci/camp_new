package tr.org.lkd.lyk2015.camp.models.dto;

import tr.org.lkd.lyk2015.camp.models.Application;
import tr.org.lkd.lyk2015.camp.models.Student;

public class ApplicationFormDto {

	private Application application = new Application();

	private Student student = new Student();

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}