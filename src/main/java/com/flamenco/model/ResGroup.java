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
@Table(name="resGroup")
public class ResGroup {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;

	@Column(name="adminId")
	private int adminId;

	@Column(name="adminName")
	private String adminName;
	
	@Column(name="startTime")
	private Date startTime;
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public int getAdminId() {
		return adminId;
	}
	
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public ResGroup(){
		
	}
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

	public String getStarttime() {
		return FormatUtil.Date2String(startTime);
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
