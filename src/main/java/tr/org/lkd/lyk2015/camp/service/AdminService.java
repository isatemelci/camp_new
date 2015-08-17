package tr.org.lkd.lyk2015.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.org.lkd.lyk2015.camp.dao.AdminDao;
import tr.org.lkd.lyk2015.camp.models.Admin;

@Service
@Transactional
public class AdminService extends GenericService<Admin> {

	@Autowired
	private AdminDao adminDao;
}
