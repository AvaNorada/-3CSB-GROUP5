package com.rabelas.weathercurrentday.models;

import android.content.Context;
import android.util.Log;

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

public class WeatherData {
    Context c;
    String url;
    String Jtemp;
    String Jhum;
    String Jrain;
    String Jstatus ;
    String Jcity ;
    String Jicon;

    public void setJtemp(String jtemp) {
        Jtemp = jtemp;
    }

    public void setJhum(String jhum) {
        Jhum = jhum;
    }

    public void setJrain(String jrain) {
        Jrain = jrain;
    }

    public void setJstatus(String jstatus) {
        Jstatus = jstatus;
    }

    public void setJcity(String jcity) {
        Jcity = jcity;
    }

    public void setJicon(String jicon) {
        Jicon = jicon;
    }



    public WeatherData(String city) {
        this.Jcity=city;
        this.url="http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=89b8820d9a2b92875e415abc2e38c168&units=imperial";
        //this.c=c;
        //findWeather();
    }



    public String getJicon() {
        return Jicon;
    }


    public String getJtemp() {
        return Jtemp;
    }

    public String getJhum() {
        return Jhum;
    }

    public String getJstatus() {
        return Jstatus;
    }


    public String getJrain() {
        return Jrain;
    }

    public String getJcity() {
        return Jcity;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void findWeather(){
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject main_object = response.getJSONObject("main");
                    //JSONObject rain_object = response.getJSONObject("rain");
                    JSONArray array = response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);
                     Jtemp = String.valueOf(main_object.getDouble("temp"));
                    //String Jhum = String.valueOf(main_object.getDouble("humidity"));
                   // String Jrain = String.valueOf(rain_object.getDouble("1h"));
                    Jstatus = object.getString("description");
                    Jcity = response.getString("name");


                    Log.d("check","this is inside model "+Jtemp);
                  //  Calendar calendar = Calendar.getInstance();
                   // SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MM-dd-YYYY");
                   // String formatted_date = sdf.format(calendar.getTime());

                   // date.setText(formatted_date);
                   //hum.setText(Jhum.concat("%"));
                    //rain.setText(Jrain.concat("mm"));
                    double temp_int = Double.parseDouble(Jtemp);
                    double centi = (temp_int - 32)/1.8000;
                    centi = Math.round(centi);
                    int i = (int)centi;
                setJtemp(String.valueOf(i));
                    Log.d("check","this is inside model after setter"+Jtemp);
                   // city.setText(Jcity);
                    //status.setText(Jstatus);
                   // temperature.setText(String.valueOf(i));
                }catch(JSONException e){
                    Log.e("check","Error Occurred");
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("check","Error Occurred");
            }
        }
        );
        RequestQueue queue = Volley.newRequestQueue(c);
        queue.add(jor);
    }
    }

