package com.chinapower.service;

import java.util.List;

import com.chinapower.entity.Press;

public interface PressService {
	public List<Press> getAllPress();
	public Press getPressById(String id);
}
