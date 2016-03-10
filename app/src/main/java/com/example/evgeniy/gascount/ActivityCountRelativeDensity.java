package com.example.evgeniy.gascount;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityCountRelativeDensity extends AppCompatActivity {
    private static final String EXTRA_COUNTNO ="countNo" ;
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_relative_density);
        int countNo = (Integer)getIntent().getExtras().get(EXTRA_COUNTNO);

        try{
            SQLiteOpenHelper gascountHelper = new SQLGasCountDatabaseHelper(this);
            db = gascountHelper.getWritableDatabase();

            cursor = db.query("COUNT",
                    new String[]{"NAME", "FAVORITE"},
                    "_id = ?",
                    new String[]{Integer.toString(countNo)},
                    null, null,null);
            if(cursor.moveToFirst()){

                //забираем из курсора состояние флажка избранное
                boolean isFavorite = (cursor.getInt(1)==1);
                CheckBox favorite = (CheckBox)findViewById(R.id.favotite_density);
                favorite.setChecked(isFavorite);
                db.close();
                cursor.close();
            }
        }
        catch (SQLiteException e){Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();};
    }

    public void onFavoriteClicked (View view){
        int countNo = (Integer)getIntent().getExtras().get(EXTRA_COUNTNO);
        CheckBox favorite = (CheckBox)findViewById(R.id.favotite_density);
        ContentValues countValues = new ContentValues();
        countValues.put("FAVORITE",favorite.isChecked());
        try{
            SQLiteOpenHelper gascountHelper = new SQLGasCountDatabaseHelper(this);

            db = gascountHelper.getWritableDatabase();
            db.update("COUNT", countValues,
                    "_id=?", new String[]{Integer.toString(countNo)});
            db.close();
        }
        catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();}
    }
}
