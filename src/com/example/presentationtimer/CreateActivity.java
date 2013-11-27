package com.example.presentationtimer;

import java.util.ArrayList;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class CreateActivity extends Activity{
	
//	private ArrayList<TimerTask> tasks;
	
	public EditText nameEdit;
	public EditText timeEdit;
	public Button addButton;
	public Button createButton;
	public ListView taskList;
	
	
	public ArrayList<Task> tasks;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_create);
		
		nameEdit=(EditText) this.findViewById(R.id.Name);
		timeEdit=(EditText) this.findViewById(R.id.Time);
		addButton=(Button) this.findViewById(R.id.AddTask);
		createButton=(Button) this.findViewById(R.id.Submit);
		
		taskList=(ListView) this.findViewById(R.id.TaskList);
		
		tasks=new ArrayList<Task>();
		
		
		TaskAdapter adapter=new TaskAdapter(this, R.layout.task_list_item, tasks);
		taskList.setAdapter(adapter);
		
		addButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Task task=new Task();

				task.setName(nameEdit.getText().toString());
				task.setTime(Long.parseLong(timeEdit.getText().toString()));

				tasks.add(task);
				TaskAdapter adapter=new TaskAdapter(v.getContext(), R.layout.task_list_item, tasks);
				taskList.setAdapter(adapter);
				adapter.notifyDataSetChanged();
				
				
				
			}
		});
		
		createButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
	}
}
