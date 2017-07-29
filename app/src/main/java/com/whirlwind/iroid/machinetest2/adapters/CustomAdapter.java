package com.whirlwind.iroid.machinetest2.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.whirlwind.iroid.machinetest2.R;
import com.whirlwind.iroid.machinetest2.UpdationActivity;
import com.whirlwind.iroid.machinetest2.dbhandler.DatabaseHandler;
import com.whirlwind.iroid.machinetest2.model.Iroid;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Acer on 27-Jul-17.
 */

public class CustomAdapter extends ArrayAdapter<Iroid> {

    private List<Iroid> iroids;
    Context context;

    private LayoutInflater inflater = null;
    private OnItemListener onItemListener;


    public CustomAdapter(Context context, List<Iroid> iroids) {
        super(context, R.layout.list_row, iroids);

        this.context = context;

        this.iroids = iroids;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return iroids.size();
    }

    @Override
    public Iroid getItem(int position) {
        return iroids.get(position);
    }

    @Override
    public long getItemId(int position) {
        return iroids.get(position).getId();
    }


    public class Holder {
        TextView tv1;
        TextView tv2;
        TextView tv3;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.list_row, parent, false);

        holder.tv1 = (TextView) rowView.findViewById(R.id.tvListName);
        holder.tv2 = (TextView) rowView.findViewById(R.id.tvListAge);
        holder.tv3 = (TextView) rowView.findViewById(R.id.tvListPhone);

        holder.tv1.setText(iroids.get(position).getName());
        holder.tv2.setText(iroids.get(position).getAge());
        holder.tv3.setText(iroids.get(position).getPhone());
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(onItemListener !=null){
                    onItemListener.itemClick(getItem(position));
                }

            }
        });


        rowView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(onItemListener !=null) {
                    onItemListener.itemLongClick(getItem(position));
                }
                return false;
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

public void setOnItemListener(OnItemListener onItemListener) {
    this.onItemListener = onItemListener;
}
    public  interface OnItemListener {
        void itemClick(Iroid iroid);
        void itemLongClick(Iroid iroid);
    }
}
