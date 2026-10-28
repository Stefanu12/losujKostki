package com.example.losujkostki;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText editTextLiczbaKostek;
    Button buttonLosuj, buttonRosnaco, buttonMalejaco;
    GridLayout gridKostki;
    TextView textViewWyniki;

    ArrayList<Integer> wyniki = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLiczbaKostek = findViewById(R.id.editTextLiczbaKostek);
        buttonLosuj = findViewById(R.id.buttonLosuj);
        buttonRosnaco = findViewById(R.id.buttonRosnaco);
        buttonMalejaco = findViewById(R.id.buttonMalejaco);
        gridKostki = findViewById(R.id.gridKostki);
        textViewWyniki = findViewById(R.id.textViewWyniki);


        buttonLosuj.setOnClickListener(v -> {

            String tekst = editTextLiczbaKostek.getText().toString();

            if (tekst.isEmpty()) {
                Toast.makeText(this, "Podaj liczbe kostek", Toast.LENGTH_SHORT).show();
                return;
            }

            int liczba = Integer.parseInt(tekst);

            if (liczba < 1 || liczba > 100) {
                Toast.makeText(this, "Podaj liczbe od 1 do 100", Toast.LENGTH_SHORT).show();
                return;
            }

            wyniki.clear();
            Random ra = new Random();

            for (int i = 0; i < liczba; i++) {
                wyniki.add(ra.nextInt(6)+1);
            }

            wyswietlWyniki();
        });

        buttonRosnaco.setOnClickListener(v -> {

            if (wyniki.isEmpty()) {
                Toast.makeText(this, "Najpierw losuj kostki", Toast.LENGTH_SHORT).show();
                return;
            }

            for (int i = 0; i < wyniki.size() - 1; i++) {
                for (int j = 0; j < wyniki.size() - 1 - i; j++) {
                    if (wyniki.get(j) > wyniki.get(j + 1)) {
                        int pomoc = wyniki.get(j);
                        wyniki.set(j, wyniki.get(j + 1));
                        wyniki.set(j + 1, pomoc);
                    }
                }
            }
            wyswietlWyniki();
        });

        buttonMalejaco.setOnClickListener(v -> {

            if (wyniki.isEmpty()) {
                Toast.makeText(this, "Najpierw losuj kostki", Toast.LENGTH_SHORT).show();
                return;
            }

            for (int i = 0; i < wyniki.size() - 1; i++) {
                for (int j = 0; j < wyniki.size() - 1 - i; j++) {
                    if (wyniki.get(j) < wyniki.get(j + 1)) {
                        int pomoc = wyniki.get(j);
                        wyniki.set(j, wyniki.get(j + 1));
                        wyniki.set(j + 1, pomoc);
                    }
                }
            }
            wyswietlWyniki();
        });
    }

    void wyswietlWyniki() {

        gridKostki.removeAllViews();
        gridKostki.setColumnCount(5);

        for (int i = 0; i < wyniki.size(); i++) {
            TextView kostka = new TextView(this);
            kostka.setText(String.valueOf(wyniki.get(i)));
            gridKostki.addView(kostka);
        }

        textViewWyniki.setText(wyniki.toString());
    }
}

