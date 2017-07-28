package com.whirlwind.iroid.machinetest2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.whirlwind.iroid.machinetest2.adapters.CustomAdapter;
import com.whirlwind.iroid.machinetest2.dbhandler.DatabaseHandler;
import com.whirlwind.iroid.machinetest2.model.Iroid;

import java.util.List;

public class ListviewActivity extends AppCompatActivity {

    int id = 0;
    int _id = id + 1;
    DatabaseHandler db;
    String separatedName;
    String separatedAge;
    String separatedPhone;

    ListView mlv;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        context = this;
        mlv = (ListView) findViewById(R.id.listView);

        Log.d("Reading: ", "Reading all contacts..");
        List<Iroid> iroidsListing = db.getAllIroids();

        for (Iroid ir : iroidsListing){

            separatedName = ir.getName();
            separatedAge = ir.getAge();
            separatedPhone = ir.getPhone();
            mlv.setAdapter(new CustomAdapter(context, separatedName, separatedAge, separatedPhone));
        }

    }
}
