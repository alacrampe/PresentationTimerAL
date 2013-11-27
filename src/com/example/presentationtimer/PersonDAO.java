package com.example.presentationtimer;

import java.util.ArrayList;




import android.content.ContentValues;
import android.database.Cursor;


public class PersonDAO extends DAO<Person>{

	private static final String TABLE_PERSON = "Person";
	private static final String COL_ID = "id";
	private static final String COL_NAME = "name";



	public void open(SQLiteBaseTimerTasks be){
		//on ouvre la BDD en écriture
		this.bdd = be.getWritableDatabase();
	}
 
	public void close(){
		//on ferme l'accès à la BDD
		bdd.close();
	}
	@Override
	public Person get(long id) {
		Cursor c = bdd.query(false, TABLE_PERSON, new String[] {COL_ID, COL_NAME}, COL_ID + " =" + id , null, null, null, null, null);
		if (c.getCount() == 0) return null;
		c.moveToFirst();
		Person unPerson = new Person(c.getInt(0), c.getString(1));
		c.close();

		return unPerson;	
	}

	public ArrayList<Person> getAll() {
		Cursor c = bdd.query(TABLE_PERSON, new String[] {COL_ID, COL_NAME}, null , null, null, null, null);
		if (c.getCount() == 0) return null;
		ArrayList <Person> lesPersons = new ArrayList <Person>();
		 
		while(c.moveToNext())
        {
			Person unPerson = new Person(c.getInt(0), c.getString(1));
			lesPersons.add(unPerson);
        }
		c.close();
		return lesPersons;
	}


	@Override
	public Person create(Person obj) {
		// TODO Auto-generated method stub
		//Création d'un ContentValues (fonctionne comme une HashMap)
		ContentValues values = new ContentValues();

		//on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
		values.put(COL_NAME, obj.getName());
		//on insère l'objet dans la BDD via le ContentValues
		long id = this.bdd.insert(TABLE_PERSON, null, values);
		obj.setId(id) ;

		return obj;
	}

	@Override
	public Person update(Person obj) {
		// TODO Auto-generated method stub
		ContentValues values = new ContentValues();
		values.put(COL_NAME, obj.getName());
		bdd.update(TABLE_PERSON, values, COL_ID + " = " +obj.getId(), null);	

		return obj;
	}

	@Override
	public void delete(Person obj) {
		// TODO Auto-generated method stub
		bdd.delete(TABLE_PERSON, COL_ID + " = " +obj.getId(), null);
	}
	

}
