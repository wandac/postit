package com.example.postit;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

//public class NotesAdapter extends BaseAdapter {
public class NotesAdapter extends BaseAdapter {
	private final static String LOG_TAG = "NotesAdapter";
	
	private Context context;
	private static ArrayList<NoteItem> data = new ArrayList<NoteItem>();
	
//	public NotesAdapter(Context c, ArrayList<NoteItem> notesArray) {
//		context = c;
//		data = notesArray;
//	}

	public NotesAdapter(Context c) {
		context = c;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void addItem(String title, String note) {
		data.add(new NoteItem(title, note));
	}
	
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		NoteViewHolder holder;
		
		if(convertView == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			convertView = inflater.inflate(R.layout.note_item_text, parent, false);
//			convertView = new TextView(context);
			
			holder = new NoteViewHolder();
			holder.tvNote = (TextView) convertView.findViewById(R.id.tvNote);
//			holder.tvNote = (TextView) convertView;
			
			convertView.setTag(holder);
		}
		else {
			holder = (NoteViewHolder) convertView.getTag();
		}
		
//		TextView tvNote = (TextView) convertView.findViewById(R.id.tvNote);
//		tvNote.setText(data.get(position).getNote());
		holder.tvNote.setText(data.get(position).getNote());
//		Log.d(LOG_TAG, "position: " + String.valueOf(position));
//		Log.d(LOG_TAG, "note: " + String.valueOf(data.get(position).getNote()));
		
		return convertView;
	}

}
