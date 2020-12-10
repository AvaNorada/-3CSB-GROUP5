package com.rabelas.weathercurrentday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TyphoonTipsAdapter extends BaseAdapter {
    ArrayList<Typhoon> typhoonList;
    Context context;

    TyphoonTipsAdapter(Context context) {
        typhoonList = new ArrayList<>();
        this.context=context;

        String[] tView7 = context.getResources().getStringArray(R.array.Typhoon);

        for (int i = 0; i < tView7.length; i++) {
            typhoonList.add(new Typhoon(tView7[i]));
        }
    }

    @Override
    public int getCount() {
        return typhoonList.size();
    }

    @Override
    public Object getItem(int position) {
        return typhoonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewReference=inflater.inflate(R.layout.typhoon, parent,false);

        TextView tView7 = viewReference.findViewById(R.id.textView7);

        Typhoon temp= typhoonList.get(position);
        tView7.setText(temp.tView7);

        return viewReference;
    }
}
