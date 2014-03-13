package com.example.postit;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class NotesData {
	private static final String TAG = NotesData.class.getSimpleName();
	public final static String C_ID = BaseColumns._ID;
	public final static String C_NOTE_TITLE = "note_title";
	public final static String C_NOTE_TEXT = "note_text";
	
	Context context;
	DbHelper dbHelper;
	
	public NotesData(Context context) {
		this.context = context;
		dbHelper = new DbHelper();
	}
	
	public void close() {
		dbHelper.close();
	}
	
	
	/**
	 * Inserts into database
	 * @param values
	 */
	public void insert(ContentValues values) {
		// Open Database
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		
		// Insert into database
		db.insert(DbHelper.TABLE, null, values);
		//					db.insertWithOnConflict(DbHelper.TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE);
		
		// Close Database
		db.close();
	}
	
	
	public void insert(String title, String note) {
		// Create content values
		ContentValues values = new ContentValues();
		values.put(NotesData.C_NOTE_TITLE, title);
		values.put(NotesData.C_NOTE_TEXT, note);
		
		this.insert(values);
	}
	
	
	/**
	 * Deletes All the data
	 */
	public void delete() {
		// Open Database
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		
		// Delete the data
		db.delete(DbHelper.TABLE, null, null);
		
		// Close Database
		db.close();
	}
	
	/**
	 * Class to help open/create/upgrade database
	 */
	private class DbHelper extends SQLiteOpenHelper {
		public final static String DB_NAME = "postit.db";
		public final static int DB_VERSION = 1;
		public final static String TABLE = "notes";
//		public final static String C_ID = BaseColumns._ID;
//		public final static String C_NOTE_TITLE = "note_title";
//		public final static String C_NOTE_TEXT = "note_text";
		
		public DbHelper() {
			super(context, DB_NAME, null, DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			String sql = String.format(
					"create table %s (%s INT primary key, %s TEXT, %s TEXT)", TABLE, 
					C_ID, C_NOTE_TITLE, C_NOTE_TEXT);
			
			Log.d(TAG, "onCreate sql: " + sql);
			
			db.execSQL(sql);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO change this to alter table
			db.execSQL("drop table if exists" + TABLE);
			Log.d(TAG, "onUpgrade dropped table " + TABLE);
			this.onCreate(db);
		}

	}


}
