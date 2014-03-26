package com.example.postit;

import java.util.ArrayList;

import com.example.postit.fragments.NotesFragment;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

//public class NotesAdapter extends BaseAdapter {
public class NotesAdapter extends SimpleCursorAdapter {
	private final static String LOG_TAG = "NotesAdapter";
	
	private Context context;
	private static ArrayList<NoteItem> data = new ArrayList<NoteItem>();
	
//	public NotesAdapter(Context c, ArrayList<NoteItem> notesArray) {
//		context = c;
//		data = notesArray;
//	}

//	public NotesAdapter(Context c) {
//		context = c;
//	}
	
	public NotesAdapter(Context myContext, int layout, Cursor c, String[] from,
			int[] to) {
		super(myContext, layout, c, from, to);
		
		context = myContext;
	}

//	@Override
//	public int getCount() {
//		return data.size();
//	}
//
//	@Override
//	public Object getItem(int position) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	public static void addItem(String title, String note) {
//		data.add(new NoteItem(title, note));
//		NotesFragment.notesAdapter.notifyDataSetChanged();
//	}
//	
//	@Override
//	public long getItemId(int position) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		NoteViewHolder holder;
//		
//		if(convertView == null) {
//			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
//			convertView = inflater.inflate(R.layout.note_item, parent, false);
//			
//			holder = new NoteViewHolder();
//			holder.tvNoteTitle = (TextView) convertView.findViewById(R.id.tvNoteTitle);
//			holder.tvNote = (TextView) convertView.findViewById(R.id.tvNote);
//			
//			convertView.setTag(holder);
//		}
//		else {
//			holder = (NoteViewHolder) convertView.getTag();
//		}
//		
//		if(!data.get(position).getTitle().equals("")) {
//			holder.tvNoteTitle.setText(data.get(position).getTitle());
//			holder.tvNoteTitle.setVisibility(View.VISIBLE);
//		}
//		else {
//			holder.tvNoteTitle.setVisibility(View.GONE);
//		}
//		
//		holder.tvNote.setText(data.get(position).getNote());
//		
//		return convertView;
//	}

}
