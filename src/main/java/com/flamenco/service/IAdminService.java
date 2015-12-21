package com.flamenco.service;

import java.util.List;
import com.flamenco.model.Admin;

public interface IAdminService extends IBaseService{
	public List<Admin> getAllAdmin();
	public boolean checkAdmin(Admin admin);
}
