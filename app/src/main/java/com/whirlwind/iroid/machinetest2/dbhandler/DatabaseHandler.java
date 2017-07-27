package com.whirlwind.iroid.machinetest2.dbhandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.whirlwind.iroid.machinetest2.model.Iroid;

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



}
