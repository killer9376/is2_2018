package com.is2.pol.una.projectmanagment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "ScrumManager.db";
	
    //Tables name
    private static final String TABLE_USER = "user";
	private static final String TABLE_PROYECT = "proyect";
    private static final String TABLE_ACTIVITY = "activity";
    private static final String TABLE_SPRINT = "sprint";

    // User Table Columns names
	//USER
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";
	//PROYECT
	private static final String COLUMN_PROYECT_ID = "proyect_id";
    private static final String COLUMN_PROYECT_NAME = "proyect_name";
	private static final String COLUMN_PROYECT_YEAR = "proyect_year";
    private static final String COLUMN_PROYECT_DATE_START = "proyect_date_start";
    private static final String COLUMN_PROYECT_DATE_FINISH = "proyect_date_finish";
	private static final String COLUMN_PROYECT_LEADER = "proyect_leader";
	private static final String COLUMN_PROYECT_STATUS = "proyect_status";
	//ACTIVITY
	private static final String COLUMN_ACTIVITY_ID = "activity_id";
    private static final String COLUMN_ACTIVITY_NAME = "activity_name";
    private static final String COLUMN_ACTIVITY_ID_PROYECT = "activity_id_proyect";
	private static final String COLUMN_ACTIVITY_ORDER = "activity_order";
    private static final String COLUMN_ACTIVITY_STATUS = "activity_status";
	//SPRINT
	private static final String COLUMN_SPRINT_ID = "sprint_id";
    private static final String COLUMN_SPRINT_ID_ACTIVITY = "sprint_id_activity";
	private static final String COLUMN_SPRINT_NAME = "sprint_name";
    private static final String COLUMN_SPRINT_DESCRIPTION = "sprint_description";
    private static final String COLUMN_SPRINT_DURATION = "sprint_duration";
	private static final String COLUMN_SPRINT_DATE_START = "sprint_date_start";
	private static final String COLUMN_SPRINT_DATE_FINISH = "sprint_date_finish";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";
			
	private String CREATE_PROYECT_TABLE = "CREATE TABLE " + TABLE_PROYECT + "("
            + COLUMN_PROYECT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_PROYECT_NAME + " TEXT,"
            + COLUMN_PROYECT_YEAR + " TEXT," + COLUMN_PROYECT_DATE_START + " TEXT,"
			+ COLUMN_PROYECT_DATE_FINISH + " TEXT," + COLUMN_PROYECT_LEADER + "INTEGER," 
			+ COLUMN_PROYECT_STATUS + "TEXT )";

    private String CREATE_ACTIVITY_TABLE = "CREATE TABLE " + TABLE_ACTIVITY + "("
            + COLUMN_ACTIVITY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_ACTIVITY_NAME + " TEXT,"
            + COLUMN_ACTIVITY_ID_PROYECT + " INTEGER," + COLUMN_ACTIVITY_ORDER + " INTEGER,"
            + COLUMN_ACTIVITY_STATUS  + " TEXT" + ")";

    private String CREATE_SPRINT_TABLE = "CREATE TABLE " + TABLE_SPRINT + "("
            + COLUMN_SPRINT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_SPRINT_ID_ACTIVITY + " INTEGER,"
            + COLUMN_SPRINT_NAME + " TEXT," + COLUMN_SPRINT_DESCRIPTION + " TEXT,"
            + COLUMN_SPRINT_DURATION + " TEXT," + COLUMN_SPRINT_DATE_START + "INTEGER,"
            + COLUMN_SPRINT_DATE_FINISH + "TEXT )";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;
	private String DROP_PROYECT_TABLE = "DROP TABLE IF EXISTS " + TABLE_PROYECT;
    private String DROP_ACTIVITY_TABLE = "DROP TABLE IF EXISTS " + TABLE_PROYECT;
    private String DROP_SPRINT_TABLE = "DROP TABLE IF EXISTS " + TABLE_PROYECT;

    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
		db.execSQL(CREATE_PROYECT_TABLE);
		db.execSQL(CREATE_ACTIVITY_TABLE);
		db.execSQL(CREATE_SPRINT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop Tables if exist
        db.execSQL(DROP_USER_TABLE);
		db.execSQL(DROP_PROYECT_TABLE);
        db.execSQL(DROP_ACTIVITY_TABLE);
        db.execSQL(DROP_SPRINT_TABLE);

        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public void addProyect(Proyect proyect) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_PROYECT_NAME, proyect.getProyect_name());
        values.put(COLUMN_PROYECT_YEAR, proyect.getProyect_year());
        values.put(COLUMN_PROYECT_DATE_START, proyect.getProyect_date_start());
        values.put(COLUMN_PROYECT_DATE_FINISH, proyect.getProyect_date_finish());
        values.put(COLUMN_PROYECT_LEADER, proyect.getProyect_leader());
        values.put(COLUMN_PROYECT_STATUS, proyect.getProyect_status());

        // Inserting Row
        db.insert(TABLE_PROYECT, null, values);
        db.close();
    }

    public void addActivity(Activity activity) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ACTIVITY_NAME, activity.getName());
        values.put(COLUMN_ACTIVITY_ID_PROYECT, activity.getId_proyect());
        values.put(COLUMN_ACTIVITY_ORDER, activity.getOrder());
        values.put(COLUMN_ACTIVITY_STATUS, activity.getStatus());

        // Inserting Row
        db.insert(TABLE_ACTIVITY, null, values);
        db.close();
    }

    public void addSprint(Sprint sprint) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_SPRINT_ID, sprint.getId());
        values.put(COLUMN_SPRINT_ID_ACTIVITY, sprint.getId_activity());
        values.put(COLUMN_SPRINT_NAME, sprint.getName());
        values.put(COLUMN_SPRINT_DESCRIPTION, sprint.getDescription());
        values.put(COLUMN_SPRINT_DURATION, sprint.getDuration());
        values.put(COLUMN_SPRINT_DATE_START, sprint.getDate_start());
        values.put(COLUMN_SPRINT_DATE_FINISH, sprint.getDate_finish());

        // Inserting Row
        db.insert(TABLE_SPRINT, null, values);
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_EMAIL,
                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    public List<Proyect> getAllProyect() {
        // array of columns to fetch
        String[] columns = {
            COLUMN_PROYECT_ID,
            COLUMN_PROYECT_NAME,
            COLUMN_PROYECT_YEAR,
            COLUMN_PROYECT_DATE_START,
            COLUMN_PROYECT_DATE_FINISH,
            COLUMN_PROYECT_LEADER,
            COLUMN_PROYECT_STATUS
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<Proyect> proyectList = new ArrayList<Proyect>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns, null, null,null,
                null, sortOrder);

        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Proyect proyect = new Proyect();
                proyect.setProyect_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_PROYECT_ID))));
                proyect.setProyect_name(cursor.getString(cursor.getColumnIndex(COLUMN_PROYECT_NAME)));
                proyect.setProyect_year(cursor.getString(cursor.getColumnIndex(COLUMN_PROYECT_YEAR)));
                proyect.setProyect_date_start(cursor.getString(cursor.getColumnIndex(COLUMN_PROYECT_DATE_START)));
                proyect.setProyect_date_finish(cursor.getString(cursor.getColumnIndex(COLUMN_PROYECT_DATE_FINISH)));
                proyect.setProyect_leader(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_PROYECT_LEADER))));
                proyect.setProyect_status(cursor.getString(cursor.getColumnIndex(COLUMN_PROYECT_STATUS)));
                proyectList.add(proyect);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return proyectList;
    }

    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    public void updateProyect(Proyect proyect) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_PROYECT_NAME, proyect.getProyect_name());
        values.put(COLUMN_PROYECT_DATE_START, proyect.getProyect_date_start());
        values.put(COLUMN_PROYECT_DATE_FINISH, proyect.getProyect_date_finish());
        values.put(COLUMN_PROYECT_LEADER, proyect.getProyect_leader());
        values.put(COLUMN_PROYECT_STATUS, proyect.getProyect_status());

        // Updating Row
        db.update(TABLE_PROYECT, values, COLUMN_PROYECT_ID + " = ?",
                new String[]{String.valueOf(proyect.getProyect_id())});
        db.close();
    }

    public void updateActivity(Activity activity) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ACTIVITY_NAME, activity.getName());
        values.put(COLUMN_ACTIVITY_ORDER, activity.getOrder());
        values.put(COLUMN_ACTIVITY_STATUS, activity.getStatus());

        //Updating Row
        db.update(TABLE_ACTIVITY, values, COLUMN_ACTIVITY_ID + " = ?",
                new String[]{String.valueOf(activity.getId())});
        db.close();
    }

    public void updateSprint(Sprint sprint) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_SPRINT_NAME, sprint.getName());
        values.put(COLUMN_SPRINT_DESCRIPTION, sprint.getDescription());
        values.put(COLUMN_SPRINT_DURATION, sprint.getDuration());
        values.put(COLUMN_SPRINT_DATE_START, sprint.getDate_start());
        values.put(COLUMN_SPRINT_DATE_FINISH, sprint.getDate_finish());

        // Inserting Row
        db.insert(TABLE_SPRINT, null, values);
        db.close();
    }

    /**
     * This method is to delete user record
     *
     * @param user
     */
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    public void deleteActivity(Activity activity) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete activity record by id
        db.delete(TABLE_ACTIVITY, COLUMN_ACTIVITY_ID + " = ?",
                new String[]{String.valueOf(activity.getId())});
        db.close();
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */
    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @param password
     * @return true/false
     */
    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}