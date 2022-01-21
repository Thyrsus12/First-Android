package com.tgarcia.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splah_screen);

        /* Animación de las CardView */

        //Cargar la animacion en un objeto
        Animation scroll = AnimationUtils.loadAnimation(this, R.anim.bg_img_scroll);

        //Cargar cada CardView en un objeto
        CardView cv_poseidon = (CardView) findViewById(R.id.cv_poseidon);
        CardView cv_hestia = (CardView) findViewById(R.id.cv_hestia);
        CardView cv_hades = (CardView) findViewById(R.id.cv_hades);
        CardView cv_zeus = (CardView) findViewById(R.id.cv_zeus);
        CardView cv_demeter = (CardView) findViewById(R.id.cv_demeter);
        CardView cv_hera = (CardView) findViewById(R.id.cv_hera);

        //Aplicar a cada CardView la animación
        cv_poseidon.startAnimation(scroll);
        cv_hestia.startAnimation(scroll);
        cv_hades.startAnimation(scroll);
        cv_zeus.startAnimation(scroll);
        cv_demeter.startAnimation(scroll);
        cv_hera.startAnimation(scroll);

        /* Lamada al metodo de abajo que abre el SignIn */
        openApp(true);
    }

    /* Método para lanzar el SignIn */
    private void openApp(boolean locationPermission) {
        //Manejador que lanza el intent (acción) despues de 2500ms
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                //Define la acción de lanzar el SignIn desde el Splash
                Intent intent = new Intent(SplashScreen.this, SignIn.class);
                //Ejecuta la acción
                startActivity(intent);
            }
        }, 2500);
    }


}