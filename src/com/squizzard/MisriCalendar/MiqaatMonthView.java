package com.squizzard.MisriCalendar;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MiqaatMonthView extends ListActivity {

	private ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
	private TextView monthDisplay;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.miqaat_event_display);
		int month =  getIntent().getIntExtra("MONTH", 0);
		monthDisplay = (TextView)findViewById(R.id.monthDisplay);
		monthDisplay.setText(Miqaat.months[month]);
		HashMap<String,String> valuesMap;
		//determine start and end days for displaying events
		int eventsStart = 0, eventsEnd = 0;
		eventsStart=Misri.misri_month[month]+1;
		if(month<11){
		eventsEnd=Misri.misri_month[month+1]+1;}
		else eventsEnd=355;


		for(int x=eventsStart;x<eventsEnd;x++){
			if(Misri.priorityEventMap.containsKey(x)){
				String arr[] = Misri.priorityEventMap.get(x);
				for(int y=0;y<arr.length;y++){
					valuesMap = new HashMap<String,String>();
					valuesMap.put( "date","*" + Integer.toString(x-eventsStart+1));
					valuesMap.put( "event", arr[y]);
					list.add(valuesMap);
				}
			}
			if(Misri.eventMap.containsKey(x)){
				String arr2[] = Misri.eventMap.get(x);
				for(int y=0;y<arr2.length;y++){
					valuesMap = new HashMap<String,String>();
					valuesMap.put( "date", Integer.toString(x-eventsStart+1));
					valuesMap.put( "event",arr2[y]);
					list.add(valuesMap);
				}

			}			
		}

		SimpleAdapter adapter = new SimpleAdapter( 
				this, list, R.layout.miqaat_event_row, new String[] { "event","date" }, new int[] { R.id.event, R.id.date });

		setListAdapter(adapter);
	}
}
