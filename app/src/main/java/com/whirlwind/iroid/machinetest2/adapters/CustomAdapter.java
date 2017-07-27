package com.whirlwind.iroid.machinetest2.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Acer on 27-Jul-17.
 */

public class CustomAdapter extends BaseAdapter {

    String mlistName;
    String mlistAge;
    String mlistPhone;
    Context context;

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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
