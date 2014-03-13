package com.example.postit;

import android.app.Application;

public class PostItApplication extends Application {
	private final static String TAG = PostItApplication.class.getSimpleName();
	NotesData notesData;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		notesData = new NotesData(this);
	}
	
	@Override
	public void onTerminate() {
		super.onTerminate();
		notesData.close();
	}
	
	public NotesData getNotesData() {
		return notesData;
	}
}
