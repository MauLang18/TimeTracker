package com.langostino.planificador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.langostino.planificador.adaptadores.ListaPlanesAdapter;
import com.langostino.planificador.db.DbPlanificador;
import com.langostino.planificador.entidades.Horarios;

import java.util.ArrayList;

public class HorarioActivity extends AppCompatActivity {

    ArrayList<Horarios> listaHorario;
    TableLayout tlTabla;
    FloatingActionButton fabCrear, fabPlanificador;
    Button btnCambiar;

    TableRow fila;

    TextView txtHora, txtLunes, txtMartes, txtMiercoles, txtJueves, txtViernes, txtSabado, txtDomingo, txtId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);

        tlTabla = findViewById(R.id.tlTabla);
        fabCrear = findViewById(R.id.fabCrear);
        btnCambiar = findViewById(R.id.btnCambio);
        fabPlanificador = findViewById(R.id.fabPlanificador);

        DbPlanificador dbContactos = new DbPlanificador(HorarioActivity.this);

        listaHorario = new ArrayList<>(dbContactos.mostrarHorario());



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
            fila = new TableRow(this);
            fila.setLayoutParams(layoutFila);

            if(i == -1) {

                txtHora = new TextView(this);
                txtHora.setText("HORA");
                txtHora.setGravity(Gravity.CENTER);
                txtHora.setBackgroundColor(Color.BLACK);
                txtHora.setTextColor(Color.WHITE);
                txtHora.setPadding(10, 10, 10, 10);
                txtHora.setLayoutParams(layoutID);
                fila.addView(txtHora);

                txtLunes = new TextView(this);
                txtLunes.setText("LUNES");
                txtLunes.setGravity(Gravity.CENTER);
                txtLunes.setBackgroundColor(Color.BLACK);
                txtLunes.setTextColor(Color.WHITE);
                txtLunes.setPadding(10, 10, 10, 10);
                txtLunes.setLayoutParams(layoutLunes);
                fila.addView(txtLunes);

                txtMartes = new TextView(this);
                txtMartes.setText("MARTES");
                txtMartes.setGravity(Gravity.CENTER);
                txtMartes.setBackgroundColor(Color.BLACK);
                txtMartes.setTextColor(Color.WHITE);
                txtMartes.setPadding(10, 10, 10, 10);
                txtMartes.setLayoutParams(layoutMartes);
                fila.addView(txtMartes);

                txtMiercoles = new TextView(this);
                txtMiercoles.setText("MIERCOLES");
                txtMiercoles.setGravity(Gravity.CENTER);
                txtMiercoles.setBackgroundColor(Color.BLACK);
                txtMiercoles.setTextColor(Color.WHITE);
                txtMiercoles.setPadding(10, 10, 10, 10);
                txtMiercoles.setLayoutParams(layoutMiercoles);
                fila.addView(txtMiercoles);

                txtJueves = new TextView(this);
                txtJueves.setText("JUEVES");
                txtJueves.setGravity(Gravity.CENTER);
                txtJueves.setBackgroundColor(Color.BLACK);
                txtJueves.setTextColor(Color.WHITE);
                txtJueves.setPadding(10, 10, 10, 10);
                txtJueves.setLayoutParams(layoutJueves);
                fila.addView(txtJueves);

                txtViernes = new TextView(this);
                txtViernes.setText("VIERNES");
                txtViernes.setGravity(Gravity.CENTER);
                txtViernes.setBackgroundColor(Color.BLACK);
                txtViernes.setTextColor(Color.WHITE);
                txtViernes.setPadding(10, 10, 10, 10);
                txtViernes.setLayoutParams(layoutViernes);
                fila.addView(txtViernes);

                txtSabado = new TextView(this);
                txtSabado.setText("SABADO");
                txtSabado.setGravity(Gravity.CENTER);
                txtSabado.setBackgroundColor(Color.BLACK);
                txtSabado.setTextColor(Color.WHITE);
                txtSabado.setPadding(10, 10, 10, 10);
                txtSabado.setLayoutParams(layoutSabado);
                fila.addView(txtSabado);

                txtDomingo = new TextView(this);
                txtDomingo.setText("DOMINGO");
                txtDomingo.setGravity(Gravity.CENTER);
                txtDomingo.setBackgroundColor(Color.BLACK);
                txtDomingo.setTextColor(Color.WHITE);
                txtDomingo.setPadding(10, 10, 10, 10);
                txtDomingo.setLayoutParams(layoutDomingo);
                fila.addView(txtDomingo);

                tlTabla.addView(fila);
            } else {

                txtHora = new TextView(this);
                txtHora.setText(listaHorario.get(i).getHora());
                txtHora.setTextColor(Color.BLACK);
                txtHora.setPadding(10, 10, 10, 10);
                txtHora.setLayoutParams(layoutHora);
                fila.addView(txtHora);

                txtLunes = new TextView(this);
                txtLunes.setText(listaHorario.get(i).getLunes());
                txtLunes.setTextColor(Color.BLACK);
                txtLunes.setPadding(10, 10, 10, 10);
                txtLunes.setLayoutParams(layoutLunes);
                fila.addView(txtLunes);

                txtMartes = new TextView(this);
                txtMartes.setText(listaHorario.get(i).getMartes());
                txtMartes.setTextColor(Color.BLACK);
                txtMartes.setPadding(10, 10, 10, 10);
                txtMartes.setLayoutParams(layoutMartes);
                fila.addView(txtMartes);

                txtMiercoles = new TextView(this);
                txtMiercoles.setText(listaHorario.get(i).getMiercoles());
                txtMiercoles.setTextColor(Color.BLACK);
                txtMiercoles.setPadding(10, 10, 10, 10);
                txtMiercoles.setLayoutParams(layoutMiercoles);
                fila.addView(txtMiercoles);

                txtJueves = new TextView(this);
                txtJueves.setText(listaHorario.get(i).getJueves());
                txtJueves.setTextColor(Color.BLACK);
                txtJueves.setPadding(10, 10, 10, 10);
                txtJueves.setLayoutParams(layoutJueves);
                fila.addView(txtJueves);

                txtViernes = new TextView(this);
                txtViernes.setText(listaHorario.get(i).getViernes());
                txtViernes.setTextColor(Color.BLACK);
                txtViernes.setPadding(10, 10, 10, 10);
                txtViernes.setLayoutParams(layoutViernes);
                fila.addView(txtViernes);

                txtSabado = new TextView(this);
                txtSabado.setText(listaHorario.get(i).getSabado());
                txtSabado.setTextColor(Color.BLACK);
                txtSabado.setPadding(10, 10, 10, 10);
                txtSabado.setLayoutParams(layoutSabado);
                fila.addView(txtSabado);

                txtDomingo = new TextView(this);
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
                nuevoRegistro();
            }
        });

        fabPlanificador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                planificador();
            }
        });

        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ver();
            }
        });
    }

    private void nuevoRegistro(){
        Intent intent = new Intent(this, NuevoHActivity.class);
        startActivity(intent);
    }

    private void planificador(){
        Intent intent = new Intent(this, PlanificadorActivity.class);
        startActivity(intent);
    }

    private void ver(){
        Intent intent = new Intent(this, HorarioRActivity.class);
        startActivity(intent);
    }
}