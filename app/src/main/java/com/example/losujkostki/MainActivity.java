package com.example.losujkostki;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText editTextLiczbaKostek = findViewById(R.id.editTextLiczbaKostek);
        Button buttonLosuj = findViewById(R.id.buttonLosuj);
        GridLayout gridKostki = findViewById(R.id.gridKostki);
        TextView textViewWyniki = findViewById(R.id.textViewWyniki);
        Button buttonRosnaco = findViewById(R.id.buttonRosnaco);
        Button buttonMalejaco = findViewById(R.id.buttonMalejaco);


    }
}