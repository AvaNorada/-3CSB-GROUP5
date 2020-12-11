package com.rabelas.weathercurrentday.models;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rabelas.weathercurrentday.R;

import java.util.ArrayList;

public class WeatherAdapter extends BaseAdapter {

    ArrayList<WeatherData> weatherDataArrayList;
    Context context;

    public WeatherAdapter(Context context,ArrayList<WeatherData> weatherDataArrayList) {
        this.weatherDataArrayList = weatherDataArrayList;
        this.context=context;

        //Get the arrays from the resource->values->string.xml, .array para iaccess kahit anong array
      /*  String[] cName = context.getResources().getStringArray(R.array.cityNames);

        //Ito ginamit sa lecture

        //Dynamic lng ito
        for (int i = 0; i < cName.length; i++) {
            weatherDataArrayList.add(new WeatherData(cName[i],context));
            Log.d("check","this inside adapter forloop  "+ weatherDataArrayList.get(i).getJtemp());
        }//*/

    }

    @Override
    public int getCount() {
        return weatherDataArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return weatherDataArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Pointer to the primary key for database
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Need layout inflater, convert xml to a Java Object as View
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Fill the viewReference with the template in layout.row
        View viewReference=inflater.inflate(R.layout.weather_row,parent,false);

       //Get the elements in the row.xml by accessing the ids
        TextView City= (TextView) viewReference.findViewById(R.id.city);
        TextView Temperature=(TextView) viewReference.findViewById(R.id.temp);
        TextView Status=(TextView) viewReference.findViewById(R.id.status);

        //Access the androidList(ArrayList) that is full of AndroidVersion Objects
        WeatherData temp= weatherDataArrayList.get(position);
        Log.d("check","this is inside adapter inflater "+ temp.getJstatus());
        City.setText(temp.getJcity());
        Temperature.setText(temp.getJtemp());
        Status.setText(temp.getJstatus());
        //image.setImageResource(temp.image);//*/

        //Return the made View
        return  viewReference;
}
}
