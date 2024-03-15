package com.niyas.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.niyas.sample.room.RoomDatabaseManager;

public class MainActivity extends AppCompatActivity {
    private AppCompatEditText nameEditText, ageEditText, rollNumberEditText;
    private AppCompatButton insertButton;

    private RoomDatabaseManager roomDatabaseManager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.et_name);
        ageEditText = findViewById(R.id.et_age);
        rollNumberEditText = findViewById(R.id.et_rollNo);
        insertButton = findViewById(R.id.btn_save);

        roomDatabaseManager = RoomDatabaseManager.getInstance(getApplicationContext());

        insertButton.setOnClickListener(v -> insertData());

    }

    private void insertData() {
        String name = nameEditText.getText().toString().trim();
        String ageString = ageEditText.getText().toString().trim();
        String rollNumberString = rollNumberEditText.getText().toString().trim();

        if (name.isEmpty() || ageString.isEmpty() || rollNumberString.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int age = Integer.parseInt(ageString);
        int rollNumber = Integer.parseInt(rollNumberString);

        roomDatabaseManager.insertPerson(name, age, rollNumber);

        Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();

        // Pass the inserted data to the next activity
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("age", age);
        intent.putExtra("rollNumber", rollNumber);
        startActivity(intent);

        // Clear EditText fields after insertion
        nameEditText.getText().clear();
        ageEditText.getText().clear();
        rollNumberEditText.getText().clear();
    }


}