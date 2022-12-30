package com.example.proyekakhir13439;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TambahPesananActivity extends AppCompatActivity {

    EditText uploadNama, uploadTlp, uploadMerek, uploadWarna, uploadUkuran;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pesanan);

        uploadNama = findViewById(R.id.uploadNama);
        uploadTlp = findViewById(R.id.uploadTlp);
        uploadMerek = findViewById(R.id.uploadMerek);
        uploadWarna = findViewById(R.id.uploadWarna);
        uploadUkuran = findViewById(R.id.uploadUkuran);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(TambahPesananActivity.this);
                myDB.addPesanan(uploadNama.getText().toString().trim(),
                        uploadTlp.getText().toString().trim(),
                        uploadMerek.getText().toString().trim(),
                        uploadWarna.getText().toString().trim(),
                        uploadUkuran.getText().toString().trim());
            }
        });
    }
}