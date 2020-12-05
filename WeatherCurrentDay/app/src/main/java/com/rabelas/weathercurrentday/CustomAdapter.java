package com.rabelas.weathercurrentday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    ArrayList<EvacCenter> evacList;
    Context context;

    CustomAdapter(Context context) {
        evacList = new ArrayList<>();
        this.context=context;

        String[] ename = context.getResources().getStringArray(R.array.eName);
        String[] city = context.getResources().getStringArray(R.array.City);
        /*String[] menu = context.getResources().getStringArray(R.array.MainMenu);
        String[] guidelines = context.getResources().getStringArray(R.array.Guidelines);
        String[] equake = context.getResources().getStringArray(R.array.Earthquake);
        String[] typhoon = context.getResources().getStringArray(R.array.Typhoon);
        String[] veruption = context.getResources().getStringArray(R.array.VolcanicEruption);*/


        for (int i = 0; i < ename.length; i++) {
            evacList.add(new EvacCenter(ename[i], city[i])); //menu[i], guidelines[i], equake[i], typhoon[i], veruption[i]));
        }
    }

    @Override
    public int getCount() {
        return evacList.size();
    }

    @Override
    public Object getItem(int position) {
        return evacList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewReference=inflater.inflate(R.layout.evac_row,parent,false);

        TextView name = viewReference.findViewById(R.id.evac_Name);
        EvacCenter temp= evacList.get(position);
        name.setText(temp.name);

        return viewReference;
    }
}
