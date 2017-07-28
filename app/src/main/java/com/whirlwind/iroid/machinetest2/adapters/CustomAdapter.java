package com.whirlwind.iroid.machinetest2.adapters;

import android.content.Context;
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

/**
 * Created by Acer on 27-Jul-17.
 */

public class CustomAdapter extends BaseAdapter {

    String mListName;
    String mListAge;
    String mListPhone;
    Context context;
    private static LayoutInflater inflater=null;


    public CustomAdapter(Context listViewActivity, String separatedName, String separatedAge, String separatedPhone) {

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
        holder.tv1.setText(mListName);
        holder.tv2.setText(mListAge);
        holder.tv3.setText(mListPhone);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "You Clicked" + holder.tv1 , Toast.LENGTH_LONG).show();
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
