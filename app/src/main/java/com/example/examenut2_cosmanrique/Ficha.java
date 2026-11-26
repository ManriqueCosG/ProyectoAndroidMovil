
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
        tvNombre = findViewById(R.id.txtNombreProducto);
        tvDescripcion = findViewById(R.id.txtDescripcionProducto);
        tvPrecio = findViewById(R.id.txtPrecioProducto);

        // RECUPERAR LOS DATOS DEL INTENT
        String nombre = getIntent().getStringExtra("nombre");
        String descripcion = getIntent().getStringExtra("descripcion");
        String precio = getIntent().getStringExtra("precio");

        // MOSTRAR LOS DATOS
        tvNombre.setText(nombre);
        tvDescripcion.setText(descripcion);
        tvPrecio.setText(precio);

    }
}
