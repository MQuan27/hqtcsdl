package hcmuaf.edu.vn.dao;

import java.util.List;

import hcmuaf.edu.vn.entity.Role;

public interface RoleDAO {
	
	public Role getRoleByName(String name);
	
	public List<Role> getListRole();

}
