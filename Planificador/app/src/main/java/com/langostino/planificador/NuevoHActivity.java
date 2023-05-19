package com.langostino.planificador;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.langostino.planificador.db.DbPlanificador;
import com.langostino.planificador.entidades.Actividades;
import com.langostino.planificador.entidades.Horarios;

import java.util.ArrayList;
import java.util.List;

public class NuevoHActivity extends Activity implements AdapterView.OnItemSelectedListener {

    Button btnGuardar, btnAct;
    EditText txtLunes, txtMartes, txtMiercoles, txtJueves, txtViernes, txtSabado, txtDomingo, txtHora;
    Spinner sbrHora, sbrLunes, sbrMartes, sbrMiercoles, sbrJueves, sbrViernes, sbrSabado, sbrDomingo;

    private Horarios horarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_hactivity);

        txtHora = findViewById(R.id.txtHora);
        txtLunes = findViewById(R.id.txtLunes);
        txtMartes = findViewById(R.id.txtMartes);
        txtMiercoles = findViewById(R.id.txtMiercoles);
        txtJueves = findViewById(R.id.txtJueves);
        txtViernes = findViewById(R.id.txtViernes);
        txtSabado = findViewById(R.id.txtSabado);
        txtDomingo = findViewById(R.id.txtDomingo);
        sbrLunes = findViewById(R.id.sbrLunes);
        sbrMartes = findViewById(R.id.sbrMartes);
        sbrMiercoles = findViewById(R.id.sbrMiercoles);
        sbrJueves = findViewById(R.id.sbrJueves);
        sbrViernes = findViewById(R.id.sbrViernes);
        sbrSabado = findViewById(R.id.sbrSabado);
        sbrDomingo = findViewById(R.id.sbrDomingo);
        btnGuardar = findViewById(R.id.btnGuarda);
        btnAct = findViewById(R.id.btnAct);

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

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hora = txtHora.getText().toString();
                String lunes = sbrLunes.getSelectedItem().toString();
                String martes = sbrMartes.getSelectedItem().toString();
                String miercoles = sbrMiercoles.getSelectedItem().toString();
                String jueves = sbrJueves.getSelectedItem().toString();
                String viernes = sbrViernes.getSelectedItem().toString();
                String sabado = sbrSabado.getSelectedItem().toString();
                String domingo = sbrDomingo.getSelectedItem().toString();

                if(!txtHora.getText().toString().equals("")) {

                    DbPlanificador dbHorario = new DbPlanificador(NuevoHActivity.this);
                    long id = dbHorario.ingresarHorario(hora,lunes,martes,miercoles,jueves,viernes,sabado,domingo);

                    if (id > 0) {
                        Toast.makeText(NuevoHActivity.this, "GUARDADO", Toast.LENGTH_SHORT).show();
                        //limpiar();
                        lista();
                    } else {
                        Toast.makeText(NuevoHActivity.this, "ERROR AL GUARDAR", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(NuevoHActivity.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_SHORT).show();
                    //limpiar();
                }
            }

        });

        btnAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NuevoHActivity.this, NuevoA2Activity.class);
                startActivity(intent);
            }
        });
    }

    private void limpiar(){
        txtHora.setText("");
    }

    private void lista(){
        Intent intent = new Intent(this, PrincipalActivity.class);
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
        DbPlanificador dbCategorias = new DbPlanificador(NuevoHActivity.this);
        Cursor cursor = dbCategorias.mostarNombres();
        if(cursor != null){
            if(cursor.moveToFirst()){
                do{
                    Actividades cat = new Actividades();
                    cat.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
                    System.out.println(cat);
                    listaCat.add(cat);
                } while (cursor.moveToNext());
            }
        }
        dbCategorias.close();

        return listaCat;
    }
}