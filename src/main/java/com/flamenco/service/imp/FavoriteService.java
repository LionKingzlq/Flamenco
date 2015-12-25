package com.flamenco.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flamenco.dao.FavoriteDao;
import com.flamenco.service.IFavoriteService;

@Service(value="favoriteService")
public class FavoriteService extends BaseService implements IFavoriteService{

	@Resource
	private FavoriteDao favoriteDao;
	
	@Override
	public Object get(Object object) {
		
		return null;
	}

	@Override
	public List getAll() {
		System.out.println("adll");
		return null;
	}

	
}
