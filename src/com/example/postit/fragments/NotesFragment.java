package com.example.postit.fragments;

import com.example.postit.NotesAdapter;
import com.example.postit.R;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

public class NotesFragment extends Fragment implements OnClickListener {
	private static final String LOG_TAG = "NotesFragment";
	
	// UI
	private EditText etAddQuickNote;
	private Button btnAddNote, btnAddList, btnAddPicture;
	private GridView gvNotes;
	
	public static NotesAdapter notesAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_notes, container, false);
		
		
		etAddQuickNote = (EditText) rootView.findViewById(R.id.etQuickNote);
		etAddQuickNote.setOnClickListener(this);
		
		btnAddNote = (Button) rootView.findViewById(R.id.btnAddNote);
		btnAddNote.setOnClickListener(this);
		
		btnAddList = (Button) rootView.findViewById(R.id.btnAddList);
		btnAddList.setOnClickListener(this);
		
		btnAddPicture = (Button) rootView.findViewById(R.id.btnAddPicture);
		btnAddPicture.setOnClickListener(this);
		
		gvNotes = (GridView) rootView.findViewById(R.id.gvNotes);
		notesAdapter = new NotesAdapter(this.getActivity());
		gvNotes.setAdapter(notesAdapter);
		
		
		return rootView;
	}
	
	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onClick(View view) {
		switch(view.getId()) {
		case R.id.etQuickNote:
			Log.d(LOG_TAG, "etQuickNote");
			break;

		case R.id.btnAddNote:
			Log.d(LOG_TAG, "btnAddNote");
			break;

		case R.id.btnAddList:
			Log.d(LOG_TAG, "btnAddList");
			break;

		case R.id.btnAddPicture:
			Log.d(LOG_TAG, "btnAddPicture");
			break;

		default:
			Log.d(LOG_TAG, "default");
			break;
		}
	}
}
