package com.example.presentationtimer;

import java.util.ArrayList;




import android.content.ContentValues;
import android.database.Cursor;


public class TaskDAO extends DAO<Task>{

	private static final String TABLE_TASK = "Task";
	private static final String COL_ID = "id";
	private static final String COL_PERSONID = "person_id";
	private static final String COL_PRESID = "presentation_id";
	private static final String COL_NAME = "name";
	private static final String COL_TIMELENGTH = "timelength";



	public void open(SQLiteBaseTimerTasks be){
		//on ouvre la BDD en écriture
		this.bdd = be.getWritableDatabase();
	}
 
	public void close(){
		//on ferme l'accès à la BDD
		bdd.close();
	}
	@Override
	public Task get(long id) {
		Cursor c = bdd.query(false, TABLE_TASK, new String[] {COL_ID, COL_NAME, COL_TIMELENGTH,COL_PERSONID,COL_PRESID}, COL_ID + " =" + id , null, null, null, null, null);
		if (c.getCount() == 0) return null;
		c.moveToFirst();
		Task unTask = new Task(c.getInt(0), c.getString(1), c.getInt(2), c.getInt(3), c.getInt(4));
		c.close();

		return unTask;	
	}

	public ArrayList<Task> getAll() {
		Cursor c = bdd.query(TABLE_TASK, new String[] {COL_ID, COL_NAME, COL_TIMELENGTH,COL_PERSONID,COL_PRESID}, null , null, null, null, null);
		if (c.getCount() == 0) return null;
		ArrayList <Task> lesTasks = new ArrayList <Task>();
		 
		while(c.moveToNext())
        {
			Task unTask = new Task(c.getInt(0), c.getString(1), c.getInt(2), c.getInt(3), c.getInt(4));
			lesTasks.add(unTask);
        }
		c.close();
		return lesTasks;
	}


	@Override
	public Task create(Task obj) {
		// TODO Auto-generated method stub
		//Création d'un ContentValues (fonctionne comme une HashMap)
		ContentValues values = new ContentValues();

		//on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
		values.put(COL_NAME, obj.getName());
		values.put(COL_TIMELENGTH, obj.getTime());
		//on insère l'objet dans la BDD via le ContentValues
		long id = this.bdd.insert(TABLE_TASK, null, values);
		obj.setId(id) ;

		return obj;
	}

	@Override
	public Task update(Task obj) {
		// TODO Auto-generated method stub
		ContentValues values = new ContentValues();
		values.put(COL_NAME, obj.getName());
		values.put(COL_TIMELENGTH, obj.getTime());
		values.put(COL_PERSONID, obj.getPersonid());
		values.put(COL_PRESID, obj.getPresentationid());
		bdd.update(TABLE_TASK, values, COL_ID + " = " +obj.getId(), null);	

		return obj;
	}

	@Override
	public void delete(Task obj) {
		// TODO Auto-generated method stub
		bdd.delete(TABLE_TASK, COL_ID + " = " +obj.getId(), null);
	}
	

}
