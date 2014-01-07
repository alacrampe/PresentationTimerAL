package com.example.presentationtimer;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
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
	public Handler handler;
	
	public int elapsedTimeP;
	public int elapsedTimeT;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_play);
		
		//leTimer=new Timer(true);
		
		handler=new Handler();
		
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
					/*PresentationTimerTask tt=new PresentationTimerTask(task.getName(), task.getTime()){
						public void run(){
							nameTV.setText(this.person);
							
							TimerTask tt=new PresentationTimerTask(null, (this.time*1000)){
								public void run(){
									int percentage= (int) Math.round(100/(this.time*1000));
									tpb.setProgress(percentage);
								}
							};
							leTimer.scheduleAtFixedRate(tt, 0, (this.time*1000));
						}
					};
					
					leTimer.schedule(tt, timeTot);
					*/
					
					Runnable elapsedTime=new Runnable()
					{
						public void run()
						{
							elapsedTimeT+=1;
							elapsedTimeP+=1;
							
							handler.postDelayed(this, 1000);
						}
					};
					
					Runnable resetElapsedTime=new TaskRunnable(task.getName(), task.getTime())
					{
						public void run()
						{
							elapsedTimeT=0;
							nameTV.setText(this.person);
						}
					};
					
					Runnable taskProgress=new TaskRunnable(task.getName(), task.getTime()){
						public void run()
						{
							
							int percentage=(this.time/elapsedTimeT);
							tpb.setProgress(percentage);
							handler.postDelayed(this, 1000);
						}
					};
					
					handler.postDelayed(elapsedTime, 1000);
					handler.postDelayed(resetElapsedTime, timeTot);
					handler.postDelayed(taskProgress, 1000+timeTot);
					
					timeTot+=task.getTime()*1000;
					
				}
				
				
				Runnable ppbTask=new Runnable(){
					public void run()
					{
						int percentage= (timeTot/1000)/elapsedTimeP;
						ppb.setProgress(percentage);
						
						handler.postDelayed(this, 1000);
						
					}
				};
				
				handler.postDelayed(ppbTask, 1000);
				
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
