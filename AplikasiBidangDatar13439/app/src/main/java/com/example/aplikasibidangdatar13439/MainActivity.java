package com.example.aplikasibidangdatar13439;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fragmentPertama(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new PilihanPertama()).commit();
    }

    public void fragmentKedua(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new PilihanKedua()).commit();
    }

    public void fragmentKetiga(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new PilihanKetiga()).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new PilihanPertama()).commit();
    }
}