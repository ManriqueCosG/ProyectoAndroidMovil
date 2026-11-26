
package com.example.examenut2_cosmanrique;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ficha extends AppCompatActivity {

    // ELEMENTOS DE LA INTERFAZ
    TextView tvNombre;
    TextView tvTapa;
    TextView tvDescripcion;
    TextView tvPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // CARGAR EL XML
        setContentView(R.layout.activity_ficha);

        // RECUPERAR LOS ELEMENTOS
        tvNombre = findViewById(R.id.tvNombre);
        tvTapa = findViewById(R.id.tvTapa);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        tvPrecio = findViewById(R.id.tvPrecio);

        // RECUPERAR LOS DATOS DEL INTENT
        String nombre = getIntent().getStringExtra("nombre");
        String tapa = getIntent().getStringExtra("tapa");
        String descripcion = getIntent().getStringExtra("descripcion");
        String precio = getIntent().getStringExtra("precio");

        // MOSTRAR LOS DATOS
        tvNombre.setText(nombre);
        tvTapa.setText(tapa);
        tvDescripcion.setText(descripcion);
        tvPrecio.setText(precio);

    }
}
