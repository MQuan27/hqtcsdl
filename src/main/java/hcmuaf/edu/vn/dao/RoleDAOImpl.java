package hcmuaf.edu.vn.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hcmuaf.edu.vn.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Role getRoleByName(String roleName) {
		return (Role) sessionFactory.getCurrentSession()
				.createQuery("From Role ro WHERE ro.name=:roleName")
				.setString("roleName", roleName).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getListRole() {
		List<Role> list = sessionFactory.getCurrentSession()
				.createQuery("FROM Role").list();
		return list;
	}

}
