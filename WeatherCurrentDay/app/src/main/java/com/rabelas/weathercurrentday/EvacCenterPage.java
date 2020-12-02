package com.rabelas.weathercurrentday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class EvacCenterPage extends AppCompatActivity implements AdapterView.OnItemClickListener {
    CustomAdapter customAdapter;
    Toolbar toolbar;
    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        ListView listView=findViewById(R.id.listView);

        customAdapter = new CustomAdapter(this);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(this);

        cl = findViewById(R.id.cLayout);
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("Evacuation Centers");
        setSupportActionBar(toolbar);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        String name = customAdapter.evacList.get(position).name;
        String toastll = "You selected " + customAdapter.evacList.get(position);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("geo:0,0?q=" + name));
        Toast.makeText(getApplicationContext(), toastll, Toast.LENGTH_SHORT).show();
        startActivity(i);
    }
}