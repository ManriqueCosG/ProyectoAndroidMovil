
package com.example.examenut2_cosmanrique;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Ruta extends AppCompatActivity {

    // LISTA DE BARES
    ArrayList<Bar> bares = new ArrayList<>();

    // ELEMENTOS DE LA INTERFAZ
    Toolbar toolbar;
    RecyclerView recyclerRuta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // CARGAR EL XML
        setContentView(R.layout.activity_ruta);

        // RECUPERAR ELEMENTOS
        toolbar = findViewById(R.id.toolbar);
        recyclerRuta = findViewById(R.id.recyclerRuta);

        // CONFIGURAR TOOLBAR
        toolbar.setNavigationIcon(
                androidx.appcompat.R.drawable.abc_ic_ab_back_material
        );

        toolbar.setNavigationOnClickListener(v -> finish());

        // CARGAR LOS DATOS DE LOS BARES
        cargarBares();

        // CONFIGURAR RECYCLERVIEW
        recyclerRuta.setLayoutManager(
                new LinearLayoutManager(this)
        );

        // ASIGNAR EL ADAPTADOR
        BarRutaAdapter adapter = new BarRutaAdapter(bares);

        recyclerRuta.setAdapter(adapter);

    }

    // METODO PARA CARGAR LOS BARES
    private void cargarBares() {

        // RECUPERAR ARRAYS DE STRINGS.XML
        String[] nombres = getResources().getStringArray(R.array.bar_nombres);

        String[] tapas = getResources().getStringArray(R.array.bar_tapas);

        String[] descripciones = getResources().getStringArray(R.array.bar_descripciones);

        String[] precios = getResources().getStringArray(R.array.bar_precios);

        // CREAR OBJETOS BAR
        for (int i = 0; i < nombres.length; i++) {

            bares.add(new Bar(
                    nombres[i],
                    tapas[i],
                    descripciones[i],
                    precios[i]
            ));

        }

    }

}
