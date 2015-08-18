package tr.org.lkd.lyk2015.camp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.org.lkd.lyk2015.camp.dao.CourseDao;
import tr.org.lkd.lyk2015.camp.models.Course;

@Service
@Transactional
public class CourseService extends GenericService<Course> {

	@Autowired
	private CourseDao courseDao;

	public List<Course> getAllActive() {

		return courseDao.getAllActive();

	}
}
