package com.example.examenut2_cosmanrique;


import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int a = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Switch s = findViewById(R.id.swMeGusta);

        //EditText etBar =  findViewById(R.id.etBar);
        //EditText etTapa =  findViewById(R.id.etTapa);
        //EditText etPrecio =  findViewById(R.id.etPrecio);

        // Button btnCalcular = findViewById(R.id.btnCalcular);
        // Button btnLimpiar = findViewById(R.id.btnLimpiar);
        //Button b1 = findViewById(R.id.b1);
        // Button b2 = findViewById(R.id.b2);


        // TextView resumen = findViewById(R.id.tvResumen);
        //  TextView tvMeGusta = findViewById(R.id.tvMeGusta);
        TextView info = findViewById(R.id.info);

        CheckBox cbEstudiante = findViewById(R.id.cbEstudiante);

        ArrayList<String> t = new ArrayList<>();

        t.add("Tabernas 1");
        t.add("Tabernas 2");
        t.add("Tabernas de patatas");
        t.add("Tabernas de Calamares");
        t.add("Tabernas de Jamón ibérico");

        /*b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                a++;
                String actual = t.get(a);
                info.setText(actual);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                a--;
                String actual = t.get(a);
                info.setText(actual);

            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //etBar.setText("");
                //etTapa.setText("");
                //etPrecio.setText("");

                resumen.setText("Aqui aparecera el precio final");

                Toast toast = Toast.makeText(MainActivity.this,"Formulario Limpio", Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        s.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (s.isChecked()){
                    tvMeGusta.setText("Te gusta esta tapa");
                }else{
                    tvMeGusta.setText("¿Te ha gustado?");
                }

            }
        });
*/
        cbEstudiante.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                if(cbEstudiante.isChecked()){
                    Toast toast = Toast.makeText(MainActivity.this,"Recuerda enseñat tu carnet", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


            /* btnCalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //String b = String.valueOf(etBar.getText());
             //  String t = String.valueOf(etTapa.getText());
               // String p2 = String.valueOf(etPrecio.getText());

               // float p8 = etPrecio.getInputType();

                //String casillaP = String.valueOf(etPrecio.getText());

               // Double p = Double.parseDouble(p2);


                if(b.isEmpty() && t.isEmpty()){
                    Toast toast = Toast.makeText(MainActivity.this,"Indica el bar y la tapa", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (p > 0 && casillaP.isEmpty()){
                    Toast toast = Toast.makeText(MainActivity.this,"Introduce un precio valido", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    if (cbEstudiante.isChecked()){
                        Toast toast = Toast.makeText(MainActivity.this,"Precio calculado", Toast.LENGTH_SHORT);
                        toast.show();
                        double finald = p - (p * 0.1);
                        double desciento = p-finald;

                        if(s.isChecked()){
                            resumen.setText("Tapa " + t + "Bar " + b + "precio " + p + " Desciento -" + desciento + "Precio final " + finald + "Me gusta: Si");

                        }else {
                            resumen.setText("Tapa " + t + "Bar " + b + "precio " + p + " Desciento -" + desciento + "Precio final " + finald + "Me gusta: No");

                        }

                    } else{
                        Toast toast = Toast.makeText(MainActivity.this,"Descuento no aplicado", Toast.LENGTH_SHORT);
                        toast.show();
                        resumen.setText("Tapa " + t + " Bar " + b + " precio " + p + " Desciento " + " Precio final " + "Me gusta:  ");

                        if(s.isChecked()){
                            resumen.setText("Tapa " + t + " Bar " + b + " precio " + p + " Desciento -" + "0" + " Precio final " +  p + " Me gusta: Si");

                        }else {
                            resumen.setText("Tapa " + t + " Bar " + b + " precio " + p +  " Desciento -" + "0" + " Precio final " +  p + " Me gusta: No");

                        }
                    }
                }

            }
        });*/

    }
}