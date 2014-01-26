package com.squizzard.MisriCalendar;

import com.squizzard.util.DateUtil;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver{
	private NotificationManager notificationManager;
	private int icon = R.drawable.ic_launcher1;
	private Misri m  = new Misri();
		
	@SuppressWarnings("deprecation")
	@Override
	public void onReceive(Context context, Intent intent) {
		String mAction = intent.getAction();
		String todayMisri = m.getTodayMisri();
		int todayNumber = m.getMisriOrdinal();
		
		if(mAction.equals(Attributes.MORNING_CHECK_MIQAAT_INTENT)){//check for today
			if(DateUtil.priorityEventMap.containsKey(todayNumber)){
		    long now = System.currentTimeMillis();
		    String contentTitle[] =  DateUtil.priorityEventMap.get(todayNumber);
		    notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
			Intent notificationIntent = new Intent(Attributes.NOTIFICATION_INTENT);
			PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
			Notification notification = new Notification(icon, contentTitle[0], now);//just show the icon in the notification with no text		
			notification.setLatestEventInfo(context, contentTitle[0], todayMisri, contentIntent);
			notification.flags = Notification.FLAG_AUTO_CANCEL; 
			notificationManager.notify(Attributes.ALARM_NOTIFICATION, notification);
			}	
		}
		else if(mAction.equals(Attributes.EVENING_CHECK_MIQAAT_INTENT)){//check for tomorrow
			if(DateUtil.priorityEventMap.containsKey(todayNumber+1)){
			    long now = System.currentTimeMillis();
			    String contentTitle[] =  DateUtil.priorityEventMap.get(todayNumber+1);
			    notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
				Intent notificationIntent = new Intent(Attributes.NOTIFICATION_INTENT);
				PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
				Notification notification = new Notification(icon, contentTitle[0], now);//just show the icon in the notification with no text		
				notification.setLatestEventInfo(context, contentTitle[0], m.getTomorrowMisri(), contentIntent);
				notification.flags = Notification.FLAG_AUTO_CANCEL; 
				notificationManager.notify(Attributes.ALARM_NOTIFICATION, notification);
			}
		}
	
	}
}
