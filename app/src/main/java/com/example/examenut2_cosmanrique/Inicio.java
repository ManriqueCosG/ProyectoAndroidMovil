package com.example.examenut2_cosmanrique;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.examenut2_cosmanrique.R;

public class Inicio extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tv1;
    private TextView tvTitulo;
    private TextView tvProgreso;
    private TextView tvConexion;
    private ProgressBar progresoRuta;
    private Button btnVerRuta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // CARGAR EL XML DE LA VISTA
        setContentView(R.layout.activity_inicio);

        // CONFIGURAR TOOLBAR
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // RECUPERAR ELEMENTOS DEL XML
        tv1 = findViewById(R.id.tv1);
        tvTitulo = findViewById(R.id.tvTitulo);
        tvProgreso = findViewById(R.id.tvProgreso);
        tvConexion = findViewById(R.id.tvConexion);

        progresoRuta = findViewById(R.id.progresoRuta);

        btnVerRuta = findViewById(R.id.btnVerRuta);

        // EVENTO DEL BOTÓN VER RUTA
        btnVerRuta.setOnClickListener(v -> {

            Toast.makeText(
                    Inicio.this,
                    "Abriendo la ruta...",
                    Toast.LENGTH_SHORT
            ).show();

        });

    }

    // CREAR EL MENU DE LA TOOLBAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_principal, menu);

        return true;
    }

    // CONTROLAR LAS OPCIONES DEL MENU
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.opcion_ajustes) {

            Toast.makeText(
                    this,
                    "Ajustes",
                    Toast.LENGTH_SHORT
            ).show();

            return true;

        } else if (id == R.id.opcion_acerca) {

            Toast.makeText(
                    this,
                    "Acerca de GastroVote",
                    Toast.LENGTH_SHORT
            ).show();

            return true;

        } else if (id == R.id.opcion_compartir) {

            Toast.makeText(
                    this,
                    "Compartir GastroVote",
                    Toast.LENGTH_SHORT
            ).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
