package com.rabelas.weathercurrentday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.view.MenuItem;

import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;
import com.google.android.material.navigation.NavigationView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    ConstraintLayout cl;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    final String iconUrl="http://openweathermap.org/img/wn/";
    TextView temperature, city, status, date,hum,rain;
    ImageView iconView;
    String Jrain;

    String Jhum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cl = findViewById(R.id.cLayout);
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("Weather Report");
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);


       
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


         temperature = (TextView)findViewById(R.id.temp);
        iconView =  findViewById(R.id.weattherIcon);

        city = (TextView)findViewById(R.id.city);
        status = (TextView)findViewById(R.id.status);
        date = (TextView)findViewById(R.id.date);
        rain = findViewById(R.id.rVal);
        hum = findViewById(R.id.humVal);

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
    @Override
    public void onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer((GravityCompat.START));
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_home:
                Intent intent = new Intent(this, MainMenu.class);
                startActivity(intent);
                break;
            case R.id.nav_settings:
                Intent intent1 = new Intent(this, Settings.class);
                startActivity(intent1);
                break;
            case R.id.nav_about:
                Intent intent2 = new Intent(this, About.class);
                startActivity(intent2);
                break;
        }
        return true;
    }
}