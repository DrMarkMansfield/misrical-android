package com.squizzard.MisriCalendar;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.squizzard.Database.DatabaseHelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BearingPrefs extends PreferenceActivity implements OnClickListener {

	public enum BearingOptions{ON_TOUCH, ALWAYS_ON, OFF};
	private TextView meccaBearingText;
	private TextView providerText;
	private Button btnCheckToday;
	private Button btnCheckTomorrow;
	private Preference alertPreference;
	private DatabaseHelper databaseHelper = null;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bearinginfo);
		addPreferencesFromResource(R.xml.settings);
		providerText = (TextView) findViewById(R.id.provider);
		meccaBearingText = (TextView) findViewById(R.id.meccaBearing);
		btnCheckToday = (Button)findViewById(R.id.miqaatCheckToday);
		btnCheckToday.setOnClickListener(this);
		btnCheckTomorrow = (Button)findViewById(R.id.miqaatCheckTomorrow);
		btnCheckTomorrow.setOnClickListener(this);
		providerText.setText(getIntent().getStringExtra("PROVIDER"));
		meccaBearingText.setText(getIntent().getStringExtra("BEARING_TO_MECCA"));
		alertPreference = getPreferenceManager().findPreference(Attributes.MIQAATS_ALERT_PREFERENCE);

		alertPreference.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				boolean alertsEnabled = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean(Attributes.MIQAATS_ALERT_PREFERENCE, false);
				if(alertsEnabled){
					AlarmCoordinator.turnOnAlarms(getApplicationContext());
				}
				else{
					AlarmCoordinator.turnOffAlarms(getApplicationContext());
				}
				return true;
			}
		});
	}

	public static BearingOptions getBearingMode(Context context){
		String prefString = PreferenceManager.getDefaultSharedPreferences(context).getString("listPref", "1");//Default to first in list
		int i = Integer.valueOf(prefString);
		BearingOptions retVal = null;
		switch(i){
		case 1:
			retVal = BearingOptions.ALWAYS_ON;
			break;
		case 2:
			retVal =  BearingOptions.ON_TOUCH;
			break;
		case 3: 
			retVal =  BearingOptions.OFF;
			break;
		}
		return retVal;
	}

	public static boolean miqaatAlertsEnabled(Context context){
		return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(context.getString(R.string.miqaat_alert_preference), false);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.miqaatCheckToday:
			Intent morningEventIntent= new Intent(Attributes.MORNING_CHECK_MIQAAT_INTENT);
			sendBroadcast(morningEventIntent);	
			break;
		case R.id.miqaatCheckTomorrow:
			Intent eveningEventIntent= new Intent(Attributes.EVENING_CHECK_MIQAAT_INTENT);
			sendBroadcast(eveningEventIntent);
			break;
		}
	}
	
	protected DatabaseHelper getHelper() {
		if (databaseHelper == null) {
			databaseHelper = OpenHelperManager.getHelper(getApplicationContext(), DatabaseHelper.class);
		}
		return databaseHelper;
	}
}
