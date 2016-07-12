package hcmuaf.edu.vn.service;

import java.util.List;

import hcmuaf.edu.vn.entity.Role;

public interface RoleServices {

	public Role getRoleByName(String name);
	
	public List<Role> getListRole();
}
