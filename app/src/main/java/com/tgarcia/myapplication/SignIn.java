package com.tgarcia.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.View;
import android.content.Intent;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        /* Glide que carga en un ImageView una imagen pesada */

        //Crea el objeto ImageView
        ImageView fondo = findViewById(R.id.fondo_imagen_glide);
        //Adapta la imagen a la resolucion del sispositivo
        Glide.with(this)
                .load(R.drawable.demeter) //El que cargar
                .transition(DrawableTransitionOptions.withCrossFade(100))

                /* Cargar una URL
                .load("https://images.unsplash.com/photo-1565214975484-3cfa9e56f914?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1482&q=80")
                 */

                .centerCrop() //Coloca la imagen desde su centro cuando ocupa todo

                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_700_alpha015)))
                //.circleCrop() //Da forma de circulo

                .into(fondo); //Donde cargar
    }

    /* Método que se ejecuta al pulsar el botón SignIn y que lanza el Main */
    public void openMain(View v) {
        //Crear intent (accion)
        Intent intent = new Intent(SignIn.this, Main.class);
        //Define que al darle atras no vuelva al SignIn sino cierra la app
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //Lanza el intent
        startActivity(intent);
    }

    /* Método que se ejecuta al pulsar el texto y que lanza el SingUp */
    public void openSignUp(View v) {
        //Crear intent (accion)
        Intent intent = new Intent(SignIn.this, SignUp.class);
        //Lanza el intent
        startActivity(intent);
    }


}