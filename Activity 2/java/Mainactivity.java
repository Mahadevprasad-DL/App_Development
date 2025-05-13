package com.example.mydialog;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        btn = findViewById(R.id.btn2); 

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Message");
                builder.setIcon(R.drawable.exit);
                builder.setMessage("Are you sure to quit?");
                builder.setPositiveButton("Yes", (dialog, which) -> {
                    finish(); // Close the activity
                });
                builder.setNegativeButton("No", (dialog, which) -> {
                    dialog.cancel(); // Dismiss the dialog
                });
                builder.setNeutralButton("Cancel", (dialog, which) -> {
                    dialog.cancel(); // Dismiss the dialog
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}