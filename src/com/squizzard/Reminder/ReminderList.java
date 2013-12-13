package com.squizzard.Reminder;

import com.squizzard.MisriCalendar.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ReminderList extends Activity{
	
	private Button btnAddReminder;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reminder_list);
		btnAddReminder = (Button)findViewById(R.id.reminder_list_add_button);
		btnAddReminder.setOnClickListener(buttonClickListener);
	
	}
	
	private OnClickListener buttonClickListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			switch(v.getId()){
			case R.id.reminder_list_add_button:
				Intent addReminderIntent = new Intent(getApplicationContext(), ReminderAdd.class);
				startActivity(addReminderIntent);
				break;
			}	
		}
	};
}
