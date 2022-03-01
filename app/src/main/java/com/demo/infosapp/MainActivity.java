package com.demo.infosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private  EditText Localisation ;
    private  EditText TextShare ;
    private Button MapsBtn ;
    private Button ShareBtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextShare =findViewById(R.id.TextShare);
        Localisation=findViewById(R.id.Localisation);

        MapsBtn = findViewById(R.id.button2);
        MapsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:0, 0?q="+Localisation.getText().toString());//47.4925,19.0513
                Intent i = new Intent(Intent.ACTION_VIEW,uri);
                i.setPackage("com.google.android.apps.maps");
                startActivity(i);
            }
        });
        ShareBtn= findViewById(R.id.button3);
        ShareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT,TextShare.getText().toString() );
                shareIntent.setType("text/plain");
                shareIntent = Intent.createChooser(shareIntent,"share via: ");
                startActivity(shareIntent);
            }
        });
    }

}