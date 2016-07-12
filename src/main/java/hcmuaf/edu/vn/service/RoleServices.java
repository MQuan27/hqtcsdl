package hcmuaf.edu.vn.service;

import java.util.List;

import hcmuaf.edu.vn.model.Role;

public interface RoleServices {

	public Role getRoleByName(String name);
	
	public List<Role> getListRole();
}
