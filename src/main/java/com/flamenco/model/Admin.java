package com.flamenco.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.flamenco.util.FormatUtil;

@Entity
@Table(name="name")
public class Admin {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="passWord")
	private String passWord;
	
	@Column(name="roleType")
	private int roleType;
	
	@Column(name="startTime")
	private Date startTime;
	
	@Column(name="flag")
	private boolean flag;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public int getRoleType() {
		return roleType;
	}
	
	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}
	
	public String getStartTime() {
		return FormatUtil.Date2String(startTime);
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
