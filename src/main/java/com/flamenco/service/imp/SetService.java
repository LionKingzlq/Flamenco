package com.flamenco.service.imp;

import com.flamenco.model.Set;
import com.flamenco.service.ISetService;
import com.flamenco.dao.SetDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value="setService")
@Resource(name="setService")
public class SetService implements ISetService{

    private SetDao setDao;
	public SetDao getSetDao() {
		return setDao;
	}
	
	@Resource
	public void setSetDao(SetDao setDao) {
		this.setDao = setDao;
	}
	
    public Set get(String key) {
        Set set = setDao.get(key);
        return set;
    }

    public boolean add(Set set){
    	return setDao.add(set);
    }
    
}
