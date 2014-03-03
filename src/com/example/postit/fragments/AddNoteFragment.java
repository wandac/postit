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
import android.widget.TextView;

public class AddNoteFragment extends Fragment implements OnClickListener {
	private static final String LOG_TAG = "AddNoteFragment"; 
	// UI
	private EditText etTitle, etNote;
	private Button btnAddToMyNotes, btnRemindMe;
	private TextView tvLastEdit;
	
	
	// TODO: really? o_O
	public AddNoteFragment() {
        // Empty constructor required for fragment subclasses
    }
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {		
		View rootView = inflater.inflate(R.layout.fragment_add_note, container, false);
		
		
		etTitle = (EditText) rootView.findViewById(R.id.etTitle);
		etNote = (EditText) rootView.findViewById(R.id.etNote);
		btnAddToMyNotes = (Button) rootView.findViewById(R.id.btnAddToMyNotes);
		btnRemindMe = (Button) rootView.findViewById(R.id.btnRemindMe);
		tvLastEdit = (TextView) rootView.findViewById(R.id.tvLastEdit);
		
		btnAddToMyNotes.setOnClickListener(this);
		btnRemindMe.setOnClickListener(this);
		
		String lastEditText = getResources().getString(R.string.txt_edited);
		tvLastEdit.setText(lastEditText);

		
		return rootView;
	}
	
	
	@Override
	public void onPause() {
		super.onPause();
	}
	

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btnAddToMyNotes:
			addToMyNotes();
			break;
			
		case R.id.btnRemindMe:
			break;

		default:
			break;
		}
	}


	private void addToMyNotes() {
		String title = "", note = "";
		
		title = etTitle.getText().toString();
		note = etNote.getText().toString();
		
		if(!note.equals("")) {
			// TODO: delete text from edit text
			NotesAdapter.addItem(title, note);
		}
		else {
			// TODO: add toast msg
			Log.d(LOG_TAG, "nothing to add here");
		}
	}

}
