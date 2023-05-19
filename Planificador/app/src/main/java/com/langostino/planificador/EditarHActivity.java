package com.langostino.planificador;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Data;
import androidx.work.WorkManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.langostino.planificador.alarmas.WorkManagerNoti;
import com.langostino.planificador.db.DbPlanificador;
import com.langostino.planificador.entidades.Actividades;
import com.langostino.planificador.entidades.Horarios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EditarHActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText txtHora, txtLunes, txtMartes, txtMiercoles, txtJueves, txtViernes, txtSabado, txtDomingo;
    FloatingActionButton fabEditar, fabEliminar;
    Button btnGuarda, btnHora, btnFecha;
    Spinner sbrHora, sbrLunes, sbrMartes, sbrMiercoles, sbrJueves, sbrViernes, sbrSabado, sbrDomingo;
    int id = 0;

    Horarios horarios;
    boolean correcto = false;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_hactivity);

        txtHora = findViewById(R.id.txtHora);
        txtLunes = findViewById(R.id.txtLunes);
        sbrLunes = findViewById(R.id.sbrLunes);
        txtMartes = findViewById(R.id.txtMartes);
        sbrMartes = findViewById(R.id.sbrMartes);
        txtMiercoles = findViewById(R.id.txtMiercoles);
        sbrMiercoles = findViewById(R.id.sbrMiercoles);
        txtJueves = findViewById(R.id.txtJueves);
        sbrJueves = findViewById(R.id.sbrJueves);
        txtViernes = findViewById(R.id.txtViernes);
        sbrViernes = findViewById(R.id.sbrViernes);
        txtSabado = findViewById(R.id.txtSabado);
        sbrSabado = findViewById(R.id.sbrSabado);
        txtDomingo = findViewById(R.id.txtDomingo);
        sbrDomingo = findViewById(R.id.sbrDomingo);
        fabEditar = findViewById(R.id.fabModificar);
        fabEditar.setVisibility(View.INVISIBLE);
        fabEliminar = findViewById(R.id.fabEliminar);
        btnGuarda = findViewById(R.id.btnGuarda);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.strHora,
                R.layout.color_spinner_layout
        );
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);

        List<Actividades> listaCategorias = llenarCategorias();
        ArrayAdapter<Actividades> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.color_spinner_layout, listaCategorias);
        sbrLunes.setAdapter(arrayAdapter);
        sbrMartes.setAdapter(arrayAdapter);
        sbrMiercoles.setAdapter(arrayAdapter);
        sbrJueves.setAdapter(arrayAdapter);
        sbrViernes.setAdapter(arrayAdapter);
        sbrSabado.setAdapter(arrayAdapter);
        sbrDomingo.setAdapter(arrayAdapter);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                id = Integer.parseInt(null);
            } else {
                id = extras.getInt("ID");
            }
        } else {
            id = (int) savedInstanceState.getSerializable("ID");
        }

        System.out.println(id);

        final DbPlanificador dbPlanificador = new DbPlanificador(EditarHActivity.this);
        horarios = dbPlanificador.verHorarios(id);

        if (horarios != null) {
            txtHora.setText(horarios.getHora());
            txtLunes.setText(horarios.getLunes());
            txtMartes.setText(horarios.getMartes());
            txtMiercoles.setText(horarios.getMiercoles());
            txtJueves.setText(horarios.getJueves());
            txtViernes.setText(horarios.getViernes());
            txtSabado.setText(horarios.getSabado());
            txtDomingo.setText(horarios.getDomingo());
        }

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtHora.getText().toString().equals("")) {
                    correcto = dbPlanificador.editarHorario(id,txtHora.getText().toString(), sbrLunes.getSelectedItem().toString(), sbrMartes.getSelectedItem().toString(), sbrMiercoles.getSelectedItem().toString(), sbrJueves.getSelectedItem().toString(), sbrViernes.getSelectedItem().toString(), sbrSabado.getSelectedItem().toString(), sbrDomingo.getSelectedItem().toString());

                    if(correcto){
                        Toast.makeText(EditarHActivity.this, "REGISTRO MODIFICADO", Toast.LENGTH_SHORT).show();
                        lista();
                    } else {
                        Toast.makeText(EditarHActivity.this, "ERROR AL MODIFICAR REGISTRO", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(EditarHActivity.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_SHORT).show();
                }
            }
        });

        fabEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditarHActivity.this);
                builder.setMessage("¿Desea eliminar este registro?")
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if(dbPlanificador.eliminarHorario(id)){
                                    lista();
                                }
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();
            }
        });

    }

    private void verRegistro(){
        Intent intent = new Intent(this, VerHActivity.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @SuppressLint("Range")
    private List<Actividades> llenarCategorias(){
        List<Actividades> listaCat = new ArrayList<>();
        DbPlanificador dbCategorias = new DbPlanificador(EditarHActivity.this);
        Cursor cursor = dbCategorias.mostarNombres();
        if(cursor != null){
            if(cursor.moveToFirst()){
                do{
                    Actividades cat = new Actividades();
                    cat.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
                    listaCat.add(cat);
                } while (cursor.moveToNext());
            }
        }
        dbCategorias.close();

        return listaCat;
    }

    private void lista(){
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
    }
}
