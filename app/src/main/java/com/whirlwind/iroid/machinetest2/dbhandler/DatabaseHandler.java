package com.whirlwind.iroid.machinetest2.dbhandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.whirlwind.iroid.machinetest2.model.Iroid;

import java.util.ArrayList;
import java.util.List;

import static com.whirlwind.iroid.machinetest2.RegistrationActivity.metRegisterAge;
import static com.whirlwind.iroid.machinetest2.RegistrationActivity.metRegisterName;
import static com.whirlwind.iroid.machinetest2.RegistrationActivity.metRegisterPhone;
import static com.whirlwind.iroid.machinetest2.RegistrationActivity.metRegisterPlace;
import static com.whirlwind.iroid.machinetest2.RegistrationActivity.metRegisterQualification;

/**
 * Created by Acer on 27-Jul-17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "iroidManager";
    private static final String TABLE_IROID = "iroid";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PLACE = "place";
    private static final String KEY_AGE = "age";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_QUALIFICATION = "qualification";

    int id = 0;
    int _id = id + 1;


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_IROID_TABLE = "CREATE TABLE " + TABLE_IROID + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_PLACE + " TEXT," + KEY_AGE + " TEXT,"
                + KEY_PHONE + " TEXT," + KEY_QUALIFICATION + " TEXT" + ")";

        db.execSQL(CREATE_IROID_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + TABLE_IROID);

        onCreate(db);
    }


    public void addIroid(Iroid iroid) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, iroid.getId());
        //String.valueOf(metRegisterName.getText().toString())  was the second argument , but now no need.
        values.put(KEY_NAME, iroid.getName());
        values.put(KEY_PLACE, iroid.getPlace());
        values.put(KEY_AGE, iroid.getAge());
        values.put(KEY_PHONE, iroid.getPhone());
        values.put(KEY_QUALIFICATION, iroid.getQualification());


        db.insert(TABLE_IROID, null, values);

        db.close();
    }


    // Edited for the third activity.

   public Iroid getIroid(String passingName) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_IROID, new String[]{KEY_NAME, KEY_PLACE,
                        KEY_AGE, KEY_PHONE, KEY_QUALIFICATION}, KEY_NAME + "=?",
                new String[]{String.valueOf(passingName)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Iroid iroid = new Iroid(_id, cursor.getString(1),
                cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));

        return iroid;
    }



    public List<Iroid> getAllIroids() {
        List<Iroid> iroidList = new ArrayList<Iroid>();

        String selectQuery = "SELECT  * FROM " + TABLE_IROID;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {
                Iroid iroid = new Iroid();
                iroid.setId(Integer.parseInt(cursor.getString(0)));
                iroid.setName(cursor.getString(1));
                iroid.setPlace(cursor.getString(2));
                iroid.setAge(cursor.getString(3));
                iroid.setPhone(cursor.getString(4));
                iroid.setQualification(cursor.getString(5));


                iroidList.add(iroid);
            } while (cursor.moveToNext());
        }

        return iroidList;
    }




    public int updateIroid(String id, String finalName, String finalPlace, String finalAge, String finalPhone, String finalQualification) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, finalName);
        values.put(KEY_PLACE, finalPlace);
        values.put(KEY_AGE, finalAge);
        values.put(KEY_PHONE, finalPhone);
        values.put(KEY_QUALIFICATION, finalQualification);


        // updating row
        //String.valueOf() is usedto cast the result to string in order to store it in string array.
        return db.update(TABLE_IROID, values, KEY_ID + " = ?",
                new String[] { id });
    }


    public void deleteIroid(Iroid iroid) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_IROID, KEY_ID + " = ?",
                new String[] { String.valueOf(iroid.getId()) });
        db.close();
    }



}
