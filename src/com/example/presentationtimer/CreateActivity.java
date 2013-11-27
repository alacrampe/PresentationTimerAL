package com.example.presentationtimer;

import java.util.ArrayList;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class CreateActivity extends Activity{
	
	private ArrayList<TimerTask> tasks;
	
	public EditText nameEdit;
	public EditText timeEdit;
	public Button addButton;
	public Button createButton;
	public ListView taskList;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_create);
		
		nameEdit=(EditText) this.findViewById(R.id.Name);
		timeEdit=(EditText) this.findViewById(R.id.Time);
		addButton=(Button) this.findViewById(R.id.AddTask);
		createButton=(Button) this.findViewById(R.id.Submit);
		
		taskList=(ListView) this.findViewById(R.id.TaskList);
	}
}
