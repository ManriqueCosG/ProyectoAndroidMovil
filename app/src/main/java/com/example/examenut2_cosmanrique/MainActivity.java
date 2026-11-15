
package com.example.examenut2_cosmanrique;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Bar> bares = new ArrayList<>();

    TextView info, info2;
    TextView txtNombreProducto, txtDescripcionProducto, txtPrecioProducto;

    int posicion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(
                    systemBars.left,
                    systemBars.top,
                    systemBars.right,
                    systemBars.bottom
            );
            return insets;
        });

        info = findViewById(R.id.info);
        info2 = findViewById(R.id.info2);

        txtNombreProducto = findViewById(R.id.txtNombreProducto);
        txtDescripcionProducto = findViewById(R.id.txtDescripcionProducto);
        txtPrecioProducto = findViewById(R.id.txtPrecioProducto);

        TextView textView = findViewById(R.id.textView);

        Button b1 = findViewById(R.id.b1);
        Button b2 = findViewById(R.id.b2);

        Button btnPublicar = findViewById(R.id.btnPublicar);
        Button btnLimpiar = findViewById(R.id.btnLimpiar);

        Switch swMeGusta = findViewById(R.id.swMeGusta);

        EditText etOpinion = findViewById(R.id.etOpinion);

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        TextView tvValoracion = findViewById(R.id.tvValoracion);

        SeekBar seekCalidad = findViewById(R.id.seekCalidad);
        TextView tvCalidad = findViewById(R.id.tvCalidad);

        RadioGroup rgTamano = findViewById(R.id.rgTamano);

        CheckBox cbVegetariana = findViewById(R.id.cbVegetariana);
        CheckBox cbSinGluten = findViewById(R.id.cbSinGluten);
        CheckBox cbPicante = findViewById(R.id.cbPicante);
        CheckBox cbEstudiante = findViewById(R.id.cbEstudiante);

        String[] nombres = getResources().getStringArray(R.array.bar_nombres);
        String[] tapas = getResources().getStringArray(R.array.bar_tapas);
        String[] descripciones = getResources().getStringArray(R.array.bar_descripciones);
        String[] precios = getResources().getStringArray(R.array.bar_precios);

        for (int i = 0; i < nombres.length; i++) {
            bares.add(new Bar(
                    nombres[i],
                    tapas[i],
                    descripciones[i],
                    precios[i]
            ));
        }

        actualizarBar();

        b1.setOnClickListener(v -> {

            if (posicion > 0) {
                posicion--;
            }

            actualizarBar();

        });

        b2.setOnClickListener(v -> {

            if (posicion < bares.size() - 1) {
                posicion++;
            }

            actualizarBar();

        });

        ratingBar.setOnRatingBarChangeListener((bar, rating, fromUser) -> {

            if (rating == 0) {
                tvValoracion.setText(R.string.sin_puntuar);

            } else if (rating <= 1) {
                tvValoracion.setText(R.string.puntuacion_mejorable);

            } else if (rating <= 2) {
                tvValoracion.setText(R.string.puntuacion_correcta);

            } else if (rating <= 4) {
                tvValoracion.setText(R.string.puntuacion_muy_buena);

            } else {
                tvValoracion.setText(R.string.puntuacion_espectacular);
            }

        });

        seekCalidad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                tvCalidad.setText(getString(R.string.calidad_valor, progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnLimpiar.setOnClickListener(v -> {

            rgTamano.check(R.id.rbMedia);

            ratingBar.setRating(4);
            tvValoracion.setText(R.string.puntuacion_muy_buena);

            seekCalidad.setProgress(7);
            tvCalidad.setText(getString(R.string.calidad_valor, 7));

            cbVegetariana.setChecked(false);
            cbSinGluten.setChecked(false);
            cbPicante.setChecked(false);

            swMeGusta.setChecked(false);

            cbEstudiante.setChecked(true);

            etOpinion.setText("");

            Toast.makeText(
                    MainActivity.this,
                    R.string.toast_formulario_limpio,
                    Toast.LENGTH_SHORT
            ).show();

        });

        btnPublicar.setOnClickListener(v -> {

            if (ratingBar.getRating() == 0) {

                Toast.makeText(
                        MainActivity.this,
                        R.string.toast_puntuar,
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            Bar barActual = bares.get(posicion);

            String nombreTapa = barActual.tapa;

            int seleccionado = rgTamano.getCheckedRadioButtonId();

            String tamano = "";

            if (seleccionado == R.id.rbTapa) {
                tamano = getString(R.string.tamano_tapa);

            } else if (seleccionado == R.id.rbMedia) {
                tamano = getString(R.string.tamano_media_completo);

            } else if (seleccionado == R.id.rbRacion) {
                tamano = getString(R.string.tamano_racion);
            }

            float puntuacion = ratingBar.getRating();
            int calidad = seekCalidad.getProgress();

            double precioBase = Double.parseDouble(
                    barActual.precio.replace("€", "").replace(",", ".").trim()
            );

            // Calcular precio según el tamaño
            double precio = precioBase;

            if (seleccionado == R.id.rbTapa) {
                precio = precioBase;

            } else if (seleccionado == R.id.rbMedia) {
                precio = precioBase * 2;

            } else if (seleccionado == R.id.rbRacion) {
                precio = precioBase * 3;
            }

            boolean descuentoEstudiante = cbEstudiante.isChecked();

            double descuento = 0;

            if (descuentoEstudiante) {
                descuento = precio * 0.10;
            }

            double precioFinal = precio - descuento;

            String etiquetas = "";

            if (cbVegetariana.isChecked()) {
                etiquetas += getString(R.string.etiqueta_vegetariana) + ", ";
            }

            if (cbSinGluten.isChecked()) {
                etiquetas += getString(R.string.etiqueta_sin_gluten) + ", ";
            }

            if (cbPicante.isChecked()) {
                etiquetas += getString(R.string.etiqueta_picante) + ", ";
            }

            if (etiquetas.isEmpty()) {
                etiquetas = getString(R.string.valor_ninguna);

            } else {
                etiquetas = etiquetas.substring(0, etiquetas.length() - 2);
            }

            String meGusta = swMeGusta.isChecked()
                    ? getString(R.string.valor_si)
                    : getString(R.string.valor_no);

            String comentario = etOpinion.getText().toString().trim();

            if (comentario.isEmpty()) {
                comentario = getString(R.string.valor_sin_comentario);
            }

            String precioBaseTexto = String.format(
                    java.util.Locale.getDefault(),
                    "%.2f €",
                    precioBase
            );

            String precioTexto = String.format(
                    java.util.Locale.getDefault(),
                    "%.2f €",
                    precio
            );

            String descuentoTexto = String.format(
                    java.util.Locale.getDefault(),
                    "%.2f €",
                    descuento
            );

            String precioFinalTexto = String.format(
                    java.util.Locale.getDefault(),
                    "%.2f €",
                    precioFinal
            );

            String textoDescuento;

            if (descuentoEstudiante) {

                textoDescuento = getString(
                        R.string.valor_descuento,
                        descuentoTexto
                );

            } else {

                textoDescuento = getString(R.string.valor_sin_descuento);

            }

            String resumen = getString(R.string.titulo_resumen) + "\n\n"

                    + getString(R.string.resumen_tapa, nombreTapa) + "\n"

                    + getString(R.string.resumen_tamano, tamano) + "\n"

                    + getString(
                    R.string.resumen_puntuacion,
                    String.valueOf(puntuacion)
            ) + "\n"

                    + getString(R.string.resumen_calidad, calidad) + "\n"

                    + getString(R.string.resumen_precio_base, precioBaseTexto) + "\n"

                    + getString(R.string.resumen_precio_tamano, precioTexto) + "\n"

                    + getString(R.string.resumen_descuento, textoDescuento) + "\n"

                    + getString(R.string.resumen_precio_final, precioFinalTexto) + "\n"

                    + getString(R.string.resumen_me_gusta, meGusta) + "\n"

                    + getString(R.string.resumen_etiquetas, etiquetas) + "\n"

                    + getString(R.string.resumen_comentario, comentario);

            textView.setText(resumen);

            Toast.makeText(
                    MainActivity.this,
                    R.string.toast_publicada,
                    Toast.LENGTH_SHORT
            ).show();

        });

    }

    private void actualizarBar() {

        Bar barActual = bares.get(posicion);

        info.setText(getString(
                R.string.bar_posicion,
                posicion + 1,
                bares.size()
        ));

        info2.setText(barActual.nombre);

        txtNombreProducto.setText(barActual.tapa);
        txtDescripcionProducto.setText(barActual.descripcion);
        txtPrecioProducto.setText(barActual.precio);

    }

}
