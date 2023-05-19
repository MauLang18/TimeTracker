package com.langostino.planificador.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.langostino.planificador.HorarioActivity;
import com.langostino.planificador.HorarioRActivity;
import com.langostino.planificador.NuevoAActivity;
import com.langostino.planificador.NuevoHActivity;
import com.langostino.planificador.PlanificadorActivity;
import com.langostino.planificador.R;
import com.langostino.planificador.db.DbPlanificador;
import com.langostino.planificador.entidades.Actividades;
import com.langostino.planificador.entidades.Horarios;

import java.util.ArrayList;

public class HorarioFragment extends Fragment {

    ArrayList<Horarios> listaHorario;
    ArrayList<Actividades> listaActividades;
    TableLayout tlTabla;
    FloatingActionButton fabCrear, fabPlanificador;
    Button btnCambiar, btnAddAct;

    TableRow fila;

    TextView txtHora, txtLunes, txtMartes, txtMiercoles, txtJueves, txtViernes, txtSabado, txtDomingo, txtId;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HorarioFragment() {
        // Required empty public constructor
    }

    public static HorarioFragment newInstance(String param1, String param2) {
        HorarioFragment fragment = new HorarioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_horario, container, false);

        tlTabla = v.findViewById(R.id.tlTabla);
        fabCrear = v.findViewById(R.id.fabCrear);
        btnCambiar = v.findViewById(R.id.btnCambio);
        fabPlanificador = v.findViewById(R.id.fabPlanificador);
        fabPlanificador.setVisibility(View.INVISIBLE);
        btnAddAct = v.findViewById(R.id.btnAddAct);
        btnAddAct.setVisibility(View.INVISIBLE);

        DbPlanificador dbContactos = new DbPlanificador(getContext());

        listaHorario = new ArrayList<>(dbContactos.mostrarHorario());

        listaActividades = new ArrayList<>(dbContactos.mostrarActividades());

        //if(listaActividades.size() != 0){
          //  btnAddAct.setVisibility(View.INVISIBLE);
        //}
        //else if(listaActividades.size() == 0){
          //  btnAddAct.setVisibility(View.VISIBLE);
        //}

        TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutHora = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutLunes = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutMartes = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutMiercoles = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutJueves = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutViernes = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutSabado = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutDomingo = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutID = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

