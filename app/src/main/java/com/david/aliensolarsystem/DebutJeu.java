package com.david.aliensolarsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DebutJeu extends AppCompatActivity {

    private Espace Espace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Espace = new Espace(this);

        setContentView(Espace);
    }
}