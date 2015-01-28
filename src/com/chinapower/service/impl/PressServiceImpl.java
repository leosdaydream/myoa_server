package com.chinapower.service.impl;

import java.util.List;

import com.chinapower.dao.PressDao;
import com.chinapower.entity.Press;
import com.chinapower.service.PressService;

public class PressServiceImpl implements PressService {
	PressDao pressDao;
	public List<Press> getAllPress() {
		return pressDao.getAllPress();
	}

	public Press getPressById(String id) {
		return pressDao.getPressById(id);
	}
	
	
	// get set
	public PressDao getPressDao() {
		return pressDao;
	}
	public void setPressDao(PressDao pressDao) {
		this.pressDao = pressDao;
	}
	
}
