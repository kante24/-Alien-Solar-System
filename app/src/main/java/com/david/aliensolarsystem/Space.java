package com.david.aliensolarsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;

public class Space extends AppCompatActivity {

    private Random aleatoire;
    private Paint ballPaint;
    private int ballX;  //posX du vaisseau
    private int bally;  //posX du vaisseau
    private float ballRadius;   //Rayon du vaisseau
    private AstresCelestes[] planetes = new AstresCelestes[10];  //création planètes
    private int cnt;
    private Context myContext;
    private boolean fin;

    private ViewGroup layout;
    private ImageView fusee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space);
    }
}