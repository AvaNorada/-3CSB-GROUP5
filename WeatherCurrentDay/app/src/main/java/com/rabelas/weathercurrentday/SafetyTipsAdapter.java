package com.rabelas.weathercurrentday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SafetyTipsAdapter extends BaseAdapter {
    ArrayList<Safety> safeList;
    Context context;

    SafetyTipsAdapter(Context context) {
        safeList = new ArrayList<>();
        this.context=context;

        String[] tView5 = context.getResources().getStringArray(R.array.Guidelines);

        for (int i = 0; i < tView5.length; i++) {
            safeList.add(new Safety(tView5[i]));
        }
    }

    @Override
    public int getCount() {
        return safeList.size();
    }

    @Override
    public Object getItem(int position) {
        return safeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewReference=inflater.inflate(R.layout.safety_tips_row, parent,false);

        TextView tView5 = viewReference.findViewById(R.id.textView5);

        Safety temp= safeList.get(position);
        tView5.setText(temp.tView5);

        return viewReference;
    }
}
