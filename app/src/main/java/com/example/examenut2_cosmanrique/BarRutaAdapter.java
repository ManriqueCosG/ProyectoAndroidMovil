
package com.example.examenut2_cosmanrique;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BarRutaAdapter extends RecyclerView.Adapter<BarRutaAdapter.BarViewHolder> {

    // LISTA DE BARES
    ArrayList<Bar> bares;

    // CONSTRUCTOR
    public BarRutaAdapter(ArrayList<Bar> bares) {
        this.bares = bares;
    }

    // CREAR LA TARJETA
    @NonNull
    @Override
    public BarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bar_ruta, parent, false);

        return new BarViewHolder(vista);
    }

    // COLOCAR LOS DATOS EN LA TARJETA
    @Override
    public void onBindViewHolder(@NonNull BarViewHolder holder, int position) {

        Bar barActual = bares.get(position);

        holder.txtNombreProducto.setText(barActual.nombre);

        holder.txtDescripcionProducto.setText(barActual.tapa);

    }

    // NUMERO DE ELEMENTOS
    @Override
    public int getItemCount() {
        return bares.size();
    }

    // VINCULAR LOS ELEMENTOS DEL XML
    public static class BarViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombreProducto;
        TextView txtDescripcionProducto;
        TextView btnFavorito;
        TextView txtValoracionProducto;

        public BarViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNombreProducto = itemView.findViewById(R.id.txtNombreProducto);

            txtDescripcionProducto = itemView.findViewById(R.id.txtDescripcionProducto);

            btnFavorito = itemView.findViewById(R.id.btnFavorito);

            txtValoracionProducto = itemView.findViewById(R.id.txtValoracionProducto);
        }
    }
}
