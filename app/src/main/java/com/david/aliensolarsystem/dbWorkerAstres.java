package com.david.aliensolarsystem;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class dbWorkerAstres  extends AsyncTask
{
    private Context c ;

    public dbWorkerAstres(Context c)
    {
        this.c = c;
    }

    @Override
    protected Object doInBackground(Object[] param) {
        String cible = "http://10.1.0.50/PHP/getAstres.php";

        try
        {
            URL url = new URL (cible);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setDoInput(true);

            InputStream ins = con.getInputStream();
            BufferedReader bufr = new BufferedReader(new InputStreamReader(ins, "iso-8859-1"));
            String line;
            StringBuffer sbuff = new StringBuffer();

            while ((line = bufr.readLine()) != null)
            {
                sbuff.append(line);
            }
            return sbuff.toString();
        }
        catch (Exception ex)
        {
            return  ex.getMessage();
        }
    }

    @Override
    protected void onPostExecute(Object o)
    {
        Intent intentAstre = new Intent(this.c, AstresCelestes.class);
        intentAstre.putExtra("astres", o.toString());
        c.startActivity(intentAstre);
    }
}

