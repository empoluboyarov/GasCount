package com.example.evgeniy.gascount;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Activity22Favorite extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity22_favorite);

        ListView listFavorites = (ListView) findViewById(R.id.list_favorites);

        try {
            SQLiteOpenHelper countHelper = new SQLGasCountDatabaseHelper(this);
            db = countHelper.getReadableDatabase();

            cursor = db.query("COUNT",
                    new String[]{"_id", "NAME"},
                    "FAVORITE=1",
                    null, null, null, null);
            CursorAdapter favoriteAdapter = new SimpleCursorAdapter(Activity22Favorite.this,
                    android.R.layout.simple_list_item_1, cursor, new String[]{"NAME"},
                    new int[]{android.R.id.text1}, 0);
            listFavorites.setAdapter(favoriteAdapter);


        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }


    }


    @Override
    public void onDestroy(){
        db.close();
        cursor.close();
        super.onDestroy();
    }

}
