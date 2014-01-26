package com.squizzard.Database;

import java.sql.SQLException;
import java.util.ArrayList;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.squizzard.MisriCalendar.R;
import com.squizzard.Reminder.Reminder;

	
	public class DatabaseHelper extends OrmLiteSqliteOpenHelper{
		
		private static final String DATABASE_NAME = "misrical.db";
		private static final int DATABASE_VERSION = 1;
		
		private RuntimeExceptionDao<Reminder, Integer> reminderRuntimeDao = null;
		
		public DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
		}
		
		@Override
		public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
			try {
				Log.i(DatabaseHelper.class.getName(), "Database Creation");
				TableUtils.createTable(connectionSource, Reminder.class);				
			} catch (SQLException e) {
				Log.e(DatabaseHelper.class.getName(), "Cannot create database", e);
				throw new RuntimeException(e);
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion,int newVersion) {}
		
		public RuntimeExceptionDao<Reminder, Integer> getReminderDao() {
			if (reminderRuntimeDao == null) {
				reminderRuntimeDao = getRuntimeExceptionDao(Reminder.class);
			}
			return reminderRuntimeDao;
		}
		
		public Reminder getReminder(long id){
			ArrayList<Reminder> reminder = (ArrayList<Reminder>) getReminderDao().queryForEq("id", id);
			if(reminder.size()==1){
				return reminder.get(0);
			}else{
				return null;
			}
		}
		
		public ArrayList<Reminder> getReminders(){
			ArrayList<Reminder> reminders = (ArrayList<Reminder>) getReminderDao().queryForAll();
			return reminders;
		}
		
		public boolean deleteReminder(int id){
			DeleteBuilder<Reminder, Integer> deleteBuilder = getReminderDao().deleteBuilder();
			try {
				deleteBuilder.where().eq("id", id);
				getReminderDao().delete(deleteBuilder.prepare());
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		public boolean saveReminders(ArrayList<Reminder> reminders){
			for(Reminder reminder: reminders){
				saveReminder(reminder);
			}
			return true;
		}
		
		public void saveReminder(Reminder reminder){
			getReminderDao().createOrUpdate(reminder);
		}
		
		@Override
		public void close() {
			super.close();
			reminderRuntimeDao = null;
		}
}
