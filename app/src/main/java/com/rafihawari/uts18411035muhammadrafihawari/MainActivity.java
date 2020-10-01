package com.rafihawari.uts18411035muhammadrafihawari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView txtTampil, txtNilai, txtGrade;
    EditText edtNama, edtNpm, edtMatkul, edtTugas, edtUts, edtUas;
    Button   btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTampil = (TextView) findViewById(R.id.txtHasil);
        edtNama   = (EditText) findViewById(R.id.edtNama);
        edtNpm    = (EditText) findViewById(R.id.edtNpm);
        edtMatkul = (EditText) findViewById(R.id.edtMatkul);
        edtTugas  = (EditText) findViewById(R.id.edtTugas);
        edtUts    = (EditText) findViewById(R.id.edtUts);
        edtUas    = (EditText) findViewById(R.id.edtUas);
        btnHitung = (Button) findViewById(R.id.btnHitung);
        txtGrade  = (TextView) findViewById(R.id.txtGrade);
        txtNilai  = (TextView) findViewById(R.id.txtTotalNilai);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNpm    = edtNpm.getText().toString();
                String strNama   = edtNama.getText().toString();
                String strMatkul = edtMatkul.getText().toString();
                String strGrade = txtGrade.getText().toString();
                String strTugas  = edtTugas.getText().toString().trim();
                String strUts    = edtUts.getText().toString().trim();
                String strUas    = edtUas.getText().toString().trim();

                double tugas   = Double.parseDouble(strTugas);
                double uts     = Double.parseDouble(strUts);
                double uas     = Double.parseDouble(strUas);
                double nilai   = (0.3 * tugas) + (0.3 * uts) + (0.4 * uas);


                if (nilai >= 80&&nilai<=100) {
                    strGrade = "A";
                } else if (nilai >= 70&&nilai<=80) {
                    strGrade = "B";
                } else if (nilai >= 60&&nilai<=70) {
                    strGrade = "C";
                } else if (nilai >= 50&&nilai<=60) {
                    strGrade = "D";
                } else {
                    strGrade = "E";
                }

                txtNilai.setText("NPM : " +strNpm + "\n" + "Nama : " +strNama + "\n" + "Mata Kuliah : " + strMatkul + "\n"   + "Grade : " + strGrade + "\n" + "Total Nilai : " + nilai );
            }
        });
    }
}