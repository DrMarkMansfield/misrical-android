package com.squizzard.MisriCalendar;

import android.app.Activity;
import android.content.Intent;
//import android.net.Uri;
//import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class About extends Activity implements OnClickListener{

	private TextView emailButton;
	//private TextView webButton;
	final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		emailButton = (TextView) findViewById(R.id.emailButton);
		emailButton.setOnClickListener(this);
	//	webButton = (TextView) findViewById(R.id.webButton);
	//	webButton.setOnClickListener(this);
	}

	@SuppressWarnings("deprecation")
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.emailButton:
			//launch an email intent

			String messageString = "\n\n\n\n OS Version: " + System.getProperty("os.version");
			messageString += "\n OS API Level: " + android.os.Build.VERSION.SDK;
			messageString += "\n Device: " + android.os.Build.DEVICE;
			messageString += "\n Model : " + android.os.Build.MODEL;
			messageString += "\n Display: " + android.os.Build.DISPLAY;
			messageString += "\n Manufacturer: " + android.os.Build.MANUFACTURER;
			emailIntent.setType("plain/text");
			emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"ouikka@gmail.com"});
			emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "MisriCal "+ getString(R.string.app_version));
			emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, messageString);
			startActivity(Intent.createChooser(emailIntent, "Send mail..."));
			break;
			//To be replaced when there is a website
		/*case R.id.webButton:
			Uri uri = Uri.parse(getResources().getString(R.string.ouikka_url));
			Intent webIntent = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(webIntent);	
			break;*/
		}	
	}
}
