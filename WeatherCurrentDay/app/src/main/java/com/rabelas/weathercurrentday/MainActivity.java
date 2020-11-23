package com.rabelas.weathercurrentday;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView temp, city, status, date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temp = (TextView)findViewById(R.id.temp);
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
                    String Jstatus = object.getString("description");
                    String Jcity = response.getString("name");



                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MM-dd-YYYY");
                    String formatted_date = sdf.format(calendar.getTime());

                    date.setText(formatted_date);
                    double temp_int = Double.parseDouble(Jtemp);
                    double centi = (temp_int - 32)/1.8000;
                    centi = Math.round(centi);
                    int i = (int)centi;

                    city.setText(Jcity);
                    status.setText(Jstatus);
                    temp.setText(String.valueOf(i));
                }catch(JSONException e){
                    e.printStackTrace();
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