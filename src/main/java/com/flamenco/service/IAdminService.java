package com.flamenco.service;

import java.util.List;
import com.flamenco.model.Admin;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface IAdminService extends IBaseService{
	public boolean checkAdmin(Admin admin);
}
