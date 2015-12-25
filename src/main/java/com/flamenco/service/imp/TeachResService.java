package com.flamenco.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flamenco.dao.TeachResDao;
import com.flamenco.service.ITeachService;

@Service(value="teachService")
public class TeachResService extends BaseService implements ITeachService {

	@Resource
	private TeachResDao teachResDao;
	
	@Override
	public Object get(Object object) {
		return null;
	}

	@Override
	public List getAll() {
		return null;
	}

}
