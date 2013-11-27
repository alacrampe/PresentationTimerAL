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
	public ProgressBar pb;
	public TextView nameTV;
	public Button startButton;
	public long timeTot;
	
	public void onCreate(Bundle savedInstanceState, int id)
	{
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_play);
		leTimer=new Timer(true);
		
		
		nameTV=(TextView) this.findViewById(R.id.name);
		
		this.pb=(ProgressBar) this.findViewById(R.id.progressBar1);
		
		startButton=(Button) this.findViewById(R.id.StartButton);
		
		startButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v)
			{
				for(Task task : list)
				{
					PresentationTimerTask tt=new PresentationTimerTask(task.getName()){
						public void run(){
							nameTV.setText(this.person);
						}
					};
					
					leTimer.schedule(tt, timeTot);
					timeTot+=task.getTime();
				}
			}
		});
		
		
	}
	
}
