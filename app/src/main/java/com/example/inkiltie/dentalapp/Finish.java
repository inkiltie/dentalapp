package com.example.inkiltie.dentalapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Finish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        TextView clinic = (TextView)findViewById(R.id.clinicRes);
        TextView procedure = (TextView)findViewById(R.id.procedureRes);
        TextView specialist = (TextView)findViewById(R.id.specialistRes);
        TextView date = (TextView)findViewById(R.id.dateRes);
        TextView time = (TextView)findViewById(R.id.timeRes);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String clinicRes = sharedPref.getString("Clinic", null);
        String procedureRes = sharedPref.getString("Procedure", null);
        String specialistRes = sharedPref.getString("Specialist", null);
        String dateRes = sharedPref.getString("Date", null);
        String timeRes = sharedPref.getString("Time", null);

        clinic.setText(clinicRes);
        procedure.setText(procedureRes);
        specialist.setText(specialistRes);
        date.setText(dateRes);
        time.setText(timeRes);
    }

    public void share(View v) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/intent/tweet?text=Hi!%20Check%20out%20this%20cool%20app%20for%20dental%20appointments!%20DentalApp%20is%20available%20for%20free%20on%20Android.")));
    }

    public void okay(View v) {
        startActivity(new Intent(Finish.this,MainActivity.class));
    }
}