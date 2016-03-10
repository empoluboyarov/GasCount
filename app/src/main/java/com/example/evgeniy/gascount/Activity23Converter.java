package com.example.evgeniy.gascount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Activity23Converter extends AppCompatActivity {

    double number;
    double itognumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity23_converter);
    }

    public void onButtonClickedConvert (View view){

        // забираем исходную размерность
        Spinner spinner = (Spinner) findViewById(R.id.spinner_converter);
        String razmer = String.valueOf(spinner.getSelectedItem());
        // забираем исходное число
        EditText editText = (EditText) findViewById(R.id.convert_number);
        String text = editText.getText().toString();
        if (text == null || text.isEmpty())
            number = 0.0;
        else number = Double.valueOf(text);
        //забираем конечную величину конвертации
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_conveter);
        int id = radioGroup.getCheckedRadioButtonId();
        Convert convert = new Convert(id, razmer,number);
        itognumber = convert.getItognumber();
        //выводим сконвертированное значение на экран
        TextView textSupply = (TextView) findViewById(R.id.convert_result);

        textSupply.setText(""+ itognumber);
    }
}
