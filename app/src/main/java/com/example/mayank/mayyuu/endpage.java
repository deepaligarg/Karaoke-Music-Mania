package com.example.mayank.mayyuu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


public class endpage extends AppCompatActivity {
    private static Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        String s = getIntent().getStringExtra("Name1");

        TextView tv = (TextView) findViewById(com.example.mayank.mayyuu.R.id.Text3);
        tv.setText(s);

        OnClickButtonListner();

    }

    public void OnClickButtonListner() {
        but = (Button) findViewById(R.id.but1);
        but.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                Intent intent0 = new Intent("com.example.mayank.mayyuu.secondpage");
                startActivity(intent0);
            }
        });


    }
}

