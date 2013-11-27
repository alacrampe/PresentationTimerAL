package com.example.presentationtimer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteBaseTimerTasks extends SQLiteOpenHelper{
	private static final int DATABASE_VERSION = 2;
	private static final String DATABASE_NAME = "extincteur";
	private Context context=null;
	
	public SQLiteBaseTimerTasks(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context=context;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		try {

			// si la base de données DATABASE_NAME n'existe pas déjà,
			// on lit le contenu du fichier eleves.sql (qui contient uniquement des ordres sql séparés par des ;
			// sans commentaires
			// puis on execute ses ordres (qui peremettent de créer des tables et d'insérer des données)

			InputStream isFichierSql = this.context.getResources().getAssets().open("presentations.sql");
			InputStreamReader isr = new InputStreamReader(isFichierSql);
			BufferedReader br = new BufferedReader(isr);

			String ligne;
			String ordresSql="";

			while ((ligne = br.readLine()) != null) {
				ligne = ligne.trim(); // enleve les espace en début et fin de ligne d'indentation
				ordresSql=ordresSql+ligne;
			}
			br.close();
			
			String[] instructionsSQL= ordresSql.split(";");
			for (String unOrdreSql : instructionsSQL) {
				db.execSQL(unOrdreSql);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		onCreate(db);
	}
	
	
	
}
