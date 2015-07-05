package com.example.owner.attendance_tracker.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Owner on 6/16/2015.
 */
public class UserHelper extends SQLiteOpenHelper {

    private static final int db_version = 1;
    private static final String db_name = "attendance.db";
    private static final String table_name = "login";

    private static final String email = "email";
    private static final String password = "password";
    private static final String userId = "userId";
    private static final String create_table = "create table " +table_name+ "(" +userId+ " Integer primary key autoincrement, " +email+ " varchar(20) not null, " +password+" varchar(20) not null )";
    private static final String stud_name = "stud_name";
    private static final String parent_name = "parent_name";
    private static final String address = "address";
    private static final String stud_id = "stud_id";
    private static final String mobile = "mobile";
    private static String table_name_stud = "student";
    private static final String create_table_stud = "create table " +table_name_stud+ "("+stud_id+" Integer primary key autoincrement, "+stud_name+ " text not null, " +parent_name+ " text not null," +mobile+" Integer not null, " +address+" text not null)";



    public UserHelper(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

      //  String query = "drop table " +table_name ;
        sqLiteDatabase.execSQL(create_table);
        sqLiteDatabase.execSQL(create_table_stud);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

       sqLiteDatabase.execSQL("drop table " +table_name+" if exists");
       sqLiteDatabase.execSQL("drop table" +table_name_stud);
       onCreate(sqLiteDatabase);
    }

    public UserDetails insertUser(UserDetails queryValues){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(email,queryValues.email);
        values.put(password,queryValues.password);
        queryValues.userId = db.insert(table_name, null, values);
        db.close();
        return queryValues;
    }

  /*  public int updatePassword(UserDetails queryValues){
       // insertUser(queryValues);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email",queryValues.email);
        values.put("password",queryValues.password);
        queryValues.userId = db.insert(table_name, null, values);
        db.close();
        return db.update("user",values,"userId = ?", new String[] {String.valueOf(queryValues.userId)});

    }*/

    public UserDetails getUser(String mail) {
        String query = "select "+userId+ "," +password+  " from "+table_name+ " where "  +email+ " =  '"+mail+"' ";
        UserDetails users = new UserDetails(0, mail, "");
        SQLiteDatabase db = this.getReadableDatabase();
        //db.execSQL("drop table user");
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {

                users.userId = cursor.getLong(0);
                users.password = cursor.getString(1);
            }while (cursor.moveToNext()) ;

        }
        db.close();

       return users;

    }

        public long insertStudent(String name, String parents_name, String mob, String addr){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(stud_name,name);
        values.put(parent_name,parents_name);
        values.put(mobile,mob);
        values.put(address, addr);
        return db.insert(table_name_stud,null,values);
        // db.close();
    }

      /*  public String getStudent(long Stud_id){
            String query = "select"
        }*/

}
