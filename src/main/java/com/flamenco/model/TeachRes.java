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
@Table(name = "teachRes")
public class TeachRes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "content")
	private String content;

	@Column(name = "type")
	private int type;

	@Column(name = "startTime")
	private Date startTime;

	@Column(name = "groupId")
	private int groupId;

	@Column(name = "difficulty")
	private int difficulty;

	@Column(name = "adminId")
	private int adminId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		String[] fileName = content.split("/");
		return fileName[fileName.length - 1];
	}

	public void setContent(String filePath) {
		this.content = filePath;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getStarttime() {
		return FormatUtil.Date2String(startTime);
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

}
