package tr.org.lkd.lyk2015.camp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import tr.org.lkd.lyk2015.camp.models.Course;

@Repository
public class CourseDao extends GenericDao<Course> {

	public List<Course> getByIds(List<Long> ids) {

		Criteria c = createCriteria();

		c.add(Restrictions.in("id", ids));

		return c.list();
	}

}
