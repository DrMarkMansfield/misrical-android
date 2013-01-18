package com.squizzard.MisriCalendar;

//Changes
//12 November 2011 V1.02 Fix for Hirji turn of decade

import java.io.File;
import java.util.Calendar;
import com.squizzard.MisriCalendar.BearingPrefs.BearingOptions;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuInflater; 
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CalendarConvert extends Activity implements OnClickListener, SensorEventListener, LocationListener{//make the location listener into an inner class

	static final int DATE_DIALOG_ID=0;
	static final int MISRI_DIALOG_ID=1;
	static Dialog returnDialog;
	private TextView setGregorianButton; 
    private TextView setMisriButton;
	private TextView[] weekdayButtons = new TextView[7];//monButton, tueButton, wedButton, thuButton, friButton, satButton, sunButton;
	static TextView misriText;
	static TextView eventText;
	private TextView bearingText;
	private TextView bearingField;
	static TextView gregorianText;
	private TextView setTodayButton;
	private ImageView arrowImageNorth;
	private ImageView arrowImageMecca;
	private Misri dateConverter;
	private Calendar c;
	float startRotateNorth;
	float endRotateNorth;
	float startRotateMecca;
	float endRotateMecca;
	private GeomagneticField geoField;
	private Location location;
	private LocationManager locMgr;
	private Criteria locationCriteria;
	private Sensor magneticSensor;
	private Sensor accelerometerSensor;
	private SensorManager sensorManager;
	private float[] accelerometerValues;
	private float[] magneticValues;
	private float declination;
	private Display display;	
	private BearingOptions bearingOptions = null;
	static final String TAG = "DebugCalendarConvert";
	private SharedPreferences sharedPreferences;
	private OnSharedPreferenceChangeListener onSharedPreferenceChangeListener;
	private Location mecca;
	private String bearingToMeccaString;
	private String providerString;
	private View dayPlusButton;
	private View dayMinusButton;
	File dir = Environment.getExternalStorageDirectory();


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		misriText = (TextView)findViewById(R.id.convertedDate);
		eventText = (TextView)findViewById(R.id.eventText);
		bearingText = (TextView)findViewById(R.id.bearingMode);
		bearingField = (TextView)findViewById(R.id.bearing);
		gregorianText = (TextView)findViewById(R.id.dateGregorian);
		setGregorianButton=(TextView)findViewById(R.id.setGregorianButton);
		setMisriButton=(TextView)findViewById(R.id.setMisriButton);
		setGregorianButton.setOnClickListener(this);
		setMisriButton.setOnClickListener(this);
		setTodayButton = (TextView)findViewById(R.id.todayButton);
		setTodayButton.setOnClickListener(this);
		dayPlusButton=findViewById(R.id.dayPlusButton);
		dayPlusButton.setOnClickListener(this);
		dayMinusButton=findViewById(R.id.dayMinusButton);
		dayMinusButton.setOnClickListener(this);
		arrowImageNorth = (ImageView)findViewById(R.id.arrow_icon_north);
		arrowImageMecca = (ImageView)findViewById(R.id.arrow_icon_mecca);
		dateConverter = new Misri();
		mecca = new Location("mecca");
		mecca.setLatitude(21.427);
		mecca.setLongitude(39.814);
		weekdayButtons[0] =  (TextView) findViewById(R.id.sunButton);
		weekdayButtons[1] = (TextView) findViewById(R.id.monButton);
		weekdayButtons[2] = (TextView) findViewById(R.id.tueButton);
		weekdayButtons[3] = (TextView) findViewById(R.id.wedButton);
		weekdayButtons[4] = (TextView) findViewById(R.id.thuButton);
		weekdayButtons[5] = (TextView) findViewById(R.id.friButton);
		weekdayButtons[6] = (TextView) findViewById(R.id.satButton);
		c = Calendar.getInstance();
		highLightDay(c);
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);   
		accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		magneticSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
		locationCriteria=new Criteria();
		locationCriteria.setBearingRequired(true);
		locationCriteria.setAccuracy(Criteria.ACCURACY_FINE);
		locMgr = (LocationManager) getSystemService(LOCATION_SERVICE);
		//setGregorianText(todayDay, todayMonth, todayYear);//set gregorian date
		//setMisriText(todayDay,todayMonth,todayYear);//will set the text in the misri textbox
		setGregorianText(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));//set gregorian date
		setMisriText(c.get(Calendar.DAY_OF_MONTH),c.get(Calendar.MONTH),c.get(Calendar.YEAR));//will set the text in the misri textbox
		startRotateNorth=endRotateNorth=startRotateMecca=endRotateMecca=0;
		
		
		onSharedPreferenceChangeListener = new OnSharedPreferenceChangeListener(){

			public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
				bearingOptions = BearingPrefs.getBearingMode(getApplicationContext());
				if(bearingOptions == BearingOptions.ON_TOUCH){
					setBearingText(getResources().getString(R.string.bearing_updates_touch));
					//point arrows north  endRotationNorth/Mecca=0
					makeRotation(arrowImageNorth, true);
					makeRotation(arrowImageMecca, true);
				}
				if(bearingOptions == BearingOptions.OFF){ 
					setBearingText(getResources().getString(R.string.bearing_updates_off));
					//point the arrow north: endRotationNorth/Mecca=0 
					makeRotation(arrowImageNorth, true);
					makeRotation(arrowImageMecca, true);
					bearingField.setText(getResources().getString(R.string.bearing_off));
				}
				if(bearingOptions == BearingOptions.ALWAYS_ON){
					setBearingText(getResources().getString(R.string.bearing_updates_auto));
				}
			}
		};
		sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
		bearingOptions = BearingPrefs.getBearingMode(getApplicationContext());

		if(bearingOptions == BearingOptions.ON_TOUCH){
			setBearingText(getResources().getString(R.string.bearing_updates_touch));
			bearingField.setText("Touch");
		}
		if(bearingOptions == BearingOptions.OFF){ 
			setBearingText(getResources().getString(R.string.bearing_updates_off));
			bearingField.setText(getResources().getString(R.string.bearing_off));
		}
		if(bearingOptions == BearingOptions.ALWAYS_ON){
			setBearingText(getResources().getString(R.string.bearing_updates_auto));
		}

		arrowImageNorth.setOnTouchListener(new OnTouchListener()
		{
			public boolean onTouch(View arg0, MotionEvent arg1) {
				if((bearingOptions != null) && (bearingOptions == BearingOptions.ON_TOUCH)){
					makeRotation(arrowImageNorth, false);
					makeRotation(arrowImageMecca, false);
				}
				return false;
			}	
		}
		);//end touch listener

		arrowImageMecca.setOnTouchListener(new OnTouchListener()
		{
			public boolean onTouch(View arg0, MotionEvent arg1) {
				if((bearingOptions != null) && (bearingOptions == BearingOptions.ON_TOUCH)){
					makeRotation(arrowImageMecca, false);
					makeRotation(arrowImageNorth, false);
				}
				return false;
			}	
		}
		);//end touch listener
	} //end onCreate()

	private void highLightDay(Calendar c2) {
		//what day is today
		int today = c2.get(Calendar.DAY_OF_WEEK);//Sunday is 1
		for(int d=0;d<7;d++){
			if(d==today-1){
				weekdayButtons[d].setBackgroundColor(getResources().getColor(R.color.todayButton));
			}
			else weekdayButtons[d].setBackgroundColor(getResources().getColor(R.color.notTodayButton));
		}
	}

	@Override
	protected void onResume(){
		super.onResume();
		location=null;
		bearingToMeccaString="";
		
		//register the sensors
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE); 
		sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensorManager.registerListener(this, magneticSensor, SensorManager.SENSOR_DELAY_NORMAL);
		//get the latest location from the best sensor
		locMgr.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1, this);
		//locMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, this);
		ConnectivityManager connectivityMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
	
        NetworkInfo network = connectivityMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		NetworkInfo wifi = connectivityMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

		providerString = "No Location Available";
		
		if(location==null && network!=null){
			
			if(network.isConnected()){
			location = locMgr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
			providerString = network.getExtraInfo();
			if(providerString.equals("No Provider Connection")||providerString==null||providerString.equals("")){
				providerString="NETWORK";
			}
			}
		}
		
		if(location==null && locMgr.isProviderEnabled(LocationManager.GPS_PROVIDER)){
			location = locMgr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			if (location!=null) {providerString = "GPS";}
		}
		
		if(location==null && wifi.isConnected()) {
			providerString="WIFI";
			location = locMgr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		}
		if(location!=null){
			arrowImageMecca.setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.DARKEN);
			getGeomagneticField();
			bearingToMeccaString=Float.toString(Math.round(location.bearingTo(mecca)));
		}
		else{
			bearingToMeccaString = "Unavailable";
			Toast toast = Toast.makeText(getApplicationContext(), "Mecca pointer disabled. Enable Network/WIFI/GPS to determine location.", Toast.LENGTH_SHORT);
			toast.show();
			LightingColorFilter lcf = new LightingColorFilter( 0x44555555, 0); 
			arrowImageMecca.setColorFilter(lcf);
		}
	}

	private void setBearingText(String text){
		bearingText.setText(text);
	}

	public void onClick(View v) {
		switch(v.getId()){
		case R.id.setGregorianButton: 
			showDialog(DATE_DIALOG_ID);
			//Toast toast = Toast.makeText(getApplicationContext(), "MisriCal+ with reverse conversion is now available from Google Play", Toast.LENGTH_SHORT);
			//toast.show();
			break;
			
		case R.id.setMisriButton: 
			showDialog(MISRI_DIALOG_ID);
			break;

		case R.id.dayPlusButton:
			c.add(Calendar.DAY_OF_MONTH, 1);
			highLightDay(c);
			setGregorianText(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
			setMisriText(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
			break;

		case R.id.dayMinusButton:
			c.add(Calendar.DAY_OF_MONTH, -1);
			highLightDay(c);
			setGregorianText(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
			setMisriText(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
			break;

		case R.id.todayButton:
			c = Calendar.getInstance();
			//setMisriText(todayDay, todayMonth, todayYear);
			//setGregorianText(todayDay, todayMonth, todayYear);
			setGregorianText(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
			setMisriText(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
			//c.set(todayYear, todayMonth, todayDay);
			highLightDay(c);
		}
	}

	private void setMisriText(int dayOfMonth, int monthOfYear, int year) {
		misriText.setText(dateConverter.getMisriDate(year, monthOfYear, dayOfMonth));
		eventText.setText(dateConverter.getTodayEvent());
	}

	private void setGregorianText(int dayOfMonth, int monthOfYear, int year){
		gregorianText.setText(dateConverter.convertGregorian(dayOfMonth, monthOfYear, year));//convertGregorian has jan at 0
		eventText.setText(dateConverter.getTodayEvent());
	}

	private DatePickerDialog.OnDateSetListener mDateSetListener = 
		new DatePickerDialog.OnDateSetListener(){
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			if((year>1900) && (year<2077)){//V1.02 limit dates to be from 1900 and 2077
				c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
				c.set(Calendar.MONTH, monthOfYear);
				c.set(Calendar.YEAR, year);
				highLightDay(c);
				setGregorianText(dayOfMonth, monthOfYear, year);
				//call the method to convert from Gregorian to Misri
				setMisriText(dayOfMonth, monthOfYear, year);
			}
			else{//V1.02 limit dates to be from 1900 and 2077
				Toast toast = Toast.makeText(getApplicationContext(), "1900 < YEAR < 2077" , Toast.LENGTH_LONG);
				toast.show();
			}
		}

	};
	protected Dialog onCreateDialog(int id){
		switch(id){
		case DATE_DIALOG_ID:
			c = Calendar.getInstance();
			returnDialog =  new DatePickerDialog(this, mDateSetListener, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
			break;
		case MISRI_DIALOG_ID:
			returnDialog = new MisriDialog(this, dateConverter);
			returnDialog.setOnDismissListener(new DialogInterface.OnDismissListener(){
		        @Override
		        public void onDismiss(DialogInterface dialog) {
		        	c.set(Calendar.DAY_OF_MONTH, dateConverter.getConvertedGregorianDay());
					c.set(Calendar.MONTH, dateConverter.getConvertedGregorianMonth());
					c.set(Calendar.YEAR, dateConverter.getConvertedGregorianYear());
					highLightDay(c);
		        }
		        });
			break;
		}
		return returnDialog;
	}
	//Menu processing methods
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		super.onCreateOptionsMenu(menu);
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.quit:
			finish();
			return true;
		case R.id.miqaat: 
			startActivity(new Intent(this, Miqaat.class));
			return true;
		case R.id.about:
			startActivity(new Intent(this, About.class));
			return true;
		case R.id.bearings:
			Intent bearingOptionIntent = new Intent(this, BearingPrefs.class);
			bearingOptionIntent.putExtra("PROVIDER", providerString);
			bearingOptionIntent.putExtra("BEARING_TO_MECCA", bearingToMeccaString);
			//bearingOptionIntent.putExtra("ACCURACY", accuracyString);
			startActivity(bearingOptionIntent);
			return true;
		case R.id.share:
			Intent intent = new Intent(android.content.Intent.ACTION_SEND);
			intent.setType("text/*");
			intent.putExtra(android.content.Intent.EXTRA_TEXT, "Android app for converting between Misri and Gregorian dates: \nhttps://market.android.com/details?id=com.squizzard.MisriCalendar");
			intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "MisriCal - calendar conversion for Andorid");
			startActivity(Intent.createChooser(intent, "Share via"));
		default: 
		}
		return false;
	}

	//Rotation and sensor methods

	private void makeRotation(ImageView image, boolean defaultNorth){
		float[] R = new float[16];
		float[] I = new float[16];
		float[] remappedMatrix = new float[16];
		float[] actual_orientation = new float[3];
	try{
		SensorManager.getRotationMatrix(R, I, accelerometerValues, magneticValues);
		display = getWindowManager().getDefaultDisplay();
		int phoneRotation = display.getOrientation();

		if(phoneRotation==0){//portrait
			SensorManager.remapCoordinateSystem(R, SensorManager.AXIS_X, SensorManager.AXIS_Y, remappedMatrix);
		}
		if(phoneRotation==1){//landscape facing left
			SensorManager.remapCoordinateSystem(R, SensorManager.AXIS_Y, SensorManager.AXIS_MINUS_X, remappedMatrix);
		}
		if(phoneRotation==3){//landscape facing right
			SensorManager.remapCoordinateSystem(R, SensorManager.AXIS_MINUS_Y, SensorManager.AXIS_X, remappedMatrix);
		}

		SensorManager.getOrientation(remappedMatrix, actual_orientation);
		//values[0]: Azimuth, rotation around the Z axis (0<=azimuth<360). 0 = North, 90 = East, 180 = South, 270 = West
		float azi = (float)Math.toDegrees(actual_orientation[0]);

		if(declination>=0){
			azi-=declination;//positive declination means the magnetic field is rotated east that much from true north. if its positive subtract it, negative then add it
		}
		else azi+=declination;//need to do an azimuth conversion.
		int aziDisplay = (int)azi;//for display purposes
		if(aziDisplay<0){
			aziDisplay = 180 + (180 + aziDisplay);
		}

		bearingField.setText(Integer.toString(aziDisplay));
		endRotateNorth = -azi;//this is endRotate is north 
		if(image.equals(arrowImageNorth)){
			if(defaultNorth) endRotateNorth=0;
			RotateAnimation rotateAnimation = new RotateAnimation(startRotateNorth, endRotateNorth, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
			rotateAnimation.setDuration((long) 500);
			rotateAnimation.setFillAfter(true);
			image.startAnimation(rotateAnimation);
			startRotateNorth=endRotateNorth;
		}
		if(image.equals(arrowImageMecca)){
			if(location!=null){
				endRotateMecca = endRotateNorth + location.bearingTo(mecca);}
			if(defaultNorth || bearingToMeccaString.equals("Unavailable")) endRotateMecca=0;
			RotateAnimation rotateAnimation = new RotateAnimation(startRotateMecca, endRotateMecca, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
			rotateAnimation.setDuration((long) 500);
			rotateAnimation.setFillAfter(true);
			image.startAnimation(rotateAnimation);
			startRotateMecca=endRotateMecca;
		}
	}catch(NullPointerException e){
		
	}
	
	}

	@Override
	protected void onPause(){
		super.onPause();
		//disable sensors
		sensorManager.unregisterListener(this, accelerometerSensor);
		sensorManager.unregisterListener(this, magneticSensor);
		//stop receiving location updates
		locMgr.removeUpdates(this);
	}

	@Override
	protected void onStop(){
		super.onStop();

	}


	private void getGeomagneticField() {
		try{
			geoField = new GeomagneticField(
					Double.valueOf(location.getLatitude()).floatValue(),
					Double.valueOf(location.getLongitude()).floatValue(),
					Double.valueOf(location.getAltitude()).floatValue(),
					System.currentTimeMillis());
			declination = geoField.getDeclination();//positive means the magnetic field is rotated east that much from true north
		}catch(NullPointerException npe){}
	}

	public void onSensorChanged(SensorEvent event){
		bearingOptions = BearingPrefs.getBearingMode(getApplicationContext());

		if((bearingOptions != null) && (bearingOptions != BearingOptions.OFF)){
			switch(event.sensor.getType()){
			case(Sensor.TYPE_ACCELEROMETER):
				accelerometerValues = event.values.clone();
			break;
			case(Sensor.TYPE_MAGNETIC_FIELD):
				magneticValues = event.values.clone();
			//	accuracyString = event.accuracy;
			break;
			}
			if(bearingOptions == BearingOptions.ALWAYS_ON && magneticValues!=null && accelerometerValues!=null){				
				makeRotation(arrowImageNorth, false);
				if(bearingToMeccaString.equals("Unavailable")){
					makeRotation(arrowImageMecca, true);
				}else
					makeRotation(arrowImageMecca, false);
			}	
		}
	}

	public void onLocationChanged(Location newLocation) {
		if(location==null){//location has become available for the first time
			Toast toast = Toast.makeText(this.getApplicationContext(), "Location established. Mecca pointer active!", Toast.LENGTH_SHORT);
			toast.show();
			arrowImageMecca.setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.DARKEN);
		}
		location=newLocation;
		bearingToMeccaString=Float.toString(Math.round(location.bearingTo(mecca)));
	}

	public void onProviderDisabled(String provider) {
	}

	public void onProviderEnabled(String provider) {
		providerString = provider;
	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		//3 Accuracy high 2 low 1 medium 0 unreliable
	}
}