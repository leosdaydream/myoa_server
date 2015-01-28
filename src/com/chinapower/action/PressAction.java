package com.chinapower.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.chinapower.entity.Press;
import com.chinapower.org.action.BasicAction;
import com.chinapower.service.PressService;
import com.chinapower.util.Map2Json;

public class PressAction extends BasicAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Press press;
	PressService pressService;
	Map2Json map2jsonUtil = new Map2Json();
	
	public void getPressById(){
		String pressId = request.getParameter("id");
		System.out.println(pressId);
		if(pressId!=null){
			Press getPress = pressService.getPressById(pressId);
			System.out.println("getPress==="+getPress.getPress_create_time());
			if(getPress!=null){
				response.setContentType("text/html;charset=utf-8");
				String getpressjson = map2jsonUtil.object2json(getPress);
				try {
					PrintWriter out =  response.getWriter();
					out.print(getpressjson);
					out.close();
				} catch (IOException e) {
					// log
				}
			}
		}
	}
	
	
	public void getAllPress(){
		List<Press> presslist = pressService.getAllPress();
		StringBuffer sb = new StringBuffer();
		if(presslist.size()>0){
			response.setContentType("text/html;charset=utf-8");
			sb.append("[");
			for (Press press : presslist) {
				String getpressjson = map2jsonUtil.object2json(press);
				sb.append(getpressjson);
				sb.append(",");
			}
			sb.append("]");
			int reindex = sb.lastIndexOf(",");
			sb.replace(reindex, reindex+1, "");
		}
		try {
			PrintWriter out =  response.getWriter();
			out.print(sb.toString());
			out.close();
		} catch (IOException e) {
			// log
		}
	}
	
	
	public Press getPress() {
		return press;
	}
	public void setPress(Press press) {
		this.press = press;
	}
	public PressService getPressService() {
		return pressService;
	}
	public void setPressService(PressService pressService) {
		this.pressService = pressService;
	}
	
}
