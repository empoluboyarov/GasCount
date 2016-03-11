package com.example.evgeniy.gascount;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Activity1Main extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_main);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView,
                                    View itemView,
                                    int position,
                                    long id) {
                if (position == 0) {
                    Intent intent = new Intent(Activity1Main.this, Activity21Counts.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(Activity1Main.this, Activity22Favorite.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(Activity1Main.this, Activity23Converter.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(Activity1Main.this, Activity24Dewpoint.class);
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(Activity1Main.this, Activity25Methods.class);
                    startActivity(intent);
                }
            }
        };

        ListView listView = (ListView) findViewById(R.id.main_list);
        listView.setOnItemClickListener(itemClickListener);

    }
}