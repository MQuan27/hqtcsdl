package hcmuaf.edu.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hcmuaf.edu.vn.dao.RoleDAO;
import hcmuaf.edu.vn.entity.Role;

@Service
@Transactional
public class RoleServicesImpl implements RoleServices {
	@Autowired
	RoleDAO roleDAO;

	@Override
	public Role getRoleByName(String name) {
		return roleDAO.getRoleByName(name);
	}

	@Override
	public List<Role> getListRole() {
		return roleDAO.getListRole();
	}

}
