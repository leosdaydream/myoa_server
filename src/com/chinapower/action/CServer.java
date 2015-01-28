package com.chinapower.action;

import com.chinapower.entity.ClientInfo;
import com.chinapower.org.action.BasicAction;

public class CServer extends BasicAction {

	private static final long serialVersionUID = 1L;
	ClientInfo clientinfo;
	String clientinfos;
	public void requestClientInfo(){
		System.out.println("c===========info"+clientinfos);
	}
	public ClientInfo getClientinfo() {
		return clientinfo;
	}
	public void setClientinfo(ClientInfo clientinfo) {
		this.clientinfo = clientinfo;
	}
	public String getClientinfos() {
		return clientinfos;
	}
	public void setClientinfos(String clientinfos) {
		this.clientinfos = clientinfos;
	}
	
}
