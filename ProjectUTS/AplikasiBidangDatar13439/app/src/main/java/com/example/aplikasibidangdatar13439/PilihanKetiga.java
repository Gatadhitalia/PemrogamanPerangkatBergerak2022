package com.example.aplikasibidangdatar13439;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PilihanKetiga extends Fragment {
    private Button btnHasil;
    private EditText txt_diameter;
    private TextView hasil, hasil1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.pilihan_ketiga, container, false);
        btnHasil = v.findViewById(R.id.btnHasil);
        txt_diameter = v.findViewById(R.id.txt_diameter);
        hasil = v.findViewById(R.id.hasil);
        hasil1 = v.findViewById(R.id.hasil1);
        btnHasil.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                String nilai = txt_diameter.getText().toString();
                if (nilai.isEmpty()){
                    txt_diameter.setError("Data tidak boleh kosong");
                    txt_diameter.requestFocus();
                }else {
                    Double diameter = Double.parseDouble(nilai);
                    Double luas = 0.25 * 3.14 * (diameter * diameter) ;
                    Double keliling = 3.14 * diameter;
                    hasil.setText(String.format("%.2f",luas));
                    hasil1.setText(String.format("%.2f",keliling));
                }
            }

        });

        return v;
    }
}
