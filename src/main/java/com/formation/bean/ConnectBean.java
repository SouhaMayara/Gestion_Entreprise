package com.formation.bean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "connectBean")
@SessionScoped


public class ConnectBean {
	private String login;
	private String motPasse;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	
	
	public String connecter() {
		if (login != null && login.equals("admin") && motPasse != null
				&& motPasse.equals("admin"))
			return "accepted";
		else {
			login = null;
			motPasse = null;
			return null;
		}
	}

	public String annuler() {
		login = null;
		motPasse = null;
		return null;
	}
}
