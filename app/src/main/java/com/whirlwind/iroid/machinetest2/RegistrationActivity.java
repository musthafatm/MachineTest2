package com.whirlwind.iroid.machinetest2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.whirlwind.iroid.machinetest2.dbhandler.DatabaseHandler;
import com.whirlwind.iroid.machinetest2.model.Iroid;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {


    public static EditText metRegisterName = null;
    public static EditText metRegisterPlace = null;
    public static EditText metRegisterAge = null;
    public static EditText metRegisterPhone = null;
    public static EditText metRegisterQualification = null;

    private Button mbtnSave = null;

    DatabaseHandler db = new DatabaseHandler(this);

    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        metRegisterName = (EditText) findViewById(R.id.etRegisterName);
        metRegisterPlace = (EditText) findViewById(R.id.etRegisterPlace);
        metRegisterAge = (EditText) findViewById(R.id.etRegisterAge);
        metRegisterPhone = (EditText) findViewById(R.id.etRegisterPhone);
        metRegisterQualification = (EditText) findViewById(R.id.etRegisterQualification);

        mbtnSave = (Button) findViewById(R.id.btnSave);
        mbtnSave.setOnClickListener(this);

    }





    @Override
    public void onClick(View v) {


        if (metRegisterName.getText().toString().matches("") ||
                metRegisterPlace.getText().toString().matches("") ||
                metRegisterAge.getText().toString().matches("") ||
                metRegisterPhone.getText().toString().matches("") ||
                metRegisterQualification.getText().toString().matches("") ) {

            Toast.makeText(this, "All fields are mandatory to fill", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Successfully Registered", Toast.LENGTH_SHORT).show();
/*
            id = id + 1;
*/
            String stringName = String.valueOf(metRegisterName);
            String stringPlace = String.valueOf(metRegisterPlace);
            String stringAge = String.valueOf(metRegisterAge);
            String stringPhone = String.valueOf(metRegisterPhone);
            String stringQualification= String.valueOf(metRegisterQualification);


            db.addIroid(new Iroid(id, stringName, stringPlace, stringAge, stringPhone, stringQualification));

            Intent intent = new Intent(this, ListviewActivity.class);
            startActivity(intent);
            finish();
        }
    }


}

