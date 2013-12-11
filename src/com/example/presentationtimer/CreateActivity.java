package com.example.presentationtimer;
///nique
import java.util.ArrayList;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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
				task.setTime(Integer.parseInt(timeEdit.getText().toString()));

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
				String s=sauvegardeTask();
				Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
				Intent intent=new Intent(CreateActivity.this,MainActivity.class);
				startActivity(intent);
			}

			
		});
		
		
	}
	
	private String sauvegardeTask() {
		// TODO Auto-generated method stub
		String s="tache enregistrée";
		SQLiteBaseTimerTasks sql=new SQLiteBaseTimerTasks(this);
		
		Presentation ppt=new Presentation(1,"Projet");
		
		Person p1=new Person(1,"Dude1");
		Person p2=new Person(2,"Dude2");
		
		
		TaskDAO tDAO=new TaskDAO();
		Task t1=new Task(1,"Truc1", 60, 1, 1);
		Task t2=new Task(2,"Truc2", 60, 2, 1);
		
		tDAO.open(sql);
		tDAO.create(t1);
		tDAO.create(t2);
		tDAO.close();
		
		return s;
		
	}
}
