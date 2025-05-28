package com.example.myprogram2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText firstNameEditText, lastNameEditText;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameEditText = findViewById(R.id.t1);
        lastNameEditText = findViewById(R.id.t2);
        saveButton = findViewById(R.id.button);

        saveButton.setOnClickListener(v -> {
            String firstName = firstNameEditText.getText().toString().trim();
            String lastName = lastNameEditText.getText().toString().trim();
            String fullName = firstName + " " + lastName;

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("user_full_name", fullName);
            startActivity(intent);
        });
    }
}