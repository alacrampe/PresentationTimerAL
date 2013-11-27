package com.example.presentationtimer;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class PlayActivity extends Activity{
	
	public Timer leTimer;
	public ArrayList<Task> list;
	public ProgressBar pb;
	public Button startButton;
	public long timeTot;
	
	public void onCreate(Bundle savedInstanceState, int id)
	{
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_play);
		leTimer=new Timer(true);
		
		this.pb=(ProgressBar) this.findViewById(R.id.progressBar1);
		
		startButton=(Button) this.findViewById(R.id.StartButton);
		
		startButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v)
			{
				for(Task task : list)
				{
					TimerTask tt=new TimerTask(){
						public void run(){
							
						}
					};
					
					leTimer.schedule(tt, timeTot);
					timeTot+=task.time;
				}
			}
		});
		
		
	}
	
}
