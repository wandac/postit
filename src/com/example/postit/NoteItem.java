package com.example.postit;

public class NoteItem {
	private String title = "", note = "";
	
	public NoteItem(String t, String n) {
		setTitle(t);
		setNote(n);
	}
	
	public void setTitle(String t) {
		title = t;
	}
	public String getTitle() {
		return title;
	}
	
	public void setNote(String n) {
		this.note = n;
	}
	public String getNote() {
		return this.note;
	}

}
