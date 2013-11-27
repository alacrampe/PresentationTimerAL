package com.example.presentationtimer;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class TaskAdapter extends ArrayAdapter<Task>{
		Context context;
		int layoutResourceId;    
	    ArrayList<Task> data= null;
		
		public TaskAdapter(Context context, int layoutResourceId, ArrayList<Task> data)
		{
			super(context, layoutResourceId, data);
			this.layoutResourceId = layoutResourceId;
	        this.context = context;
	        this.data = data;
		}
		
		public View getView(int position, View convertView, ViewGroup parent)
		{
			View row=convertView;
			TaskHolder holder=null;
			if(row==null)
			{
				LayoutInflater inflater=((Activity) context).getLayoutInflater();
				row=inflater.inflate(layoutResourceId, parent, false);
				
				holder=new TaskHolder();
				holder.name=(TextView) row.findViewById(R.id.name);
				holder.time=(TextView) row.findViewById(R.id.time);
				
				row.setTag(holder);
			}
			else
			{
				holder=(TaskHolder) row.getTag();
			}
			
			Task task=data.get(position);
			holder.name.setText(task.getName());
			holder.time.setText(""+task.getTime());
			
			return row;
		}
		
		public static class TaskHolder
		{
			public TextView name;
			public TextView time;
			public Button button;
		}
}


