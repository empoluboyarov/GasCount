package com.example.evgeniy.gascount;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class Activity30Method extends Activity {

//переменая задающая номер выбранного метода
    public static final String EXTRA_COUNTNO = "countNo";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity30_method);

//Получение Номера метода выбранного пользователем из интента
        int countNo = (Integer)getIntent().getExtras().get(EXTRA_COUNTNO);

//создание курсора
        try{
            SQLiteOpenHelper gasCountDatabaseHelper = new SQLGasCountDatabaseHelper(this);
            SQLiteDatabase db = gasCountDatabaseHelper.getReadableDatabase();

            Cursor cursor = db.query("COUNT",
                    new String[] {"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    "_id = ?",
                    new String[] {Integer.toString(countNo)},
                    null, null,null);
            if(cursor.moveToFirst()){
//получаем данные по методу расчета из курсора
                String nameCount = cursor.getString(0);
                String descriptionCount = cursor.getString(1);
                int photoID = cursor.getInt(2);
//используя полученные данные заполняем значения представлений

                TextView name = (TextView) findViewById(R.id.nameCount);
                name.setText(nameCount);

                TextView description = (TextView)findViewById(R.id.descriptionCount);
                description.setText(descriptionCount);

                ImageView photo = (ImageView)findViewById(R.id.photoCount);
                photo.setImageResource(photoID);
                photo.setContentDescription(nameCount);
//закрываем курсор и базу данных
                cursor.close();
                db.close();
            }
        }
        //ловим исключение
        catch(SQLiteException e){
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
