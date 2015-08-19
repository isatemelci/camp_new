package tr.org.lkd.lyk2015.camp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.org.lkd.lyk2015.camp.dao.ApplicationDao;
import tr.org.lkd.lyk2015.camp.dao.CourseDao;
import tr.org.lkd.lyk2015.camp.dao.StudentDao;
import tr.org.lkd.lyk2015.camp.models.Application;
import tr.org.lkd.lyk2015.camp.models.Course;
import tr.org.lkd.lyk2015.camp.models.Student;
import tr.org.lkd.lyk2015.camp.models.dto.ApplicationFormDto;

@Service
@Transactional
public class ApplicationService extends GenericService<Application> {

	@Autowired
	private ApplicationDao applicationDao;

	private static final String URL_BASE = "http://localhost:8080/camp_new/applications/validate/";

	@Autowired
	private CourseDao courseDao;

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private EmailService emailService;

	public void create(ApplicationFormDto applicationFormDto) {

		Application application = applicationFormDto.getApplication();

		Student student = applicationFormDto.getStudent();

		List<Long> courseIds = applicationFormDto.getPreferredCourseIds();

		// generate email verification url
		String uuid = UUID.randomUUID().toString();

		String url = URL_BASE + uuid;

		// TODO send verification email
		this.emailService.sendMail(student.getEmail(), "Basvuru onayı", url);

		application.setValidationId(uuid);

		// add preferred courses to application entity
		List<Course> courses = this.courseDao.getByIds(courseIds);

		application.getPreferredCourses().addAll(courses);

		// check if user exists on db
		Student studentFromDB = this.studentDao.getUserByTckn(student.getTckn());

		if (studentFromDB == null) {
			this.studentDao.create(student);

			studentFromDB = student;
		}

		// set application's user
		application.setOwner(studentFromDB);

		// saved application
		this.applicationDao.create(application);

	}
}
