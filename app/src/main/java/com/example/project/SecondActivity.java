package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        myPreferenceRef = getSharedPreferences("PreferenceString", MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        EditText editTextPref = findViewById(R.id.editTextPref);
        editTextPref.setText(myPreferenceRef.getString("PreferenceString", "No preference found."));

        TextView textView = findViewById(R.id.textView);
        textView.setText(myPreferenceRef.getString("PreferenceString", "No preference found."));

        Button backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StoreData();
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

     void StoreData(){
        EditText editText = findViewById(R.id.editTextPref);
        myPreferenceEditor.putString("PreferenceString", editText.getText().toString());
        myPreferenceEditor.apply();

    }
}