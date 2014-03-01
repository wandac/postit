package com.example.postit.fragments;


import com.example.postit.NotesAdapter;
import com.example.postit.R;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class AddNoteFragment extends Fragment implements OnClickListener {
	private static final String LOG_TAG = "AddNoteFragment"; 
	// UI
	private EditText etTitle, etNote;
	private Button btnRemindMe;
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
//		etNote.setFocusable(true);
		etNote.setOnClickListener(this);
		
		etNote.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				Log.d(LOG_TAG, "etNote onFocusChange");
//				NotesActivity.addNoteToNotesArray(new NoteItem("", etNote.getText().toString()));
//				NotesAdapter.addItem("", etNote.getText().toString());
//				Log.d(LOG_TAG, etNote.getText().toString());
//				Log.d(LOG_TAG, ((EditText) v).getText().toString());
//				NotesAdapter.addItem("", "from AddNoteActivity");
				if(!hasFocus) {
					Log.d(LOG_TAG, "et has no focus");
				}
			}
		});
		
		etNote.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				// TODO Auto-generated method stub
				if(actionId == EditorInfo.IME_ACTION_DONE) {
					
				}
				return false;
			}
		});
		
		btnRemindMe = (Button) rootView.findViewById(R.id.btnRemindMe);
		btnRemindMe.setOnClickListener(this);
		
		tvLastEdit = (TextView) rootView.findViewById(R.id.tvLastEdit);
		String lastEditText = getResources().getString(R.string.txt_edited);
		tvLastEdit.setText(lastEditText);

		
		return rootView;
	}
	
	
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		// TODO: check that text has been entered
		// TODO: check that note is not added on orientation change but on leaving the activity
		NotesAdapter.addItem("", etNote.getText().toString());
	}
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
