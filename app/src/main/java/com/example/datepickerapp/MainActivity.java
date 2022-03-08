package com.example.datepickerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult;
    private Button btDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Kita menggunakan format tanggal dd-mm-yy
         * tanggal akan menjadi format 06-03-2022
         */
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        SimpleDateFormat formatOutgoing = new SimpleDateFormat("dd-MM-yyyy");
        TimeZone tz = TimeZone.getTimeZone("Asia/Jakarta");

        tvDateResult = (TextView) findViewById(R.id.tv_dateresult);
        btDatePicker = (Button) findViewById(R.id.bt_datepicker);
        btDatePicker.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showDateDiaolog();
            }
        });
    }

    private void showDateDiaolog(){

        /**
         * Calendar untuk mendapatkan tanggal sekarang
         */
        Calendar newCalendar = Calendar.getInstance();

        /**
         * Initiate DatePicker dialog
         */
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                /**
                 * Method dipanggil untuk menyelesaikan pemilihan tanggal di datepicker
                 */
                /**
                 * set calendar untuk menampung yang dipilih
                 */
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                /**
                 * Update TextView dengan tanggal yang kita pilih
                 */
                tvDateResult.setText("Tanggal Dipilih : " + dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        /**
         * Tampilkan DatePicker dialog
         */

        datePickerDialog.show();

    }
}