package com.tgarcia.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class Main extends AppCompatActivity {

    //Crear objetos SwipeRefresh y WebView
    private SwipeRefreshLayout swipeLayout;
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializar el objeto SwipeRefresh
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        /* WebView */
        //Inicializar el objeto WebView
        myWebView = (WebView) findViewById(R.id.myWebView);
        //Recoge la configuracion que tenga la web a cargar
        WebSettings webSettings = myWebView.getSettings();
        //Permite que se carge el JavaScript de la web (por defecto no carga)
        webSettings.setJavaScriptEnabled(true);
        //myWebVisor.getSettings().setBuiltInZoomControls(true);
        //Cargar la web desde URL
        myWebView.loadUrl("https://thischemicaldoesnotexist.com");

        /* Menu contextual */
        //Aplica el menú contextual al WebView
        WebView mycontext = (WebView) findViewById(R.id.myWebView);
        registerForContextMenu(mycontext);
    }

    /* SwipeRefresh */
    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            //Caundo se refresca genera un toast
            Toast toast = Toast.makeText(Main.this, "Chemical updated!", Toast.LENGTH_LONG);
            toast.show();
            //Actualiza la pagina
            myWebView.reload();
            //A false evita que le simbolo de refresh se quede girando
            swipeLayout.setRefreshing(false);
        }
    };

    /* Menu barra de acción LOS MENUS SE CREAN EN UN XML (menu_top.xml) */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Genera el menú de arriba   ??this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_top, menu);
        return true;
    }

    /* Acciones menu barra de accion*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Maneja las acción que tiene que realizar cada boton del menú cuando lo pulsamos
        // The action bar will automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //Recoge el id del boton que hemos pulsado
        int id = item.getItemId();

        //Se ejecuta el if que coincida con el id
        if (id == R.id.item1) {
            //Genera un toast y lo muestra
            Toast toast = Toast.makeText(this, "Opened in explorer", Toast.LENGTH_LONG);
            toast.show();

        }
        if (id == R.id.item2) {
            //Genera un toast y lo muestra
            Toast toast = Toast.makeText(this, "Downloaded", Toast.LENGTH_LONG);
            toast.show();
        }
        if (id == R.id.item3) {
            //Lllama al metodo que genera la notificación
            showAlertDialogButtonClicked(Main.this);
        }

        return super.onOptionsItemSelected(item);
    }

    /* Notificación */
    public void showAlertDialogButtonClicked(Main mainActivity) {
        //Crear el generador de la notificación
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        //Definir un titulo
        builder.setTitle("Notificación");
        //Definir un mensaje
        builder.setMessage("Do you like the aplication?");
        //Define un icono antes del titulo
        builder.setIcon(R.drawable.pencil_foreground);

        /*
        un XML a medida para el diálogo
        builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view,null));
        */

        //Opciones del menú
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); //Hace desaparecer el dialog
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); //Hace desaparecer el dialog
            }
        });

        //Crea la notificación
        AlertDialog dialog = builder.create();
        //Lanza la notificación
        dialog.show();
    }

    /* Menu contextual (mantener pulsado) LOS MENUS SE CREAN EN UN XML (menu_context.xml) */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    /* Acciones menu contextual (mantener pulsado) */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                final ConstraintLayout mLayout = findViewById(R.id.myMainConstraint);
                //Genera un SnackBar
                Snackbar snackbar = Snackbar.make(mLayout, "Copied", Snackbar.LENGTH_LONG)
                        //Añade un boton al snackbar
                        .setAction("UNDO", new View.OnClickListener() {
                            //Funcionalidad del botón
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });
                //Muestra el SnackBar
                snackbar.show();

                /*
                Toast toast = Toast.makeText(this, "Item copied", Toast.LENGTH_LONG);
                toast.show();
                return true;
                */
            case R.id.item2:
                //Genera un toast
                Toast toast2 = Toast.makeText(this, "Downloading item", Toast.LENGTH_LONG);
                //Muestra el toast
                toast2.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


}