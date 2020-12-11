package com.rabelas.weathercurrentday;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    ArrayList<EvacCenter> evacList;
    Context context;
    SharedPreferences sharedPreferences;
    String cityname;
    CustomAdapter(Context context) {
        evacList = new ArrayList<>();
        this.context=context;

        cityname = Settings.loadData(context);

        String[] ename = context.getResources().getStringArray(R.array.eName);
        String[] city = context.getResources().getStringArray(R.array.City);


        for (int i = 0; i < ename.length; i++) {
            if(city[i].equals(cityname)){
                evacList.add(new EvacCenter(ename[i], city[i]));
            }
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
