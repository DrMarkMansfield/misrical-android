package com.squizzard.Reminder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.squizzard.MisriCalendar.R;

public class ReminderAdd extends Activity{

	private TextView reminderText;
	private Button btnSetMisri;
	private Button btnSetGregorian;
	private Button btnSaveReminder;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reminder_add);
		
		reminderText = (TextView)findViewById(R.id.reminderEditText);
		btnSetMisri = (Button)findViewById(R.id.reminder_add_misri_set);
		btnSetGregorian = (Button)findViewById(R.id.reminder_add_gregorian_set);
		btnSaveReminder = (Button)findViewById(R.id.reminder_add_save);
		btnSetMisri.setOnClickListener(buttonClickListener);
		btnSetGregorian.setOnClickListener(buttonClickListener);
		btnSaveReminder.setOnClickListener(buttonClickListener);
	}
	
	private OnClickListener buttonClickListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			switch(v.getId()){
			case R.id.reminder_add_gregorian_set:
				break;
			case R.id.reminder_add_misri_set:
				break;
			case R.id.reminder_add_save:
				break;
			}	
		}
	};
}
