package com.example.presentationtimer;

public abstract class TaskRunnable implements Runnable{
	public String person;
	public int time;
	
	public TaskRunnable(String person, int time)
	{
		this.person=person;
		this.time=time;
	}
	
	public abstract void run();
}
