package com.squizzard.MisriCalendar;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Miqaat extends ListActivity{
	
	final static String[] months = new String[] {"Moharram-al-Haraam","Safar-al-Muzaffar","Rabi-al-Awwal","Rabi-al-Aakhar",
			"Jumada-al-Ulaa","Jamada-al-Ukhra","Rajab-al-Asab","Shaban-al-Karim","Ramadan-al-Moazzam",
			"Shawwal-al-Mukarram","Zilqad-al-Haraam","Zilhajj-al-Haraam"};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.miqaat_month_display);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.miqaat_month_row, R.id.text1, months);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		int intItem = (int)id;
		Intent miqaatMonthIntent = new Intent(this, MiqaatMonthView.class);
		miqaatMonthIntent.putExtra("MONTH", intItem);
		startActivity(miqaatMonthIntent);
	}
}
