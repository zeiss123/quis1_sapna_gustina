package com.sapna.quis1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nilai_tugas, nilai_quis, nilai_uts, nilai_uas;
    Button proses_hitung, bersihkan;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nilai_tugas = (EditText) findViewById(R.id.nilai_tugas);
        nilai_quis = (EditText) findViewById(R.id.nilai_quis);
        nilai_uts = (EditText) findViewById(R.id.nilai_uts);
        nilai_uas = (EditText) findViewById(R.id.nilai_uas);


        proses_hitung = (Button) findViewById(R.id.proses_hitung);
        bersihkan = (Button) findViewById(R.id.bersihkan);

        hasil = (TextView) findViewById(R.id.hasil);

        proses_hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((nilai_tugas.getText().length() > 0) && (nilai_quis.getText().length() > 0) && (nilai_uts.getText().length() > 0)  && (nilai_uas.getText().length() > 0)) {
                    double angka1 = Double.parseDouble(nilai_tugas.getText().toString());
                    double angka2 = Double.parseDouble(nilai_quis.getText().toString());
                    double angka3 = Double.parseDouble(nilai_uts.getText().toString());
                    double angka4 = Double.parseDouble(nilai_uas.getText().toString());
                    double result = angka1 * 20 / 100 + angka2 * 20 / 100 + angka3 * 30 / 100 + angka4 * 30 / 100;
                    hasil.setText(Double.toString(result));
                } else {
                    Toast toast = Toast.makeText(MainActivity.this, "Mohon masukkan semua data", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        bersihkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai_tugas.setText("");
                nilai_quis.setText("");
                nilai_uts.setText("");
                nilai_uas.setText("");
                hasil.setText("0");
                nilai_tugas.requestFocus();
            }
        });

    }
}