package com.squizzard.Reminder;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.squizzard.Database.DatabaseHelper;
import com.squizzard.Dialog.DatePickerFragment;
import com.squizzard.Dialog.MisiriDatePickerFragment;
import com.squizzard.MisriCalendar.Misri;
import com.squizzard.MisriCalendar.R;
import com.squizzard.util.DateUtil;

public class ReminderAdd extends ActionBarActivity implements DatePickerDialog.OnDateSetListener{

	private static final char TYPE_GREGORIAN = 'G';
	private static final char TYPE_MISRI = 'M';

	private EditText etReminder;
	private Button btnSetMisri;
	private Button btnSetGregorian;
	private FragmentManager fragmentManager;
	private RadioButton rbGregorian;
	private RadioButton rbMisri;
	private TextView tvGregorian;
	private TextView tvMisri;
	private Misri dateConverter;
	private int saveGregorianDay=0;
	private int saveGregorianMonth=0;
	private int saveMisriDay=0;
	private int saveMisriMonth=0;
	private DatabaseHelper databaseHelper;
	private int reminderId = -1;
	private Reminder savedReminder = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reminder_add);

		etReminder = (EditText)findViewById(R.id.reminder_add_title);
		btnSetMisri = (Button)findViewById(R.id.reminder_add_misri_set);
		btnSetGregorian = (Button)findViewById(R.id.reminder_add_gregorian_set);
		btnSetMisri.setOnClickListener(buttonClickListener);
		btnSetGregorian.setOnClickListener(buttonClickListener);
		rbGregorian = (RadioButton)findViewById(R.id.gregorian_radio_button);
		rbGregorian.setChecked(false);
		rbMisri = (RadioButton)findViewById(R.id.misri_radio_button);
		rbMisri.setChecked(false);
		tvGregorian = (TextView)findViewById(R.id.reminder_add_gregorian_text);
		tvMisri = (TextView)findViewById(R.id.reminder_add_misri_text);

		reminderId = getIntent().getIntExtra(ReminderDisplay.REMINDER_ID, -1);
		if(reminderId != -1){
			savedReminder = getHelper().getReminder(reminderId);
			if(savedReminder != null){
				etReminder.setText(savedReminder.getReminderText());
				tvGregorian.setText(savedReminder.getGregorianDateText());
				tvMisri.setText(savedReminder.getMisriDateText());
				saveGregorianDay = savedReminder.getGregorianDay();
				saveGregorianMonth = savedReminder.getGregorianMonth();
				saveMisriDay = savedReminder.getMisriDay();
				saveMisriMonth = savedReminder.getMisriMonth();
				if(savedReminder.getType() == TYPE_GREGORIAN){
					rbGregorian.setChecked(true);
				}else{
					rbMisri.setChecked(true);
				}
			}
		}

		dateConverter = new Misri();
		fragmentManager = getSupportFragmentManager();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu_individual_reminder, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.reminder_save:
	        	if(etReminder.getText().toString().trim().length() <= 0){
					etReminder.setError(getString(R.string.reminder_add_text_empty));
				}else if(saveGregorianDay == 0 || saveGregorianMonth == 0 || saveMisriDay ==  0 || saveMisriMonth == 0){
					AlertDialog.Builder builder = new AlertDialog.Builder(ReminderAdd.this);
					builder.setTitle(getString(R.string.reminder_add_incomplete_title));
					builder.setMessage(R.string.reminder_add_incomplete_message);
					builder.setPositiveButton(getString(R.string.word_ok), new DialogInterface.OnClickListener() {
				           public void onClick(DialogInterface dialog, int id) {
				              dialog.dismiss();
				           }
				       });
					builder.show();
				}
				else{
					char type = TYPE_GREGORIAN;
					if(rbMisri.isChecked()){
						type = TYPE_MISRI;
					}
					if(reminderId == -1){
						Reminder reminder = new Reminder(etReminder.getText().toString(), saveGregorianDay, saveGregorianMonth, saveMisriDay, saveMisriMonth, 0, 0,type);
						getHelper().saveReminder(reminder);
					}else{
						savedReminder.setReminderText(etReminder.getText().toString());
						savedReminder.setGregorianDay(saveGregorianDay);
						savedReminder.setGregorianMonth(saveGregorianMonth);
						savedReminder.setMisriDay(saveMisriDay);
						savedReminder.setMisriMonth(saveMisriMonth);
						savedReminder.setType(type);
						getHelper().saveReminder(savedReminder);
					}
					
				    finish();
				}
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	private OnClickListener buttonClickListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			switch(v.getId()){
			case R.id.reminder_add_gregorian_set:
				new DatePickerFragment().show(getSupportFragmentManager(), "datePicker");
				break;
			case R.id.reminder_add_misri_set:
				MisiriDatePickerFragment misriDatePicker = MisiriDatePickerFragment.newInstance();
				misriDatePicker.show(fragmentManager, "misri_date_picker_fragment");
				break;
			}	
		}
	};


	@Override
	public void onDateSet(DatePicker datePicker, int year, int month, int day) {
		//get the date back and display both date strings based on a prior conversion to Gregorian
		if(datePicker != null){//this is a standard date picker
			rbGregorian.setChecked(true);
			tvGregorian.setText(DateUtil.getGregorianDateString(day, month));
			int [] misriArray = dateConverter.getMisriDate(day, month, year);
			tvMisri.setText(DateUtil.getMisriDateString(misriArray[0], misriArray[1]));
			saveGregorianDay = day;
			saveGregorianMonth = month+1;
			saveMisriDay = misriArray[0];
			saveMisriMonth = misriArray[1];
		}
		else{
			rbMisri.setChecked(true);
			tvMisri.setText(DateUtil.getMisriDateString(day, month));
			int[] gregorianDateArray =  dateConverter.getGregorianDate(day, month-1, year);
			tvGregorian.setText(DateUtil.getGregorianDateString(gregorianDateArray[0], gregorianDateArray[1]));
			saveGregorianDay = gregorianDateArray[0];
			saveGregorianMonth = gregorianDateArray[1];
			saveMisriDay = day;
			saveMisriMonth = month;
		}
	}

	protected DatabaseHelper getHelper() {
		if (databaseHelper == null) {
			databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
		}
		return databaseHelper;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (databaseHelper != null) {
			OpenHelperManager.releaseHelper();
			databaseHelper = null;
		}
	}
	
	//TODO catch back button press and check if fields are filled. If so, ask to save
}
