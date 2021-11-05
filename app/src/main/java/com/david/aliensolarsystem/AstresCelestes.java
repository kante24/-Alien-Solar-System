package com.david.aliensolarsystem;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;

public class AstresCelestes extends View
{
    private int positionX;
    private int positionY;
    private Random aleatoire;
    private boolean status;

    private Bitmap venus = BitmapFactory.decodeResource(getResources(),R.drawable.venus);
    private Bitmap jupiter = BitmapFactory.decodeResource(getResources(),R.drawable.jupiter);
    private Bitmap earth = BitmapFactory.decodeResource(getResources(),R.drawable.earthe);
    private Bitmap pluton = BitmapFactory.decodeResource(getResources(),R.drawable.pluton);
    private Bitmap planete;

    private  final Bitmap[] planetes = {venus, jupiter, earth, pluton };


    public AstresCelestes(Context context) {
        super(context);

        status = true;
        aleatoire = new Random();
        positionX = aleatoire.nextInt(1000);
        positionY = aleatoire.nextInt(1000);
        planete = planetes[aleatoire.nextInt(3)];
    }public boolean getStatus()
{
    return this.status;
}

    public void setStatus(Boolean state)
    {
        this.status = state;

        if (!this.status)
        {
            planete.setDensity(2);
        }
    }
    public int getPosX()
    {

        return this.positionX;
    }

    public int getPosY()
    {
        return
                this.positionY;
    }



    protected void onDraw(Canvas canvas) {

        planete = Bitmap.createScaledBitmap(planete, 100, 100, true);
        canvas.drawBitmap(planete, positionX, positionY, null);
    }
}


