package com.ls.po;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.ls.handler.validation.ValiGrp1;
import com.ls.handler.validation.ValiGrp2;

public class User implements Serializable{
	
	private int id;
	
	@Size(min=3,max=10,message="{user.username.length.error}",groups={ValiGrp1.class})
	private String username;
	@Size(min=1,message="{user.password.isNULL}",groups={ValiGrp2.class})
	private String password;
	private String address;
	private int age;
	private String photo;
	
	// ---
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
}