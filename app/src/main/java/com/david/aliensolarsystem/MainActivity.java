package com.david.aliensolarsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EcranDemarrage startScreen = new EcranDemarrage(this);
        setContentView(startScreen);
    }
}