package com.example.presentationtimer;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_play);
		
		leTimer=new Timer(true);
		
		nameTV=(TextView) this.findViewById(R.id.name);
		
		this.ppb=(ProgressBar) this.findViewById(R.id.presentationProgressBar);
		this.tpb=(ProgressBar) this.findViewById(R.id.taskProgressBar);
		
		startButton=(Button) this.findViewById(R.id.StartButton);
		
		list=new ArrayList<Task>();
		list.add(new Task(1,"Gergio",350,1,1));
		list.add(new Task(1,"Gergio",350,1,1));
		list.add(new Task(1,"Gergio",350,1,1));
		list.add(new Task(1,"Gergio",350,1,1));
		
		
		startButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v)
			{
				
				for(Task task : list)
				{
					PresentationTimerTask tt=new PresentationTimerTask(task.getName(), task.getTime()){
						public void run(){
							nameTV.setText(this.person);
							
							TimerTask tt=new PresentationTimerTask(null, (this.time*1000)){
								public void run(){
									int percentage= (int) 100/(this.time*1000);
									tpb.setProgress(percentage);
								}
							};
							leTimer.scheduleAtFixedRate(tt, 0, (this.time*1000));
						}
					};
					
					leTimer.schedule(tt, timeTot);
					timeTot+=task.getTime()*1000;
				}
				
				timeTot=50000;
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
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		this.finish();
		
		return true;
	}
}
