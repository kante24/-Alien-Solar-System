package com.david.aliensolarsystem;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.widget.Toast;
import android.view.View;

import java.util.Random;

public class Espace extends View {
    private Random aleatoire;
    private Paint ballPaint;
    private int ballX;  //posX du vaisseau
    private int bally;  //posX du vaisseau
    private float ballRadius;   //Rayon du vaisseau
    private AstresCelestes[] planetes = new AstresCelestes[10];  //création planètes
    private int cnt;
    private Context myContext;
    private boolean fin;


    public Espace(Context context)
    {
        super(context);
        myContext = context;

        fin = false;
        cnt =0;
        aleatoire = new Random();

        ballX = aleatoire.nextInt(500);
        bally = aleatoire.nextInt(500);

        //Création d'une balle a remplacé par le vaisseau spatial
        ballPaint = new Paint();
        ballPaint.setAntiAlias(true);
        ballPaint.setColor(Color.BLACK);

        for (int i=0;i<10;i++)
        {
            AstresCelestes temp = new AstresCelestes();
            planetes [i] = temp;
        }

        ballRadius = 30;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawCircle(ballX, bally, ballRadius, ballPaint);  //va dessiner la balle noir

        for (int i=0;i<10;i++)
        {
            planetes [i].onDraw(canvas);
        }

        if(cnt>=10 && !fin)
        {
            Toast.makeText(myContext,"La partie est terminee",Toast.LENGTH_LONG).show();
            fin = true;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int action = event.getAction();
        int touchX = (int)event.getX();
        int touchY = (int)event.getY();

        boolean limiteGauche,limiteDroite,LimiteBas,LimiteHaut = false;

        switch (action)
        {

            case MotionEvent.ACTION_MOVE:
                ballX = touchX;
                bally = touchY;

                for(int i =0;i<10;i++)
                {
                    limiteGauche = ballX > (planetes[i].getPosX()-30);
                    limiteDroite =  ballX < (planetes[i].getPosX()+30);
                    LimiteBas =  bally > (planetes[i].getPosY()-30);
                    LimiteHaut =  bally < (planetes[i].getPosY()+30);

                    if(limiteGauche && limiteDroite && LimiteHaut && LimiteBas )
                    {
                        if(planetes[i].getStatus())
                        {
                            planetes[i].setStatus(false);
                            cnt++;
                        }
                        System.out.println(cnt);
                    }
                }
                break;
        }
        invalidate();
        return true;
    }
}
