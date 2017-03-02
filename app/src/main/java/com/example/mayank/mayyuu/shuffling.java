package com.example.mayank.mayyuu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.*;

import java.util.Random;
import java.util.Scanner;

public class shuffling extends AppCompatActivity {
private static Button b,bu;

    String[] A = {"Zara Si Dil Mein", "Baby", "Samjhawa", "Tum Mile", "Saibo",
            "Makes You Beautiful", "Wildest Dreams", "Love Me Like You Do", "Way You Are", "Emptiness"};

    Integer[] I = {
            R.drawable.zara_dil_me,
            R.drawable.bieber,
            R.drawable.smjhawa,
            R.drawable.tum_mile,
            R.drawable.shreya,
            R.drawable.dir,
            R.drawable.taylor_swift,
            R.drawable.loveme,
            R.drawable.just_the_way,
            R.drawable.emptiness
    };

    int n = 10;
    String[] res = new String[n];
    String temp;
    int temp1;


    Random r = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random r = new Random();

        for (int i = A.length - 1; i > 0; i--) {
            int index = r.nextInt(i);
            temp = A[index];
            A[index] = A[i];
            A[i] = temp;

            temp1 = I[index];
            I[index] = I[i];
            I[i] = temp1;

        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.content_loveme,R.id.refer,A);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);




    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            switch (position) {
                case 0:
                    Intent newActivity = new Intent("com.example.mayank.mayyuu.play_record");
                    newActivity.putExtra("Name", A[position]);
                    newActivity.putExtra("r1Int",I[position]);
                    startActivity(newActivity);
                    break;
                case 1:
                    Intent newActivity1 = new Intent("com.example.mayank.mayyuu.play_record");
                    newActivity1.putExtra("Name", A[position]);
                    newActivity1.putExtra("r1Int",I[position]);
                    startActivity(newActivity1);
                    break;
                case 2:
                    Intent newActivity2 = new Intent("com.example.mayank.mayyuu.play_record");
                    newActivity2.putExtra("Name",A[position]);
                    newActivity2.putExtra("r1Int",I[position]);
                    startActivity(newActivity2);
                    break;
                case 3:
                    Intent newActivity3 = new Intent("com.example.mayank.mayyuu.play_record");
                    newActivity3.putExtra("Name", A[position]);
                    newActivity3.putExtra("r1Int",I[position]);
                    startActivity(newActivity3);
                    break;

                case 4:
                    Intent newActivity4 = new Intent("com.example.mayank.mayyuu.play_record");
                    newActivity4.putExtra("Name",A[position]);
                    newActivity4.putExtra("r1Int",I[position]);
                    startActivity(newActivity4);
                    break;
                case 5:
                    Intent newActivity5 = new Intent("com.example.mayank.mayyuu.play_record");
                    newActivity5.putExtra("Name",A[position]);
                    newActivity5.putExtra("r1Int",I[position]);
                    startActivity(newActivity5);
                    break;
                case 6:
                    Intent newActivity6 = new Intent("com.example.mayank.mayyuu.play_record");
                    newActivity6.putExtra("Name", A[position]);
                    newActivity6.putExtra("r1Int",I[position]);
                    startActivity(newActivity6);
                    break;
                case 7:
                    Intent newActivity7 = new Intent("com.example.mayank.mayyuu.play_record");
                    newActivity7.putExtra("Name",A[position]);
                    newActivity7.putExtra("r1Int",I[position]);
                    startActivity(newActivity7);
                    break;
                case 8:
                    Intent newActivity8 = new Intent("com.example.mayank.mayyuu.play_record");
                    newActivity8.putExtra("Name",A[position]);
                    newActivity8.putExtra("r1Int",I[position]);
                    startActivity(newActivity8);
                    break;
                case 9:
                    Intent newActivity9 = new Intent("com.example.mayank.mayyuu.play_record");
                    newActivity9.putExtra("Name",A[position]);
                    newActivity9.putExtra("r1Int", I[position]);
                    startActivity(newActivity9);
                    break;

            }}

    });

    OnClickButtonListner();
}


    public void OnClickButtonListner(){
        b = (Button) findViewById(R.id.b22);
        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                Intent intent = new Intent("com.example.mayank.mayyuu.shuffling");
                startActivity(intent);
            }
        });

        bu = (Button) findViewById(R.id.b11);
        bu.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                Intent intent = new Intent("com.example.mayank.mayyuu.sorting");
                startActivity(intent);
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}