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

import com.langostino.planificador.EditarActivity;
import com.langostino.planificador.R;
import com.langostino.planificador.VerActivity;
import com.langostino.planificador.entidades.Planes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaPlanesAdapter extends RecyclerView.Adapter<ListaPlanesAdapter.PlanesViewHolder> {

    ArrayList<Planes> listaPlanes;
    ArrayList<Planes> listaOriginal;

    public ListaPlanesAdapter(ArrayList<Planes> listaPlanes){
        this.listaPlanes = listaPlanes;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaPlanes);
    }

    @NonNull
    @Override
    public PlanesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_planes, null, false);
        return new PlanesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanesViewHolder holder, int position) {
        holder.viewTitulo.setText(listaPlanes.get(position).getTitulo());
        holder.viewFecha.setText(listaPlanes.get(position).getDia());
        holder.viewHora.setText(listaPlanes.get(position).getHora());
    }

    public void filtrado(final String txtBuscar) {
        int longitud = txtBuscar.length();
        if (longitud == 0) {
            listaPlanes.clear();
            listaPlanes.addAll(listaOriginal);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                List<Planes> collecion = listaPlanes.stream()
                        .filter(i -> i.getTitulo().toLowerCase().contains(txtBuscar.toLowerCase()))
                        .collect(Collectors.toList());
                listaPlanes.clear();
                listaPlanes.addAll(collecion);
            } else {
                for (Planes c : listaOriginal) {
                    if (c.getTitulo().toLowerCase().contains(txtBuscar.toLowerCase())) {
                        listaPlanes.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listaPlanes.size();
    }

    public class PlanesViewHolder extends RecyclerView.ViewHolder {

        TextView viewTitulo, viewFecha, viewHora, viewLugar;

        public PlanesViewHolder(@NonNull View itemView) {
            super(itemView);
            viewTitulo = itemView.findViewById(R.id.viewTitulo);
            viewFecha = itemView.findViewById(R.id.viewFecha);
            viewHora = itemView.findViewById(R.id.viewHora);
            viewLugar = itemView.findViewById(R.id.viewLugar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, EditarActivity.class);
                    intent.putExtra("ID", listaPlanes.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
