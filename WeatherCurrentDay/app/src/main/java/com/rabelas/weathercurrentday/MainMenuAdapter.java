package com.rabelas.weathercurrentday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainMenuAdapter extends BaseAdapter {
    ArrayList<Menu> menuList;
    Context context;

    MainMenuAdapter(Context context) {
        menuList = new ArrayList<>();
        this.context=context;

        String[] tView1 = context.getResources().getStringArray(R.array.MainMenu);
        String[] tView2 = context.getResources().getStringArray(R.array.MainMenu2);
        int[] image = {R.drawable.weather, R.drawable.safety, R.drawable.ec};

        for (int i = 0; i < tView1.length; i++) {
            menuList.add(new Menu(tView1[i], tView2[i], image[i]));
        }
    }

    @Override
    public int getCount() {
        return menuList.size();
    }

    @Override
    public Object getItem(int position) {
        return menuList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewReference=inflater.inflate(R.layout.menu_row, parent,false);

        TextView tView1 = viewReference.findViewById(R.id.textView);
        TextView tView2 = viewReference.findViewById(R.id.textView3);
        ImageView image = viewReference.findViewById(R.id.imageView2);

        Menu temp= menuList.get(position);
        tView1.setText(temp.tView1);
        tView2.setText(temp.tView2);
        image.setImageResource(temp.image);

        return viewReference;
    }
}
