package com.weir.entiy;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(catalog="weir",name="user")
public class User implements Serializable{
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int userId;
	@Column(name="password",length=20)
	private String password;
	@Column(name="user_type",length=15)
	private String userType;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (userId+"##"+password+"##"+userType);
	}
	public User(int userId, String password, String userType) {
		super();
		this.userId = userId;
		this.password = password;
		this.userType = userType;
	}
	
	public User(){
		
	}
}
