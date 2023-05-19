package com.langostino.planificador.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.langostino.planificador.EditarAActivity;
import com.langostino.planificador.R;
import com.langostino.planificador.VerAActivity;
import com.langostino.planificador.entidades.Actividades;
import com.langostino.planificador.entidades.Planes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaActividadesAdapter extends RecyclerView.Adapter<ListaActividadesAdapter.ActividadesViewHolder>{
    ArrayList<Actividades> listaActividades;
    ArrayList<Actividades> listaOriginal;

    public ListaActividadesAdapter(ArrayList<Actividades> listaActividades){
        this.listaActividades = listaActividades;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaActividades);
    }

    @NonNull
    @Override
    public ActividadesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_actividades, null, false);
        return new ActividadesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaActividadesAdapter.ActividadesViewHolder holder, int position) {
        holder.viewNombre.setText(listaActividades.get(position).getNombre());
        holder.viewCantidad.setText(listaActividades.get(position).getCantidad());
    }

    public void filtrado(final String txtBuscar) {
        int longitud = txtBuscar.length();
        if (longitud == 0) {
            listaActividades.clear();
            listaActividades.addAll(listaOriginal);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                List<Actividades> collecion = listaActividades.stream()
                        .filter(i -> i.getNombre().toLowerCase().contains(txtBuscar.toLowerCase()))
                        .collect(Collectors.toList());
                listaActividades.clear();
                listaActividades.addAll(collecion);
            } else {
                for (Actividades c : listaOriginal) {
                    if (c.getNombre().toLowerCase().contains(txtBuscar.toLowerCase())) {
                        listaActividades.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listaActividades.size();
    }

    public class ActividadesViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewCantidad;

        public ActividadesViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewCantidad = itemView.findViewById(R.id.viewCantidad);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, EditarAActivity.class);
                    intent.putExtra("ID", listaActividades.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
