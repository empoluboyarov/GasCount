package com.example.evgeniy.gascount;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Activity25Methods extends ListActivity{

    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listCounts = getListView();

        try {
            SQLiteOpenHelper gasCountDatabaseHelper = new SQLGasCountDatabaseHelper(this);
            SQLiteDatabase db = gasCountDatabaseHelper.getReadableDatabase();

            cursor = db.query("COUNT", new String[]{"_id", "NAME"},
                    null, null, null, null, null);
            CursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"NAME"},
                    new int[]{android.R.id.text1},
                    0);
            listCounts.setAdapter(listAdapter);
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

        public void onDestroy(){
            super.onDestroy();
            cursor.close();
            db.close();
        }


        @Override
        public void onListItemClick(ListView listView,
                View itemView,
        int position,
        long id) {
            Intent intent = new Intent(Activity25Methods.this, Activity30Method.class);
            intent.putExtra(Activity30Method.EXTRA_COUNTNO, (int) id);
            startActivity(intent);
        }

    }
