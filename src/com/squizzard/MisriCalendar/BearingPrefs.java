package com.squizzard.MisriCalendar;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
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
	private Button testButton;
	private NotificationManager notificationManager;
	private int icon = R.drawable.ic_launcher1;
	private Preference alertPreference;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bearinginfo);
		addPreferencesFromResource(R.xml.settings);
		providerText = (TextView) findViewById(R.id.provider);
		meccaBearingText = (TextView) findViewById(R.id.meccaBearing);
		testButton = (Button)findViewById(R.id.miqaatTestButton);
		testButton.setOnClickListener(this);
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

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.miqaatTestButton:
			long now = System.currentTimeMillis();
			Notification notification = new Notification(icon, getString(R.string.test_miqaat_text), now);
			notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
			Intent testNotificationIntent = new Intent(Attributes.TEST_MIQAAT_INTENT);
			PendingIntent testPendingIntent = PendingIntent.getActivity(this, 0, testNotificationIntent, 0);
			notification.setLatestEventInfo(this, getString(R.string.test_miqaat_text), getString(R.string.miqaat_alerts_functioning_correctly), testPendingIntent);
			notification.flags = Notification.FLAG_AUTO_CANCEL; 
			notificationManager.notify(Attributes.TEST_NOTIFICATION, notification);
			break;
		}
	}
}
