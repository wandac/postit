package com.example.postit.activity;

import com.example.postit.NotesAdapter;
import com.example.postit.R;
import com.example.postit.R.id;
import com.example.postit.R.layout;
import com.example.postit.R.menu;
import com.example.postit.R.string;

import android.os.Bundle;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class AddNoteActivity extends Activity implements OnClickListener {
	private final String LOG_TAG = "AddNoteActivity";
	
	// UI
	private EditText etTitle, etNote;
	private Button btnRemindMe;
	private TextView tvLastEdit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_add_note);
		
		etTitle = (EditText) findViewById(R.id.etTitle);
		
		etNote = (EditText) findViewById(R.id.etNote);
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
		
		btnRemindMe = (Button) findViewById(R.id.btnRemindMe);
		btnRemindMe.setOnClickListener(this);
		
		tvLastEdit = (TextView) findViewById(R.id.tvLastEdit);
		String lastEditText = getResources().getString(R.string.txt_edited);
		tvLastEdit.setText(lastEditText);
	}

	@Override
	protected void onResume() {
		super.onResume();
		
		// set focus on etNote and display keyboard
		etNote.requestFocus();
		
		etNote.postDelayed(new Runnable() {
            @Override
            public void run() {
                InputMethodManager keyboard = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
                keyboard.showSoftInput(etNote, 0);
            }
        },200);
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		Log.d(LOG_TAG, "onPause");
		// TODO: check that text has been entered
		// TODO: check that note is not added on orientation change but on leaving the activity
		NotesAdapter.addItem("", etNote.getText().toString());
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		
		Log.d(LOG_TAG, "onStop");
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		Log.d(LOG_TAG, "onDestroy");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.note, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_settings:
			Intent i = new Intent(this, SettingsActivity.class);
			startActivity(i);
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btnRemindMe:
			Log.d(LOG_TAG, "btnRemindMe onClick");
			break;

		default:
			break;
		}
	}

}
