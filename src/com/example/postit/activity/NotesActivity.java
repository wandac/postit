package com.example.postit.activity;

import java.util.Arrays;
import java.util.List;

import com.example.postit.R;
import com.example.postit.fragments.AddNoteFragment;
import com.example.postit.fragments.NotesFragment;
import com.example.postit.fragments.NotesFragment.OnNoteSelectedListener;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class NotesActivity extends Activity implements OnNoteSelectedListener {
	private final String LOG_TAG = "NotesActivity";
	
	// UI
	private DrawerLayout drawerLayout;
	private ListView drawerList;
	private ActionBarDrawerToggle drawerToggle;
	
	private String[] mainMenuTitles;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notes_new);
		
		mainMenuTitles = getResources().getStringArray(R.array.main_menu);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawerList = (ListView) findViewById(R.id.left_drawer);
		
		// set a custom shadow that overlays the main content when the drawer opens
        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		// Set the adapter for ListView
		drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mainMenuTitles));
		// Set the list's click listener
		drawerList.setOnItemClickListener(new DrawerItemClickListener());
		
		// enable ActionBar app icon to behave as action to toggle nav drawer
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        
        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        drawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                drawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
                ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(R.string.app_name);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(R.string.app_name);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	/**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }
	
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        drawerToggle.onConfigurationChanged(newConfig);
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notes, menu);
		return true;
	}
	
	/* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = drawerLayout.isDrawerOpen(drawerList);
        menu.findItem(R.id.action_search).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		if (drawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		
		// Handle action buttons
		switch(item.getItemId()) {
		case R.id.action_settings:
			Intent intent = new Intent(this, SettingsActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	
	/* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }
	
    
	private void selectItem(int position) {
		List<String> menuTitlesList = Arrays.asList(mainMenuTitles);
		
		int myMoviesPosition = menuTitlesList.indexOf(getResources().getString(R.string.txt_my_notes));
		int addQuickNotePosition = menuTitlesList.indexOf(getResources().getString(R.string.txt_add_quick_note));
		int addNotePosition = menuTitlesList.indexOf(getResources().getString(R.string.txt_add_note));
		int addPicturePosition = menuTitlesList.indexOf(getResources().getString(R.string.txt_add_picture));
		
		Fragment fragment = null;
		
		
        // update the main content by replacing fragments
        if(position == myMoviesPosition) {
        	fragment = new NotesFragment();
        }
        else if(position == addQuickNotePosition) {
        	fragment = new AddNoteFragment();
        }
        else if (position == addNotePosition) {
        	fragment = new AddNoteFragment();
		}
        else if (position == addPicturePosition) {
        	fragment = new AddNoteFragment();
		}
        
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        
        // update selected item and title, then close the drawer
        drawerList.setItemChecked(position, true);
        setTitle(mainMenuTitles[position]);
        drawerLayout.closeDrawer(drawerList);
    }

	@Override
	public void onNoteSelected(int position) {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG, String.valueOf(position) + " note selected");
	}

}
