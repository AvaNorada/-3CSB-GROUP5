package com.rabelas.weathercurrentday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    final String iconUrl="http://openweathermap.org/img/wn/";
    TextView temperature, city, status, date,hum,rain;
    ImageView iconView;
    ConstraintLayout cl;
    Toolbar toolbar;
    String Jrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        temperature = (TextView)findViewById(R.id.temp);
        hum = (TextView)findViewById(R.id.humVal);
        rain = (TextView)findViewById(R.id.rVal);

        cl = findViewById(R.id.cLayout);
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("WEATHER REPORT");
        setSupportActionBar(toolbar);

        temperature = (TextView)findViewById(R.id.temp);
        iconView =  findViewById(R.id.weattherIcon);
        city = (TextView)findViewById(R.id.city);
        status = (TextView)findViewById(R.id.status);
        date = (TextView)findViewById(R.id.date);

        findWeather();
    }
    public void findWeather(){
        String url = "http://api.openweathermap.org/data/2.5/weather?q=Manila&appid=89b8820d9a2b92875e415abc2e38c168&units=imperial";
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject main_object = response.getJSONObject("main");

                    JSONArray array = response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);
                    String Jtemp = String.valueOf(main_object.getDouble("temp"));
                    String Jhum = String.valueOf(main_object.getDouble("humidity"));
                   String Jicon = object.getString("icon");


                    String Jstatus = object.getString("description");
                    String Jcity = response.getString("name");
                        try{

                            JSONObject rain_object = response.getJSONObject("rain");

                            Jrain = String.valueOf(rain_object.getDouble("1h"));
                        }catch (JSONException e){
                            Jrain="00";
                        }



                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat(" MMMM dd, YYYY, \n EEEE");
                    String formatted_date = sdf.format(calendar.getTime());

                    date.setText(formatted_date);
                    hum.setText(Jhum.concat("%"));
                   rain.setText(Jrain.concat("mm"));
                    double temp_int = Double.parseDouble(Jtemp);
                    double centi = (temp_int - 32)/1.8000;
                    centi = Math.round(centi);
                    int i = (int)centi;

                    Log.d("check", "onResponse: "+Jtemp);
                    city.setText(Jcity);
                    status.setText(Jstatus);
                    temperature.setText(String.valueOf(i));

                    Picasso.get().load(iconUrl + Jicon+"@4x.png").into(iconView);
                    //IMG_URL + weather.iconName +".png"
                }catch(JSONException e){
                    e.printStackTrace();
                }finally{

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);
    }
}