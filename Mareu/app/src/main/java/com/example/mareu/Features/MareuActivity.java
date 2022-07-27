package com.example.mareu.Features;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mareu.R;

public class MareuActivity extends AppCompatActivity implements Mareu.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mareu);
    }
}