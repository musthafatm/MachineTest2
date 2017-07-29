package com.whirlwind.iroid.machinetest2.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.whirlwind.iroid.machinetest2.R;
import com.whirlwind.iroid.machinetest2.UpdationActivity;
import com.whirlwind.iroid.machinetest2.dbhandler.DatabaseHandler;
import com.whirlwind.iroid.machinetest2.model.Iroid;

import java.io.Serializable;

/**
 * Created by Acer on 27-Jul-17.
 */

public class CustomAdapter extends BaseAdapter {

    String mListId;
    String mListName;
    String mListAge;
    String mListPhone;
    Context context;
    private static LayoutInflater inflater=null;

    DatabaseHandler db;


    public CustomAdapter(Context listViewActivity, String separatedId, String separatedName, String separatedAge, String separatedPhone) {

        mListId = separatedId;
        mListName=separatedName;
        context=listViewActivity;
        mListAge=separatedAge;
        mListPhone = separatedPhone;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }




    public class Holder{
        String referenceId;
        TextView tv1;
        TextView tv2;
        TextView tv3;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.list_row, null);

        holder.tv1 = (TextView) rowView.findViewById(R.id.tvListName);
        holder.tv2 = (TextView) rowView.findViewById(R.id.tvListAge);
        holder.tv3 = (TextView) rowView.findViewById(R.id.tvListPhone);

        holder.referenceId = (mListId);
        holder.tv1.setText(mListName);
        holder.tv2.setText(mListAge);
        holder.tv3.setText(mListPhone);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "You Clicked" + holder.tv1 , Toast.LENGTH_SHORT).show();

          /*
           Sample code:

           Intent myIntent = new Intent(view.getContext(), NewYork.class);
                startActivityForResult(myIntent, 0);*/

          /*................*/

                Iroid clickedContact;

                clickedContact = db.getIroid(String.valueOf(holder.tv1));

                String idRef = String.valueOf(clickedContact.getId());
                String nameForUpdate = clickedContact.getName();
                String placeForUpdate = clickedContact.getPlace();
                String ageForUpdate = clickedContact.getAge();
                String phoneForUpdate = clickedContact.getPhone();
                String qualificationForUpdate = clickedContact.getQualification();


                Intent intent = new Intent(context, UpdationActivity.class);
                intent.putExtra("id", idRef);
                intent.putExtra("updatingName", nameForUpdate);
                intent.putExtra("updatingPlace", placeForUpdate);
                intent.putExtra("updatingAge", ageForUpdate);
                intent.putExtra("updatingPhone", phoneForUpdate);
                intent.putExtra("updatingQualification", qualificationForUpdate);
                context.startActivity(intent);

            }
        });


  /* mlv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                    int pos, long id) {

                Log.v("long clicked","pos: " + pos);

                return true;
            }
        });

*/


        return rowView;
    }

}
