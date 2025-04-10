package com.example.dialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import android.widget.TimePicker;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btn=findViewById(R.id.button);
        Button btn2=findViewById(R.id.button2);
        Button btn3=findViewById(R.id.button3);

        btn.setOnClickListener(v-> showAlertDialog());
        btn2.setOnClickListener(v-> showListDialog());
        btn3.setOnClickListener(v-> showDatePickerDialog());


    }
    private  void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Prosty Alertdialog");
        builder.setMessage("Przykladowa wiadomosc");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"kliknięto OK",Toast.LENGTH_LONG).show();

            }
        });

        builder.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"kliknięto Anuluj",Toast.LENGTH_LONG).show();
            }
        });
        builder.create().show();
    }

    private void showListDialog(){
        final  String[] items = {"Opcja 1","Opcja 2","Opcja 3","Opcja 4","Opcja 5"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("wybierz opcje:");

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Wybrano " + items[which],Toast.LENGTH_LONG).show();
            }
        });
        builder.create().show();
    }
    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dataPickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this, "Wybrana dat: " + dayOfMonth + "/" + (month+1)
                        + "/" + year, Toast.LENGTH_SHORT).show();
            }
        }, year, month, day);

        dataPickerDialog.show();
    }
    private void showTimePickerDialog(){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hour, int min) {
                Toast.makeText(MainActivity.this, " sef ae"
                        + hour + "da"+ min, Toast.LENGTH_SHORT.show();
            }
        }, hour , min, true);
        timePickerDialog.show();
    }

}