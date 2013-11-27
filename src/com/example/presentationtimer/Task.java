package com.example.presentationtimer;

public class Task {

	public Task(int int1, String string, int int2, int k, int l) {
		// TODO Auto-generated constructor stub
	}
	
	public Task() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public int getPresentationid() {
		return presentationid;
	}
	public void setPresentationid(int presentationid) {
		this.presentationid = presentationid;
	}
	private long id;
	private String name;
	private long time;
	private int personid;
	private int presentationid;
}