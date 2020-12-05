package com.rabelas.weathercurrentday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class VolcanicEruptionsAdapter extends BaseAdapter {
    ArrayList<VolcanicEruptions> volList;
    Context context;

    VolcanicEruptionsAdapter(Context context) {
        volList = new ArrayList<>();
        this.context=context;

        String[] tView8 = context.getResources().getStringArray(R.array.VolcanicEruption);

        for (int i = 0; i < tView8.length; i++) {
            volList.add(new VolcanicEruptions(tView8[i]));
        }
    }

    @Override
    public int getCount() {
        return volList.size();
    }

    @Override
    public Object getItem(int position) {
        return volList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewReference=inflater.inflate(R.layout.volcanic, parent,false);

        TextView tView8 = viewReference.findViewById(R.id.textView8);

        VolcanicEruptions temp= volList.get(position);
        tView8.setText(temp.tView8);

        return viewReference;
    }
}
