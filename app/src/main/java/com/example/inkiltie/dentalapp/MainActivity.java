package com.example.inkiltie.dentalapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView date;
    private TextView time;

    String clinicRes;
    String procedureRes;
    String specialistRes;
    String dateRes;
    String timeRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner clinic = (Spinner)findViewById(R.id.clinic);
        final Spinner procedure = (Spinner)findViewById(R.id.procedure);
        final Spinner specialist = (Spinner)findViewById(R.id.specialist);
        date = (TextView) findViewById(R.id.date);
        time = (TextView) findViewById(R.id.time);
        LinearLayout button = (LinearLayout) findViewById(R.id.button);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, d, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        time.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new TimePickerDialog(MainActivity.this, t, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), false).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                clinicRes = clinic.getSelectedItem().toString();
                procedureRes = procedure.getSelectedItem().toString();
                specialistRes = specialist.getSelectedItem().toString();
                dateRes = date.getText().toString();
                timeRes = time.getText().toString();

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("Clinic", clinicRes);
                editor.putString("Procedure", procedureRes);
                editor.putString("Specialist", specialistRes);
                editor.putString("Date", dateRes);
                editor.putString("Time", timeRes);
                editor.commit();

                if(dateRes.equals("Select appropriate date")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please, pick appropriate date", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 245);
                    toast.show();
                }
                else if(timeRes.equals("Choose appropriate time")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please, pick appropriate time", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 245);
                    toast.show();
                }
                else {
                    startActivity(new Intent(MainActivity.this,PersonalData.class));
                }
            }
        });

        final String[] specs1 = getResources().getStringArray(R.array.specAt);
        final String[] specs2 = getResources().getStringArray(R.array.specBu);
        final String[] specs3 = getResources().getStringArray(R.array.specDo);
        final String[] specs4 = getResources().getStringArray(R.array.specIr);
        final String[] specs5 = getResources().getStringArray(R.array.specKi);
        final String[] specs6 = getResources().getStringArray(R.array.specMa);
        final String[] specs7 = getResources().getStringArray(R.array.specPa);

        clinic.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                switch (position) {
                    case 0:
                        ArrayAdapter<String> clinic1 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, specs1);
                        clinic1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        specialist.setAdapter(clinic1);
                        break;
                    case 1:
                        ArrayAdapter<String> clinic2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, specs2);
                        clinic2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        specialist.setAdapter(clinic2);
                        break;
                    case 2:
                        ArrayAdapter<String> clinic3 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, specs3);
                        clinic3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        specialist.setAdapter(clinic3);
                        break;
                    case 3:
                        ArrayAdapter<String> clinic4 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, specs4);
                        clinic4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        specialist.setAdapter(clinic4);
                        break;
                    case 4:
                        ArrayAdapter<String> clinic5 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, specs5);
                        clinic5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        specialist.setAdapter(clinic5);
                        break;
                    case 5:
                        ArrayAdapter<String> clinic6 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, specs6);
                        clinic6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        specialist.setAdapter(clinic6);
                        break;
                    case 6:
                        ArrayAdapter<String> clinic7 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, specs7);
                        clinic7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        specialist.setAdapter(clinic7);
                        break;
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {}
        });
    }

    Calendar c = Calendar.getInstance();
    DateFormat fmtDate = DateFormat.getDateInstance(DateFormat.LONG);
    DateFormat fmtTime = DateFormat.getTimeInstance(DateFormat.SHORT);

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, monthOfYear);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            date.setText(fmtDate.format(c.getTime()));
        }
    };

    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            c.set(Calendar.HOUR_OF_DAY, hourOfDay);
            c.set(Calendar.MINUTE, minute);
            time.setText(fmtTime.format(c.getTime()));
        }
    };
}