        // TABLA
        for(int i = -1; i < listaHorario.size() ; i++) {
            fila = new TableRow(getContext());
            fila.setLayoutParams(layoutFila);

            if(i == -1) {

                txtHora = new TextView(getContext());
                txtHora.setText("HORA");
                txtHora.setGravity(Gravity.CENTER);
                txtHora.setBackgroundColor(Color.BLACK);
                txtHora.setTextColor(Color.WHITE);
                txtHora.setPadding(10, 10, 10, 10);
                txtHora.setLayoutParams(layoutID);
                fila.addView(txtHora);

                txtLunes = new TextView(getContext());
                txtLunes.setText("LUNES");
                txtLunes.setGravity(Gravity.CENTER);
                txtLunes.setBackgroundColor(Color.BLACK);
                txtLunes.setTextColor(Color.WHITE);
                txtLunes.setPadding(10, 10, 10, 10);
                txtLunes.setLayoutParams(layoutLunes);
                fila.addView(txtLunes);

                txtMartes = new TextView(getContext());
                txtMartes.setText("MARTES");
                txtMartes.setGravity(Gravity.CENTER);
                txtMartes.setBackgroundColor(Color.BLACK);
                txtMartes.setTextColor(Color.WHITE);
                txtMartes.setPadding(10, 10, 10, 10);
                txtMartes.setLayoutParams(layoutMartes);
                fila.addView(txtMartes);

                txtMiercoles = new TextView(getContext());
                txtMiercoles.setText("MIERCOLES");
                txtMiercoles.setGravity(Gravity.CENTER);
                txtMiercoles.setBackgroundColor(Color.BLACK);
                txtMiercoles.setTextColor(Color.WHITE);
                txtMiercoles.setPadding(10, 10, 10, 10);
                txtMiercoles.setLayoutParams(layoutMiercoles);
                fila.addView(txtMiercoles);

                txtJueves = new TextView(getContext());
                txtJueves.setText("JUEVES");
                txtJueves.setGravity(Gravity.CENTER);
                txtJueves.setBackgroundColor(Color.BLACK);
                txtJueves.setTextColor(Color.WHITE);
                txtJueves.setPadding(10, 10, 10, 10);
                txtJueves.setLayoutParams(layoutJueves);
                fila.addView(txtJueves);

                txtViernes = new TextView(getContext());
                txtViernes.setText("VIERNES");
                txtViernes.setGravity(Gravity.CENTER);
                txtViernes.setBackgroundColor(Color.BLACK);
                txtViernes.setTextColor(Color.WHITE);
                txtViernes.setPadding(10, 10, 10, 10);
                txtViernes.setLayoutParams(layoutViernes);
                fila.addView(txtViernes);

                txtSabado = new TextView(getContext());
                txtSabado.setText("SABADO");
                txtSabado.setGravity(Gravity.CENTER);
                txtSabado.setBackgroundColor(Color.BLACK);
                txtSabado.setTextColor(Color.WHITE);
                txtSabado.setPadding(10, 10, 10, 10);
                txtSabado.setLayoutParams(layoutSabado);
                fila.addView(txtSabado);

                txtDomingo = new TextView(getContext());
                txtDomingo.setText("DOMINGO");
                txtDomingo.setGravity(Gravity.CENTER);
                txtDomingo.setBackgroundColor(Color.BLACK);
                txtDomingo.setTextColor(Color.WHITE);
                txtDomingo.setPadding(10, 10, 10, 10);
                txtDomingo.setLayoutParams(layoutDomingo);
                fila.addView(txtDomingo);

                tlTabla.addView(fila);
            } else {

                txtHora = new TextView(getContext());
                txtHora.setText(listaHorario.get(i).getHora());
                txtHora.setTextColor(Color.BLACK);
                txtHora.setPadding(10, 10, 10, 10);
                txtHora.setLayoutParams(layoutHora);
                fila.addView(txtHora);

                txtLunes = new TextView(getContext());
                txtLunes.setText(listaHorario.get(i).getLunes());
                txtLunes.setTextColor(Color.BLACK);
                txtLunes.setPadding(10, 10, 10, 10);
                txtLunes.setLayoutParams(layoutLunes);
                fila.addView(txtLunes);

                txtMartes = new TextView(getContext());
                txtMartes.setText(listaHorario.get(i).getMartes());
                txtMartes.setTextColor(Color.BLACK);
                txtMartes.setPadding(10, 10, 10, 10);
                txtMartes.setLayoutParams(layoutMartes);
                fila.addView(txtMartes);

                txtMiercoles = new TextView(getContext());
                txtMiercoles.setText(listaHorario.get(i).getMiercoles());
                txtMiercoles.setTextColor(Color.BLACK);
                txtMiercoles.setPadding(10, 10, 10, 10);
                txtMiercoles.setLayoutParams(layoutMiercoles);
                fila.addView(txtMiercoles);

                txtJueves = new TextView(getContext());
                txtJueves.setText(listaHorario.get(i).getJueves());
                txtJueves.setTextColor(Color.BLACK);
                txtJueves.setPadding(10, 10, 10, 10);
                txtJueves.setLayoutParams(layoutJueves);
                fila.addView(txtJueves);

                txtViernes = new TextView(getContext());
                txtViernes.setText(listaHorario.get(i).getViernes());
                txtViernes.setTextColor(Color.BLACK);
                txtViernes.setPadding(10, 10, 10, 10);
                txtViernes.setLayoutParams(layoutViernes);
                fila.addView(txtViernes);

                txtSabado = new TextView(getContext());
                txtSabado.setText(listaHorario.get(i).getSabado());
                txtSabado.setTextColor(Color.BLACK);
                txtSabado.setPadding(10, 10, 10, 10);
                txtSabado.setLayoutParams(layoutSabado);
                fila.addView(txtSabado);

                txtDomingo = new TextView(getContext());
                txtDomingo.setText(listaHorario.get(i).getDomingo());
                txtDomingo.setTextColor(Color.BLACK);
                txtDomingo.setPadding(10, 10, 10, 10);
                txtDomingo.setLayoutParams(layoutDomingo);
                fila.addView(txtDomingo);

                tlTabla.addView(fila);
            }
        }

        fabCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), NuevoHActivity.class);
                startActivity(intent);
            }
        });

        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ver();
            }
        });

        btnAddAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), NuevoAActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

    private void nuevoRegistro(){
        Intent intent = new Intent(getContext(), NuevoHActivity.class);
        startActivity(intent);
    }

    private void ver(){
        Intent intent = new Intent(getContext(), HorarioRActivity.class);
        startActivity(intent);
    }
}