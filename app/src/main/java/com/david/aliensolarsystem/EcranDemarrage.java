package com.david.aliensolarsystem;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class EcranDemarrage extends View {

    private int largeurEcran;
    private int longueurEcran;
    private Bitmap imageAccueil;
    private Bitmap btnCommencer;
    private Bitmap btnCommencerEffetBoutonClic;
    private boolean playBtnState;
    private Context MyContext;


    @Override
    protected void onSizeChanged(int largeur, int longueur, int ancienneLargeur, int ancienneLogueur) {
        super.onSizeChanged(largeur, longueur, ancienneLargeur, ancienneLogueur);
        largeurEcran = largeur;
        longueurEcran = longueur;
    }


    public EcranDemarrage(Context context) {
        super(context);
        MyContext = context;
        imageAccueil = BitmapFactory.decodeResource(getResources(),R.drawable.logo);
        btnCommencer = BitmapFactory.decodeResource(getResources(),R.drawable.play_3);
        btnCommencerEffetBoutonClic = BitmapFactory.decodeResource(getResources(),R.drawable.play_2);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(imageAccueil, (largeurEcran-imageAccueil.getWidth())/2,(int)(longueurEcran*0.10), null);
        if (playBtnState) {canvas.drawBitmap(btnCommencer, (largeurEcran-btnCommencerEffetBoutonClic.getWidth())/2,
                (int)(longueurEcran*0.75), null);
        } else {
            canvas.drawBitmap(btnCommencer,
                    (largeurEcran-btnCommencer.getWidth())/2,
                    (int)(longueurEcran*0.75), null);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int action = event.getAction();
        int touchX = (int)event.getX();
        int touchY = (int)event.getY();

        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                if ((touchX > (largeurEcran-btnCommencer.getWidth())/2 &&
                        touchX< ((largeurEcran-btnCommencer.getWidth())/2) +
                                btnCommencer.getWidth())&& ((touchY > (int)(longueurEcran*0.75)) &&
                        (touchY < ((int)(longueurEcran*0.75) +
                                btnCommencer.getHeight())))) {
                    playBtnState = true;
                }

                break;

            case MotionEvent.ACTION_UP:
                if(playBtnState)
                {
                    Intent gameIntent = new Intent(MyContext,DebutJeu.class);
                    MyContext.startActivity(gameIntent);
                }
                playBtnState = false;

                break;

            case MotionEvent.ACTION_MOVE:

                break;


        }
        invalidate();
        return true;
    }
}
