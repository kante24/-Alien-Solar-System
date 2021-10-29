package com.david.aliensolarsystem;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class AstresCelestes
    {
        private int positionX;
        private int positionY;
        private Paint crayon;
        private Color pinceau;
        private Random aleatoire;
        private int rayon;
        private boolean status;

        private static final int[] palette = {Color.BLUE,Color.GREEN,Color.MAGENTA,Color.YELLOW};


    public AstresCelestes() {


        status = true;
        aleatoire = new Random();
        positionX = aleatoire.nextInt(500);
        positionY = aleatoire.nextInt(500);

        crayon = new Paint();
        crayon.setAntiAlias(true);
        crayon.setColor(palette[aleatoire.nextInt(3)]);

        rayon = 30;


    }
        public boolean getStatus()
        {
            return this.status;
        }

        public void setStatus(Boolean state)
        {
            this.status = state;

            if (!this.status)
            {
                crayon.setColor(Color.TRANSPARENT);
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

        canvas.drawCircle(positionX, positionY, rayon, crayon);
    }
    }


