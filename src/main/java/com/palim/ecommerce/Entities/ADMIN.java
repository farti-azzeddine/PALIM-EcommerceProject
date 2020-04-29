package com.palim.ecommerce.Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;
@Entity
public class ADMIN implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAdmin;
	private String username;
	private String password;
	private boolean actived;
	


	public Long getIAdmin() {
		return idAdmin;
	}


	public void setIAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isActived() {
		return actived;
	}


	public void setActived(boolean actived) {
		this.actived = actived;
	}


	


	public ADMIN() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ADMIN(String username, String password, boolean actived) {
		super();
		this.username = username;
		this.password = password;
		this.actived = actived;
	}
	
	
}
