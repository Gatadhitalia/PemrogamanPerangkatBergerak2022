package com.example.biodata13439;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openMaps(View v){
        Uri gmmIntentUri = Uri.parse("geo:-7.146258635363393, 110.40865283129462?q=-7.146258635363393, 110.40865283129462(rumahku)");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void openContact(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:085740879323"));
        startActivity(intent);
    }

    public void openEmail(View v){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "1112021113439@dinus.ac.id");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Aplikasi Biodata email");
        startActivity(intent);
    }
}