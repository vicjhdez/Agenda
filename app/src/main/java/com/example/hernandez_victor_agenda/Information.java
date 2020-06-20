package com.example.hernandez_victor_agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Calendar;

public class Information extends AppCompatActivity implements View.OnClickListener{

    TextView t;
    TextView b;
    ImageView i;
    String body, title;
    int image;

    String longitud, latitud, direccion;


    TextView text1;
    private int year1, month1, day1, yearini, sMonthIni, sDayIni;
    static final int DATE_ID = 0;
    Calendar C = Calendar.getInstance();



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        t =  findViewById(R.id.text2);
        b =  findViewById(R.id.text1);
        i =  findViewById(R.id.image2);

        image =  getIntent().getIntExtra("Ima", 0);
        title = getIntent().getStringExtra("Title");
        body = getIntent().getStringExtra("Body");

        t.setText(title);
        b.setText(body);
        i.setImageResource(image);



        //MAPS
        String [] division = body.split("\n");
        String [] di= division [3].split(":");
        String [] la= division [4].split("=");
        String [] lo= division [5].split("=");

        direccion=di[1];
        latitud=la[1];
        longitud=lo[1];

        //calendar
        sMonthIni = C.get(Calendar.MONTH);
        sDayIni = C.get(Calendar.DAY_OF_MONTH);
        yearini = C.get(Calendar.YEAR);
        text1 =  findViewById(R.id.addb);

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(DATE_ID);
            }
        });
    }

    private void setdate() {
        text1.setText((month1 + 1) + "-" + day1 + "-" + year1+" ");
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    year1 = year;
                    month1 = monthOfYear;
                    day1 = dayOfMonth;
                    setdate();

                }

            };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, yearini, sMonthIni, sDayIni);

        }
        return null;
    }

    public void click2(View view) {

        Intent window3 = new Intent(this, MainActivity.class);
        startActivity(window3);

    }

    @Override
    public void onClick(View v) {


    }
    public void map(View view) {
        Intent window3 = new Intent(this, Maps.class);
        window3.putExtra("latitud", latitud);
        window3.putExtra("longitud", longitud);
        window3.putExtra("direccion", direccion);
        startActivity(window3);

    }


}
