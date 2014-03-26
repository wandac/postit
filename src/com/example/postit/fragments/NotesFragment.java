package com.example.postit.fragments;

import com.example.postit.NotesData;
import com.example.postit.PostItApplication;
import com.example.postit.R;

import android.app.Activity;
import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.SimpleCursorAdapter;

public class NotesFragment extends Fragment implements OnClickListener {
	private static final String LOG_TAG = "NotesFragment";
	PostItApplication postIt;
	
	// UI
	private EditText etAddQuickNote;
	private Button btnAddNote, btnAddList, btnAddPicture;
	private GridView gvNotes;
	
	private SimpleCursorAdapter notesAdapter;
	private Cursor cursor;
	
	private OnNoteSelectedListener mCallback;
	
	
	// Container activity must implement this interface
	public interface OnNoteSelectedListener {
		public void onNoteSelected(int position);
	} 

	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		// This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnNoteSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnNoteSelectedListener");
        }
	}
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_notes, container, false);
		
		postIt = (PostItApplication) getActivity().getApplication();
		
		
		etAddQuickNote = (EditText) rootView.findViewById(R.id.etQuickNote);
		etAddQuickNote.setOnClickListener(this);
		
		btnAddNote = (Button) rootView.findViewById(R.id.btnAddNote);
		btnAddNote.setOnClickListener(this);
		
		btnAddList = (Button) rootView.findViewById(R.id.btnAddList);
		btnAddList.setOnClickListener(this);
		
		btnAddPicture = (Button) rootView.findViewById(R.id.btnAddPicture);
		btnAddPicture.setOnClickListener(this);
		
		
		// Get the data
		cursor = postIt.getNotesData().query();
		getActivity().startManagingCursor(cursor);
		
		// Setup adapter
		String[] from = {NotesData.C_NOTE_TITLE, NotesData.C_NOTE_TEXT};
		int[] to = {R.id.tvNoteTitle, R.id.tvNote};
		gvNotes = (GridView) rootView.findViewById(R.id.gvNotes);
		notesAdapter = new SimpleCursorAdapter(this.getActivity(), R.layout.note_item, cursor, from, to);
		gvNotes.setAdapter(notesAdapter);
		
		gvNotes.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// Send the event to the host activity
		        mCallback.onNoteSelected(position);
			}
		});
		
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
