package com.example.evgeniy.gascount;

/**
 * Created by Evgeniy on 02.03.2016.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SQLGasCountDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "counts"; // Имя базы данных
    private static final int DB_VERSION = 2;

    SQLGasCountDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        updateMyDatabase(db, 0, DB_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }
// метод для заполнения таблицы
    private static void insertCount(SQLiteDatabase db, String name, String description, int resourceId) {
        ContentValues countValues = new ContentValues();
        countValues.put("NAME", name);
        countValues.put("DESCRIPTION", description);
        countValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("COUNT", null, countValues);
    }

    public void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){
        if (oldVersion < 1) {
// создание таблицы убрали из метода onCreate
            // создаем таблицу
            db.execSQL("CREATE TABLE COUNT (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            //заполняем таблицу данными
            insertCount(db, "Коэффициент сжимаемости природного газа", "Espresso and steamed milk", R.drawable.latte);
            insertCount(db, "Относительная плотность газа", "Espresso, hot milk and steamed-milk foam", R.drawable.cappuccino);
            insertCount(db, "Коэффициент адиабаты (формула Кобза):", "P - абсолютное давление газа,МПа;\n T - температура газа, по Кельвину;\n ρ - абсолютная плотность газа, кг/м3;\n xn - молярная составляющая азота.\n", R.drawable.filter);
            insertCount(db, "Запас газа в газопроводе", "Espresso and steamed milk", R.drawable.latte);
            insertCount(db, "Скорость звука в природном газе", "Espresso and steamed milk", R.drawable.latte);
            insertCount(db, "Фактическая плотность газа в газопроводе", "Espresso and steamed milk", R.drawable.latte);
            insertCount(db, "Среднее давление газа", "Espresso and steamed milk", R.drawable.latte);
            insertCount(db, "Средняя температура газа", "Espresso and steamed milk", R.drawable.latte);
            insertCount(db, "Пропускная способность участка газопровода", "Espresso and steamed milk", R.drawable.latte);
            insertCount(db, "Коэффициент гидравлической эффективности", "Espresso and steamed milk", R.drawable.latte);
            insertCount(db, "Скорость истечения газа в атмосферу", "Espresso and steamed milk", R.drawable.latte);
            insertCount(db, "Скорость течения газа", "Espresso and steamed milk", R.drawable.latte);
            insertCount(db, "Массовый расход газа", "Espresso and steamed milk", R.drawable.latte);
            insertCount(db, "Продувка оборудования", "Espresso and steamed milk", R.drawable.latte);
            insertCount(db, "Запас газа в действующем магистральном газопроводе", "Espresso and steamed milk", R.drawable.latte);
            insertCount(db, "Гидравлическая эффективность магистрального газопровода", "Espresso and steamed milk", R.drawable.latte);
        }

        if (oldVersion < 3) {
//Код, выполняемый для версии 1 или 2
            db.execSQL("ALTER TABLE COUNT ADD COLUMN FAVORITE NUMERIC;");
        }
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 3) {
//Код, выполняемый для версии 3
        }
    }
}
