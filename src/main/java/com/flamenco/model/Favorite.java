package com.flamenco.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="favorite")
public class Favorite {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="teachResId")
	private int teachResId;
	
	@Column(name="entertainId")
	private int entertainId;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="addTime")
	private Time addTime;
	
	public int getTeachResId() {
		return teachResId;
	}

	public void setTeachResId(int teachResId) {
		this.teachResId = teachResId;
	}

	public int getEntertainId() {
		return entertainId;
	}

	public void setEntertainId(int entertainId) {
		this.entertainId = entertainId;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Time getAddTime() {
		return addTime;
	}
	
	public void setAddTime(Time addTime) {
		this.addTime = addTime;
	}
	
}
