package com.example.menumakanan13439;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMakananActivity extends AppCompatActivity {
    String nama, harga, deskripsi;
    int gambar;
    TextView dtl_makanan, dtl_harga, dtl_deskripsi;
    ImageView dtl_gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            nama = bundle.getString("nama");
            harga = bundle.getString("harga");
            deskripsi = bundle.getString("deskripsi");
            gambar = bundle.getInt("gambar");
        }

        dtl_makanan = findViewById(R.id.dtl_makanan);
        dtl_makanan.setText(nama);

        dtl_deskripsi = findViewById(R.id.dtl_deskripsi);
        dtl_deskripsi.setText(deskripsi);

        dtl_harga = findViewById(R.id.dtl_harga);
        dtl_harga.setText(harga);

        dtl_gambar = findViewById(R.id.dtl_gambar);
        dtl_gambar.setImageResource(gambar);
    }
}