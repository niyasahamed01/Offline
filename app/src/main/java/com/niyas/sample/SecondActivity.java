package com.niyas.sample;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView nameTextView, ageTextView, rollNumberTextView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameTextView = findViewById(R.id.name_text_view);
        ageTextView = findViewById(R.id.age_text_view);
        rollNumberTextView = findViewById(R.id.roll_number_text_view);

        // Retrieve data passed from the first activity
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("name") && intent.hasExtra("age") && intent.hasExtra("rollNumber")) {
            String name = intent.getStringExtra("name");
            int age = intent.getIntExtra("age", 0);
            int rollNumber = intent.getIntExtra("rollNumber", 0);

            // Display the retrieved data
            nameTextView.setText("Name: " + name);
            ageTextView.setText("Age: " + age);
            rollNumberTextView.setText("Roll Number: " + rollNumber);
        }
    }
}