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

import com.langostino.planificador.EditarHActivity;
import com.langostino.planificador.R;
import com.langostino.planificador.VerActivity;
import com.langostino.planificador.VerHActivity;
import com.langostino.planificador.entidades.Horarios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaHorarioAdapter extends RecyclerView.Adapter<ListaHorarioAdapter.HorarioViewHolder> {
    ArrayList<Horarios> listaHorario;
    ArrayList<Horarios> listaOriginal;

    public ListaHorarioAdapter(ArrayList<Horarios> listaHorario){
        this.listaHorario = listaHorario;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaHorario);
    }

    @NonNull
    @Override
    public HorarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_horario, null, false);
        return new HorarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorarioViewHolder holder, int position) {
        holder.viewHora.setText(listaHorario.get(position).getHora());
        holder.viewLunes.setText(listaHorario.get(position).getLunes());
        holder.viewMartes.setText(listaHorario.get(position).getMartes());
        holder.viewMiercoles.setText(listaHorario.get(position).getMiercoles());
        holder.viewJueves.setText(listaHorario.get(position).getJueves());
        holder.viewViernes.setText(listaHorario.get(position).getViernes());
        holder.viewSabado.setText(listaHorario.get(position).getSabado());
        holder.viewDomingo.setText(listaHorario.get(position).getDomingo());
    }

    @Override
    public int getItemCount() {
        return listaHorario.size();
    }

    public class HorarioViewHolder extends RecyclerView.ViewHolder {

        TextView viewHora, viewLunes, viewMartes, viewMiercoles, viewJueves, viewViernes, viewSabado, viewDomingo;

        public HorarioViewHolder(@NonNull View itemView) {
            super(itemView);
            viewLunes = itemView.findViewById(R.id.viewLunes);
            viewMartes = itemView.findViewById(R.id.viewMartes);
            viewHora = itemView.findViewById(R.id.viewHora);
            viewMiercoles = itemView.findViewById(R.id.viewMiercoles);
            viewJueves = itemView.findViewById(R.id.viewJueves);
            viewViernes = itemView.findViewById(R.id.viewViernes);
            viewSabado = itemView.findViewById(R.id.viewSabado);
            viewDomingo = itemView.findViewById(R.id.viewDomingo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, EditarHActivity.class);
                    intent.putExtra("ID", listaHorario.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
