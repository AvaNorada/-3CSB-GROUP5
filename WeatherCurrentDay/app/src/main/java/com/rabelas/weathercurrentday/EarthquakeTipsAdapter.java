package com.rabelas.weathercurrentday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeTipsAdapter extends BaseAdapter {
    ArrayList<Earthquake> earthquakeList;
    Context context;

    EarthquakeTipsAdapter(Context context) {
        earthquakeList = new ArrayList<>();
        this.context=context;

        String[] tView6 = context.getResources().getStringArray(R.array.Earthquake);

        for (int i = 0; i < tView6.length; i++) {
            earthquakeList.add(new Earthquake(tView6[i]));
        }
    }

    @Override
    public int getCount() {
        return earthquakeList.size();
    }

    @Override
    public Object getItem(int position) {
        return earthquakeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewReference=inflater.inflate(R.layout.earthquake, parent,false);

        TextView tView6 = viewReference.findViewById(R.id.textView6);

        Earthquake temp= earthquakeList.get(position);
        tView6.setText(temp.tView6);

        return viewReference;
    }
}
