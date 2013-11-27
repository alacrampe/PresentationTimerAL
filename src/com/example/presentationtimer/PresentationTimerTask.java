package com.example.presentationtimer;

import java.util.TimerTask;

public abstract class PresentationTimerTask extends TimerTask{
	
	public String person;
	public int time;
	
	public PresentationTimerTask(String person, int time)
	{
		this.person=person;
		this.time=time;
	}
	
	public abstract void run();
}
