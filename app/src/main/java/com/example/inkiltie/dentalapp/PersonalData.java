package com.example.inkiltie.dentalapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PersonalData extends AppCompatActivity {

    String nameRes;
    String emailRes;
    String phoneRes;
    String radioRes;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);

        final EditText name = (EditText)findViewById(R.id.editText1);
        final EditText email = (EditText)findViewById(R.id.editText2);
        final EditText phone = (EditText)findViewById(R.id.editText3);
        final RadioGroup radioG = (RadioGroup)findViewById(R.id.radioG);
        LinearLayout button = (LinearLayout)findViewById(R.id.save);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int selectedId = radioG.getCheckedRadioButtonId();

                radioButton = (RadioButton)findViewById(selectedId);

                nameRes = name.getText().toString();
                emailRes = email.getText().toString();
                phoneRes = phone.getText().toString();
                radioRes = radioButton.getText().toString();

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("Name", nameRes);
                editor.putString("Email", emailRes);
                editor.putString("Phone", phoneRes);
                editor.putString("Radio", radioRes);
                editor.commit();

                if(nameRes.equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please, enter your full name", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 245);
                    toast.show();
                }
                else if(emailRes.equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please, enter your email address", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 245);
                    toast.show();
                }
                else if(phoneRes.equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please, enter your phone number", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 245);
                    toast.show();
                }
                else {
                    startActivity(new Intent(PersonalData.this,Result.class));
                }
            }
        });
    }
}