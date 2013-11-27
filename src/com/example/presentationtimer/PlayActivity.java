package com.example.presentationtimer;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PlayActivity extends Activity{
	
	public Timer leTimer;
	public ArrayList<Task> list;
	public ProgressBar ppb;
	public ProgressBar tpb;
	public TextView nameTV;
	public Button startButton;
	public int timeTot;
	
	public void onCreate(Bundle savedInstanceState, int id)
	{
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_play);
		leTimer=new Timer(true);
		
		
		nameTV=(TextView) this.findViewById(R.id.name);
		
		this.ppb=(ProgressBar) this.findViewById(R.id.presentationProgressBar);
		this.tpb=(ProgressBar) this.findViewById(R.id.taskProgressBar);
		
		startButton=(Button) this.findViewById(R.id.StartButton);
		
		
		
		
		
		startButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v)
			{
				for(Task task : list)
				{
					PresentationTimerTask tt=new PresentationTimerTask(task.getName(), task.getTime()){
						public void run(){
							nameTV.setText(this.person);
							
							TimerTask tt=new PresentationTimerTask(null, this.time){
								public void run(){
									int percentage= (int) 100/this.time;
									tpb.setProgress(percentage);
								}
							};
							leTimer.scheduleAtFixedRate(tt, 0, this.time);
						}
					};
					
					leTimer.schedule(tt, timeTot);
					timeTot+=task.getTime();
				}
				
				
				TimerTask ppbTask=new TimerTask(){
					public void run()
					{
						int percentage= (int) 100/timeTot;
						ppb.setProgress(percentage);
					}
				};
				
				leTimer.scheduleAtFixedRate(ppbTask, 0, timeTot);
			}
		});
		
		
	}
	
}
