package tr.org.lkd.lyk2015.camp.models.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import tr.org.lkd.lyk2015.camp.models.Application;
import tr.org.lkd.lyk2015.camp.models.Student;

public class ApplicationFormDto {

	private Application application = new Application();

	@Valid
	private Student student = new Student();

	private List<Long> preferredCourseIds = new ArrayList<>();

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

	public List<Long> getPreferredCourseIds() {
		return preferredCourseIds;
	}

	public void setPreferredCourseIds(List<Long> preferredCourseIds) {
		this.preferredCourseIds = preferredCourseIds;
	}

}