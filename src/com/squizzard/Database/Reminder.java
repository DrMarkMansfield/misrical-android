package com.squizzard.Database;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "reminders")
public class Reminder {
	
	@DatabaseField(generatedId=true)
	private int id;
	
	@DatabaseField
	private String reminderText;
	
	@DatabaseField
	private int day;
	
	@DatabaseField
	private int month;
		
		public Reminder(){
		}
		
		public Reminder(String reminderText, int day, int month){
			this.reminderText = reminderText;
			this.day = day;
			this.month = month;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getReminderText() {
			return reminderText;
		}

		public void setReminderText(String reminderText) {
			this.reminderText = reminderText;
		}

		public int getDay() {
			return day;
		}

		public void setDay(int day) {
			this.day = day;
		}

		public int getMonth() {
			return month;
		}

		public void setMonth(int month) {
			this.month = month;
		}
}
