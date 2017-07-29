package com.whirlwind.iroid.machinetest2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.whirlwind.iroid.machinetest2.adapters.CustomAdapter;
import com.whirlwind.iroid.machinetest2.dbhandler.DatabaseHandler;
import com.whirlwind.iroid.machinetest2.model.Iroid;

import java.util.List;

public class ListviewActivity extends AppCompatActivity implements CustomAdapter.OnItemListener {

    int id = 0;
    DatabaseHandler db;


    ListView mlv;
    Context context;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        context = this;
        mlv = (ListView) findViewById(R.id.listView);

        db = new DatabaseHandler(this);

        Log.d("Reading: ", "Reading all contacts..");


//        for (Iroid ir : iroidsListing){
//
//            separatedId = String.valueOf(ir.getId());
//            separatedName = ir.getName();
//            separatedAge = ir.getAge();
//            separatedPhone = ir.getPhone();

//        }

    }

    @Override
    protected void onResume() {
        List<Iroid> iroidsListing = db.getAllIroids();
        customAdapter = new CustomAdapter(this, iroidsListing);
        customAdapter.setOnItemListener(this);
        mlv.setAdapter(customAdapter);
        super.onResume();
    }

    @Override
    public void itemClick(Iroid iroid) {
        Intent intent = new Intent(this, UpdationActivity.class);
        intent.putExtra("id", iroid.getId() + "");
        intent.putExtra("updatingName", iroid.getName());
        intent.putExtra("updatingPlace", iroid.getPlace());
        intent.putExtra("updatingAge", iroid.getAge());
        intent.putExtra("updatingPhone", iroid.getPhone());
        intent.putExtra("updatingQualification", iroid.getQualification());
        startActivity(intent);
    }

    @Override
    public void itemLongClick(Iroid iroid) {
        deleteItem(iroid.getId());
    }

    private void deleteItem(final int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Delete");
        builder.setMessage("Are you sure you want to delete?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                boolean b = db.deleteIroid(id);
                if(b){

                    if(customAdapter!= null) {
                        onResume();
                    }
                }
            }
        });

        builder.setNegativeButton("NO", null);

        builder.create().show();
    }
}
