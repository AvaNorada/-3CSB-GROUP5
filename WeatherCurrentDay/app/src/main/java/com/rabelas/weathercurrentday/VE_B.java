package com.rabelas.weathercurrentday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

import com.rabelas.weathercurrentday.models.WebpageData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class VE_B extends AppCompatActivity {
    ConstraintLayout cl;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ve_b);

        cl = findViewById(R.id.cLayout);
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("BEFORE Volcanic Eruption");
        setSupportActionBar(toolbar);
        final TextView bodyText= findViewById(R.id.webBody);
        //final TextView titleText= findViewById(R.id.webTitle);

        new Thread(new Runnable() {

            WebpageData data = new WebpageData();
            @Override
            public void run() {


                try {

                    Document Vdoc =  Jsoup.connect("https://coins.ph/blog/what-to-do-volcanic-eruption-tips/").get();

                    Elements VText = Vdoc.select("div.mk-single-content.clearfix");

                    data.setPageBody(VText.text());

                    data.extractText("EXPLOSION","DURING");//this is dependent on the line above,


                } catch (IOException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {//Set to textview thru WebpageData object

                        bodyText.setText(data.getPageBody());
                    }
                });
            }
        }).start();
    }
}