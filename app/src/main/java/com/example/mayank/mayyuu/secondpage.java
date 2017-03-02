package com.example.mayank.mayyuu;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class secondpage extends AppCompatActivity {
    String[] mobileArray = {"Zara Si Dil Mein", "Baby", "Samjhawa", "Tum Mile", "Saibo",
            " Makes You Beautiful","Wildest Dreams","Love Me Like You Do","Way You Are","Emptiness"};
    Integer[] imgid = {
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
    private static Button b,bu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.content_loveme,R.id.refer, mobileArray);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                switch (position) {
                    case 0:
                        Intent newActivity = new Intent("com.example.mayank.mayyuu.play_record");
                        newActivity.putExtra("Name", mobileArray[position]);
                        newActivity.putExtra("r1Int",imgid[position]);
                        newActivity.putExtra("pos",position);
                        startActivity(newActivity);
                        break;
                    case 1:
                        Intent newActivity1 = new Intent("com.example.mayank.mayyuu.play_record");
                        newActivity1.putExtra("Name",  mobileArray[position]);
                        newActivity1.putExtra("r1Int",imgid[position]);
                        newActivity1.putExtra("pos",position);
                        startActivity(newActivity1);
                        break;
                    case 2:
                        Intent newActivity2 = new Intent("com.example.mayank.mayyuu.play_record");
                        newActivity2.putExtra("Name",  mobileArray[position]);
                        newActivity2.putExtra("r1Int",imgid[position]);
                        newActivity2.putExtra("pos",position);
                        startActivity(newActivity2);
                        break;
                    case 3:
                        Intent newActivity3 = new Intent("com.example.mayank.mayyuu.play_record");
                        newActivity3.putExtra("Name",  mobileArray[position]);
                        newActivity3.putExtra("r1Int",imgid[position]);
                        newActivity3.putExtra("pos",position);
                        startActivity(newActivity3);
                        break;

                    case 4:
                        Intent newActivity4 = new Intent("com.example.mayank.mayyuu.play_record");
                        newActivity4.putExtra("Name", mobileArray[position]);
                        newActivity4.putExtra("r1Int",imgid[position]);
                        newActivity4.putExtra("pos",position);
                        startActivity(newActivity4);
                        break;
                    case 5:
                        Intent newActivity5 = new Intent("com.example.mayank.mayyuu.play_record");
                        newActivity5.putExtra("Name",  mobileArray[position]);
                        newActivity5.putExtra("r1Int",imgid[position]);
                        newActivity5.putExtra("pos",position);
                        startActivity(newActivity5);
                        break;
                    case 6:
                        Intent newActivity6 = new Intent("com.example.mayank.mayyuu.play_record");
                        newActivity6.putExtra("Name",  mobileArray[position]);
                        newActivity6.putExtra("r1Int",imgid[position]);
                        newActivity6.putExtra("pos",position);
                        startActivity(newActivity6);
                        break;
                    case 7:
                        Intent newActivity7 = new Intent("com.example.mayank.mayyuu.play_record");
                        newActivity7.putExtra("Name",  mobileArray[position]);
                        newActivity7.putExtra("r1Int",imgid[position]);
                        newActivity7.putExtra("pos",position);
                        startActivity(newActivity7);
                        break;
                    case 8:
                        Intent newActivity8 = new Intent("com.example.mayank.mayyuu.play_record");
                        newActivity8.putExtra("Name",  mobileArray[position]);
                        newActivity8.putExtra("r1Int",imgid[position]);
                        newActivity8.putExtra("pos",position);
                        startActivity(newActivity8);
                        break;
                    case 9:
                        Intent newActivity9 = new Intent("com.example.mayank.mayyuu.play_record");
                        newActivity9.putExtra("Name",  mobileArray[position]);
                        newActivity9.putExtra("r1Int",imgid[position]);
                        newActivity9.putExtra("pos",position);
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

        bu= (Button) findViewById(R.id.b11);
        bu.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                Intent intent1 = new Intent("com.example.mayank.mayyuu.sorting");
                startActivity(intent1);
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
