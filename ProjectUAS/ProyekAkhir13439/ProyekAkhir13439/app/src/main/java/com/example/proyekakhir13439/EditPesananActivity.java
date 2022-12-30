package com.example.proyekakhir13439;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditPesananActivity extends AppCompatActivity {

    EditText uploadNama, uploadTlp, uploadMerek, uploadWarna, uploadUkuran;
    Button updateButton, deleteButton;

    String id, nama, tlp, merek, warna, ukuran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pesanan);

        uploadNama = findViewById(R.id.uploadNama2);
        uploadTlp = findViewById(R.id.uploadTlp2);
        uploadMerek = findViewById(R.id.uploadMerek2);
        uploadWarna = findViewById(R.id.uploadWarna2);
        uploadUkuran = findViewById(R.id.uploadUkuran2);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(nama);
        }

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(EditPesananActivity.this);
                nama = uploadNama.getText().toString().trim();
                tlp = uploadTlp.getText().toString().trim();
                merek = uploadMerek.getText().toString().trim();
                warna = uploadWarna.getText().toString().trim();
                ukuran = uploadUkuran.getText().toString().trim();
                myDB.updateData(id, nama, tlp, merek, warna, ukuran);
            }
        });

        //ini harusnya ditampilan pilihan kalau mau hapus hapus data
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
//
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("nama") && getIntent().hasExtra("tlp") &&
                getIntent().hasExtra("merek") && getIntent().hasExtra("warna") && getIntent().hasExtra("ukuran")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            nama = getIntent().getStringExtra("nama");
            tlp = getIntent().getStringExtra("tlp");
            merek = getIntent().getStringExtra("merek");
            warna = getIntent().getStringExtra("warna");
            ukuran = getIntent().getStringExtra("ukuran");

            //Setting Intent Data
            uploadNama.setText(nama);
            uploadTlp.setText(tlp);
            uploadMerek.setText(merek);
            uploadWarna.setText(warna);
            uploadUkuran.setText(ukuran);
            Log.d("stev", nama+" "+tlp+" "+merek+" "+warna+" "+ukuran);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + nama + " ?");
        builder.setMessage("Are you sure you want to delete " + nama + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EditPesananActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}