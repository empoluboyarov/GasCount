package com.example.evgeniy.gascount;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class Activity21Counts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity21_counts);

        AdapterView.OnItemClickListener itemClickListener2 = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView,
                                    View itemView,
                                    int position,
                                    long id) {
                if (position == 0) {
                    Intent intent = new Intent(Activity21Counts.this, ActivityCountStockGas.class);
                    intent.putExtra(Activity30Method.EXTRA_COUNTNO, 4);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(Activity21Counts.this, ActivityCountRelativeDensity.class);
                    intent.putExtra(Activity30Method.EXTRA_COUNTNO, 2);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(Activity21Counts.this, ActivityCountCompressibilityFactor.class);
                    intent.putExtra(Activity30Method.EXTRA_COUNTNO, 1);
                    startActivity(intent);
                }
            }
        };
        ListView listView = (ListView) findViewById(R.id.counts_list);
        listView.setOnItemClickListener(itemClickListener2);
    }
}