package com.squizzard.Reminder;

import java.util.ArrayList;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.squizzard.Database.DatabaseHelper;
import com.squizzard.MisriCalendar.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ReminderList extends ActionBarActivity{
	private ListView listView;
	private ReminderAdapter adapter;
	private ArrayList<Reminder> reminders;
	private DatabaseHelper databaseHelper;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.reminder_list);
		
		listView = (ListView)findViewById(R.id.reminder_list);
		adapter = new ReminderAdapter();
		reminders = getHelper().getReminders();
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(listClickListener);
	}
	
	private OnItemClickListener listClickListener = new OnItemClickListener(){

	    @Override
	    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	    	Reminder reminder = (Reminder) v.getTag();
	    	if(reminder != null){
	    		Intent displayReminderIntent = new Intent(ReminderList.this, ReminderDisplay.class);
	    		displayReminderIntent.putExtra(ReminderDisplay.REMINDER_ID, reminder.getId());
	    		startActivity(displayReminderIntent);
	    	}
	    }       
	};
	
	
	
	@Override 
	public void onResume(){
		super.onResume();
		if(adapter != null){
			reminders = getHelper().getReminders();
			adapter.notifyDataSetChanged();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		super.onCreateOptionsMenu(menu);
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu_reminder_list, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
        case android.R.id.home: 
            onBackPressed();
            break;
		case R.id.reminder_list_add:
			Intent addReminderIntent = new Intent(getApplicationContext(), ReminderAdd.class);
			startActivity(addReminderIntent);
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private class ReminderAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return reminders.size();
		}

		@Override
		public Reminder getItem(int position) {
			return reminders.get(position);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = convertView;
			if(convertView == null){
				LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
		        view = inflater.inflate(R.layout.reminder_list_item, null);
			}
			
			Reminder reminder = getItem(position);
			if(reminder != null){
				((TextView)view.findViewById(R.id.reminder_item_text)).setText(reminder.getReminderText());
				((TextView)view.findViewById(R.id.reminder_item_misri_text)).setText(reminder.getMisriDateText());
				((TextView)view.findViewById(R.id.reminder_item_gregorian_text)).setText(reminder.getGregorianDateText());
				view.setTag(reminder);
			}
			return view;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

	  }
	
	protected DatabaseHelper getHelper() {
		if (databaseHelper == null) {
			databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
		}
		return databaseHelper;
	}
}
