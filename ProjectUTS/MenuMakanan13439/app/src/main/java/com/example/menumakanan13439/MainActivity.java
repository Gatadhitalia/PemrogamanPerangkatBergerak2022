package com.example.menumakanan13439;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recMakanan;
    private ArrayList<Menu> listMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recMakanan = findViewById(R.id.rec_makanan);
        initData();

        recMakanan.setAdapter(new MenuAdapter(listMakanan));
        recMakanan.setLayoutManager(new LinearLayoutManager(this));
    }
    private void initData(){
        this.listMakanan = new ArrayList<>();
        listMakanan.add(new Menu("Pecel Lele",
                "Rp. 15.000",
                "Nasi, lele, sambal, dan lalapan",
                R.drawable.pecel_lele));
        listMakanan.add(new Menu("Nasi Goreng Mercon",
                "Rp. 14.500",
                "Nasi goreng dengan rasa pedas mercon",
                R.drawable.nasi_goreng_mercon));
        listMakanan.add(new Menu("Ayam Geprek Keju",
                "Rp. 20.000",
                "Ayam geprek dengan tambahan keju mozarella",
                R.drawable.geprek_keju));
        listMakanan.add(new Menu("Kari ayam",
                "Rp. 17.500",
                "Kari ayam dengan nasi",
                R.drawable.kari_ayam));
        listMakanan.add(new Menu("Tahu bulat",
                "Rp. 500",
                "Tahu bulat dengan tambahan bumbu tabur diatasnya",
                R.drawable.tahu_bulat));
        listMakanan.add(new Menu("Salad Buah",
                "Rp. 12.000",
                "Salad dengan berbagai buah dengan tambahan keju",
                R.drawable.salad_buah));
    }
}