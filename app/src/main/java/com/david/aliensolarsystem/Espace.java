package com.david.aliensolarsystem;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.widget.Toast;
import android.view.View;

import java.util.Random;

public class Espace extends View {
    private Random aleatoire;
    private Bitmap fusee;
    private int posXFusee;
    private int posYFusee;
    private AstresCelestes[] planetes = new AstresCelestes[05];  //création planètes
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

        fusee = BitmapFactory.decodeResource(getResources(),R.drawable.fusee);
        posXFusee = aleatoire.nextInt(500);
        posXFusee = aleatoire.nextInt(500);

        //Création planètes
        for (int i=0;i<5;i++)
        {
            AstresCelestes temp = new AstresCelestes(myContext);
            planetes [i] = temp;
        }
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        //Redimention du vaisseau
        fusee = Bitmap.createScaledBitmap(fusee, 500, 500, true);
        canvas.drawBitmap(fusee, posXFusee, posYFusee, null);  //va dessiner le vaisseau

        for (int i=0;i<5;i++)
        {
            planetes [i].draw(canvas);
        }


        //Fin de la partie
        if(cnt>=5 && !fin)
        {
            Toast.makeText(myContext,"Vous avez colonisé toutes les planètes habitables",Toast.LENGTH_LONG).show();
            fin = true;
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int action = event.getAction();
//        int touchX = (int)event.getX();
//        int touchY = (int)event.getY();


        boolean limiteGauche,limiteDroite,LimiteBas,LimiteHaut = false;

        switch (action)
        {

            case MotionEvent.ACTION_MOVE:

                //Positionner le vaisseau sur le curseur
                posXFusee = (int)event.getX();
                posYFusee = (int)event.getY();
//                Toast.makeText(myContext,"x fusee = " + posXFusee + "y fusee = " + posYFusee,Toast.LENGTH_LONG).show();
//                Toast.makeText(myContext,"x = " + event.getX() + "y = " + event.getY(),Toast.LENGTH_LONG).show();


                for(int i =0;i<5;i++)
                {

                    limiteGauche = posXFusee > (planetes[i].getPosX()-30);
                    limiteDroite =  posXFusee < (planetes[i].getPosX()+30);
                    LimiteBas =  posYFusee > (planetes[i].getPosY()-30);
                    LimiteHaut =  posYFusee < (planetes[i].getPosY()+30);

                    if(limiteGauche && limiteDroite && LimiteHaut && LimiteBas )
                    {
                        if(planetes[i].getStatus())
                        {
                            planetes[i].setStatus(false);
                            cnt++;
                            Toast.makeText(myContext,"PLanète colonisée",Toast.LENGTH_LONG).show();
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
