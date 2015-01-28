package com.chinapower.action.junit;

import org.junit.Test;

import com.chinapower.action.GetCityWether;

public class GetCityWetherTest {


	@Test
	public void testGetCityConf() {
		GetCityWether g = new GetCityWether();
		try {
			g.getCityConf("101010100");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
