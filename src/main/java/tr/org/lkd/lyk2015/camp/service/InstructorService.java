package tr.org.lkd.lyk2015.camp.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.org.lkd.lyk2015.camp.dao.CourseDao;
import tr.org.lkd.lyk2015.camp.dao.InstructorDao;
import tr.org.lkd.lyk2015.camp.models.Course;
import tr.org.lkd.lyk2015.camp.models.Instructor;

@Service
@Transactional
public class InstructorService extends GenericService<Instructor> {

	@Autowired
	private InstructorDao instructorDao;

	@Autowired
	private CourseDao courseDao;

	public void create(Instructor instructor, List<Long> ids) {

		List<Course> courses = courseDao.getByIds(ids);

		Set<Course> courseSet = new HashSet<>();

		courses.addAll(courses);

		instructor.setCourses(courseSet);

		instructor.getCourses().addAll(courses);

		instructorDao.create(instructor);
	}

	public Instructor update(Instructor instructor, List<Long> ids) {

		List<Course> courses = courseDao.getByIds(ids);

		Set<Course> courseSet = new HashSet<>();

		courses.addAll(courses);

		instructor.setCourses(courseSet);

		instructor.getCourses().addAll(courses);

		instructorDao.update(instructor);

		return null;
	}
}
