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
                + KEY_PHONE + " TEXT" + KEY_QUALIFICATION + " TEXT," + ")";

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
        values.put(KEY_NAME, String.valueOf(metRegisterName.getText().toString()));
        values.put(KEY_PLACE, String.valueOf(metRegisterPlace.getText().toString()));
        values.put(KEY_AGE, String.valueOf(metRegisterAge.getText().toString()));
        values.put(KEY_PHONE, String.valueOf(metRegisterPhone.getText().toString()));
        values.put(KEY_QUALIFICATION, String.valueOf(metRegisterQualification.getText().toString()));


        db.insert(TABLE_IROID, null, values);

        db.close();
    }

/*

    //Need to be edited for the third activity.

    Iroid getIroid(int _id) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_IROID, new String[]{KEY_NAME,
                        KEY_AGE, KEY_PHONE}, KEY_ID + "=?",
                new String[]{String.valueOf(_id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Iroid iroid = new Iroid(cursor.getString(1),
                cursor.getString(3), cursor.getString(4));

        return iroid;
    }*/




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



}
