package com.example.presentationtimer;

import java.util.TimerTask;

public abstract class PresentationTimerTask extends TimerTask{
	
	public String person;
	
	public PresentationTimerTask(String person)
	{
		this.person=person;
	}
	
	public abstract void run();
}
