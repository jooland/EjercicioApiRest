package es.api.docu.webapp.dtos;

import java.util.Objects;

public class User {

	

	private String nick;
	private String name;
	
	public User() {
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
