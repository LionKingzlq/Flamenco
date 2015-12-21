package com.flamenco.service;

import java.util.List;

public interface IBaseService {
	
	public boolean save(Object object);
	public boolean delete(Object object);
	public boolean modify(Object object);
	public Object get(Object object);
	public List getAll();
	
}
