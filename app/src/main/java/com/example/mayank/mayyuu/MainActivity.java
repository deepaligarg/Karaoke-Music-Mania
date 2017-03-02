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


public class MainActivity extends AppCompatActivity {
    private static  Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup_activity);

        OnClickButtonListner();
    }

    public void OnClickButtonListner(){
        b = (Button) findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                Intent intent = new Intent("com.example.mayank.mayyuu.secondpage");
                startActivity(intent);
            }
        });



    }
}
