package com.chinapower.dao;

import java.util.List;

import com.chinapower.entity.Press;

public interface PressDao {
	public List<Press>  getAllPress();
	public Press getPressById(String id);
}
