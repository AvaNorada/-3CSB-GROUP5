package com.rabelas.weathercurrentday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;


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

<<<<<<< Updated upstream
public class MainActivity extends AppCompatActivity {
    ConstraintLayout cl;
    Toolbar toolbar;
    TextView temp, city, status, date;
=======
<<<<<<< Updated upstream
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    ConstraintLayout cl;
=======
public class MainActivity extends AppCompatActivity {
    ConstraintLayout cl;
<<<<<<< Updated upstream
    Toolbar toolbar;
    TextView temp, city, status, date;
=======
>>>>>>> Stashed changes
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    final String iconUrl="http://openweathermap.org/img/wn/";
    TextView temperature, city, status, date,hum,rain;
    ImageView iconView;
    String Jrain;
<<<<<<< Updated upstream


=======
    String Jhum;


>>>>>>> Stashed changes
>>>>>>> Stashed changes
>>>>>>> Stashed changes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cl = findViewById(R.id.cLayout);
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("WEATHER REPORT");
        setSupportActionBar(toolbar);
<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream
=======
>>>>>>> Stashed changes
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);


       
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

<<<<<<< Updated upstream
         temperature = (TextView)findViewById(R.id.temp);
        iconView =  findViewById(R.id.weattherIcon);
=======
        temperature = (TextView)findViewById(R.id.temp);
        iconView =  findViewById(R.id.weattherIcon);
>>>>>>> Stashed changes
>>>>>>> Stashed changes
>>>>>>> Stashed changes

        temp = (TextView)findViewById(R.id.temp);
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
<<<<<<< Updated upstream
                    String Jstatus = object.getString("description");
                    String Jcity = response.getString("name");
=======
<<<<<<< Updated upstream
                    String Jhum = String.valueOf(main_object.getDouble("humidity"));
                   String Jicon = object.getString("icon");


                    String Jstatus = object.getString("description");
                    String Jcity = response.getString("name");
                        try{

=======
<<<<<<< Updated upstream
                    String Jstatus = object.getString("description");
                    String Jcity = response.getString("name");
=======

                    String Jicon = object.getString("icon");

                    String Jstatus = object.getString("description");
                    String Jcity = response.getString("name");
                    Jhum = String.valueOf(main_object.getDouble("humidity"));
                        try{
>>>>>>> Stashed changes
                            JSONObject rain_object = response.getJSONObject("rain");

                            Jrain = String.valueOf(rain_object.getDouble("1h"));
                        }catch (JSONException e){
                            Jrain="00";
<<<<<<< Updated upstream
                        }
=======
                            //Jhum="00";
                        }
>>>>>>> Stashed changes
>>>>>>> Stashed changes
>>>>>>> Stashed changes

                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MM-dd-YYYY");
                    String formatted_date = sdf.format(calendar.getTime());

                    date.setText(formatted_date);
<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream

                    hum.setText(Jhum.concat("%"));
                   rain.setText(Jrain.concat("mm"));

=======
<<<<<<< Updated upstream
=======

                    /*if(Jhum.equals(null)){
                        Jhum = "00";
                    }*/
                    hum.setText(Jhum.concat("%"));
                    rain.setText(Jrain.concat("mm"));

>>>>>>> Stashed changes
>>>>>>> Stashed changes
>>>>>>> Stashed changes
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