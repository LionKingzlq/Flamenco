package com.flamenco.service;

import com.flamenco.model.Admin;
import com.flamenco.model.Advice;

public interface IAdminService extends IBaseService{
	public int checkAdmin(Admin admin);
	public boolean addAdivce(Advice advice);
}
