package com.david.aliensolarsystem;

import android.graphics.Bitmap;
import android.os.AsyncTask;

public class classAstres {
    private String nom;
    private String couleur;
    private int taille;
    private Boolean statu;
    private Bitmap image;

    public classAstres(String nom, String couleur, int taille, Boolean status, Bitmap image) {
        this.nom = nom;
        this.couleur = couleur;
        this.taille = taille;
        this.statu = status;
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public Boolean getStatu() {
        return statu;
    }

    public void setStatus(Boolean status) {
        this.statu = status;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }


}
