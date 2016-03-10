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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityCountStockGas extends AppCompatActivity {

    private static final String EXTRA_COUNTNO ="countNo" ;
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_stockgas);

        int countNo = (Integer)getIntent().getExtras().get(EXTRA_COUNTNO);
        CheckBox favorite = (CheckBox)findViewById(R.id.favotite_stockgas);

        try{
            // получаем ссылку на базу для чтения и записи
            SQLiteOpenHelper gascountHelper = new SQLGasCountDatabaseHelper(this);
            db = gascountHelper.getWritableDatabase();
// создам курсор который читает имя метода и состояние избранного по id метода
            cursor = db.query("COUNT",
                    new String[]{"NAME", "FAVORITE"},
                    "_id = ?",
                    new String[]{Integer.toString(countNo)},
                    null, null,null);
            if(cursor.moveToFirst()){

                //забираем из курсора состояние флажка избранное
                boolean isFavorite = (cursor.getInt(1)==1);
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
       CheckBox favorite = (CheckBox)findViewById(R.id.favotite_stockgas);
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

    private double density;
    private double pressure;
    private double temperature;
    private double lenghth;
    private double diameter;
    private final double constPressure=1.033224597594;
    private final double constTemperature = 293.15;
    private final double PI = 3.1415926;

    public void count(View view)
    {
        EditText editText = (EditText) findViewById(R.id.plotnost);
        String text = editText.getText().toString();
        if (text == null || text.isEmpty())
            density = 0.0;
        else density = Double.valueOf(text);

        EditText editText2 = (EditText) findViewById(R.id.davlen);
        String text2 = editText2.getText().toString();
        if (text == null || text.isEmpty())
            pressure = 0.0;
        else pressure = Double.valueOf(text2);

        EditText editText3 = (EditText) findViewById(R.id.temp);
        String text3 = editText3.getText().toString();
        if (text == null || text.isEmpty())
            temperature = 0.0;
        else temperature = Double.valueOf(text3);

        EditText editText4 = (EditText) findViewById(R.id.dlina);
        String text4 = editText4.getText().toString();
        if (text == null || text.isEmpty())
            lenghth = 0.0;
        else lenghth = Double.valueOf(text4);

        EditText editText5 = (EditText) findViewById(R.id.diametr);
        String text5 = editText5.getText().toString();
        if (text == null || text.isEmpty())
            diameter = 0.0;
        else diameter = Double.valueOf(text5);

        Count count = new Count(density,temperature, pressure);

        double radius = (diameter/1000)/2;
        double volume = (PI*lenghth*((radius)*(radius)));

        double koefZ = count.getZ();
        double qasSupply = (volume*pressure*constTemperature)/((temperature+273.15)*koefZ*constPressure);









        TextView textSupply = (TextView) findViewById(R.id.supply);
        textSupply.setText(""+ (long) qasSupply);

    }

}
