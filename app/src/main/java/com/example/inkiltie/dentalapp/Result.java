package com.example.inkiltie.dentalapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView name = (TextView)findViewById(R.id.nameRes);
        TextView email = (TextView)findViewById(R.id.emailRes);
        TextView phone = (TextView)findViewById(R.id.phoneRes);
        TextView coverage = (TextView)findViewById(R.id.coverRes);
        TextView clinic = (TextView)findViewById(R.id.clinicRes);
        TextView procedure = (TextView)findViewById(R.id.procedureRes);
        TextView specialist = (TextView)findViewById(R.id.specialistRes);
        TextView date = (TextView)findViewById(R.id.dateRes);
        TextView time = (TextView)findViewById(R.id.timeRes);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String nameRes = sharedPref.getString("Name", null);
        String emailRes = sharedPref.getString("Email", null);
        String phoneRes = sharedPref.getString("Phone", null);
        String coverageRes = sharedPref.getString("Radio", null);
        String clinicRes = sharedPref.getString("Clinic", null);
        String procedureRes = sharedPref.getString("Procedure", null);
        String specialistRes = sharedPref.getString("Specialist", null);
        String dateRes = sharedPref.getString("Date", null);
        String timeRes = sharedPref.getString("Time", null);

        name.setText(nameRes);
        email.setText(emailRes);
        phone.setText(phoneRes);
        coverage.setText(coverageRes);
        clinic.setText(clinicRes);
        procedure.setText(procedureRes);
        specialist.setText(specialistRes);
        date.setText(dateRes);
        time.setText(timeRes);
    }

    public void modify(View v) {
        startActivity(new Intent(Result.this,MainActivity.class));
    }

    public void book(View v) {
        startActivity(new Intent(Result.this,Finish.class));
    }
}