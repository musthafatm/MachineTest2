package com.whirlwind.iroid.machinetest2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.whirlwind.iroid.machinetest2.dbhandler.DatabaseHandler;

public class UpdationActivity extends AppCompatActivity implements View.OnClickListener {

    String i_d;
    String update1;
    String update2;
    String update3;
    String update4;
    String update5;

    private EditText metUpdationName;
    private EditText metUpdationPlace;
    private EditText metUpdationAge;
    private EditText metUpdationPhone;
    private EditText metUpdationQualification;

    private Button mbtnUpdate = null;
    private Button mbtnBack = null;


    DatabaseHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updation);


        db = new DatabaseHandler(this);

        metUpdationName = (EditText) findViewById(R.id.etUpdationName);
        metUpdationPlace = (EditText) findViewById(R.id.etUpdationPlace);
        metUpdationAge = (EditText) findViewById(R.id.etUpdationAge);
        metUpdationPhone = (EditText) findViewById(R.id.etUpdationPhone);
        metUpdationQualification = (EditText) findViewById(R.id.etUpdationQualification);

        mbtnBack = (Button) findViewById(R.id.btnBack);
        mbtnUpdate = (Button) findViewById(R.id.btnUpdate);


        Bundle extras = getIntent().getExtras();
        i_d = extras.getString("id");
        update1 = extras.getString("updatingName");
        update2 = extras.getString("updatingPlace");
        update3 = extras.getString("updatingAge");
        update4 = extras.getString("updatingPhone");
        update5 = extras.getString("updatingQualification");

        metUpdationName.setText(update1, TextView.BufferType.EDITABLE);
        metUpdationPlace.setText(update2, TextView.BufferType.EDITABLE);
        metUpdationAge.setText(update3, TextView.BufferType.EDITABLE);
        metUpdationPhone.setText(update4, TextView.BufferType.EDITABLE);
        metUpdationQualification.setText(update5, TextView.BufferType.EDITABLE);


        metUpdationName = (EditText) findViewById(R.id.etUpdationName);
        metUpdationPlace = (EditText) findViewById(R.id.etUpdationPlace);
        metUpdationAge = (EditText) findViewById(R.id.etUpdationAge);
        metUpdationPhone = (EditText) findViewById(R.id.etUpdationPhone);
        metUpdationQualification = (EditText) findViewById(R.id.etUpdationQualification);

        mbtnBack.setOnClickListener(this);
        mbtnUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnBack:
                finish();
                break;

            case R.id.btnUpdate:
                String finalName = metUpdationName.getText().toString();
                String finalPlace = metUpdationPlace.getText().toString();
                String finalAge = metUpdationAge.getText().toString();
                String finalPhone = metUpdationPhone.getText().toString();
                String finalQualification = metUpdationQualification.getText().toString();

                boolean b = db.updateIroid(i_d, finalName, finalPlace, finalAge, finalPhone, finalQualification);
                if(b) {
                    Toast.makeText(this, "Update successful", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Update failed", Toast.LENGTH_SHORT).show();
                }
                finish();
                break;
        }

    }
}
