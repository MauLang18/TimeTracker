package com.langostino.planificador;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.WorkManager;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.langostino.planificador.db.DbPlanificador;
import com.langostino.planificador.entidades.Actividades;
import com.langostino.planificador.entidades.Horarios;
import com.langostino.planificador.entidades.Planes;

import java.util.ArrayList;
import java.util.List;

public class VerHActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText txtHora, txtLunes, txtMartes, txtMiercoles, txtJueves, txtViernes, txtSabado, txtDomingo;
    Spinner sbrHora, sbrLunes, sbrMartes, sbrMiercoles, sbrJueves, sbrViernes, sbrSabado, sbrDomingo;
    FloatingActionButton fabEditar, fabEliminar;
    Button btnGuarda;

    Horarios horarios;
    int id = 0;

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
        fabEliminar = findViewById(R.id.fabEliminar);
        btnGuarda = findViewById(R.id.btnGuarda);
        btnGuarda.setVisibility(View.INVISIBLE);

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

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                id = Integer.parseInt(null);
            } else {
                id = extras.getInt("ID");
            }
        } else {
            id = (int) savedInstanceState.getSerializable("ID");
        }

        final DbPlanificador dbPlanificador = new DbPlanificador(VerHActivity.this);
        horarios = dbPlanificador.verHorarios(id);

        if(horarios != null){
            txtHora.setText(horarios.getHora());
            txtLunes.setText(horarios.getLunes());
            txtMartes.setText(horarios.getMartes());
            txtMiercoles.setText(horarios.getMiercoles());
            txtJueves.setText(horarios.getJueves());
            txtViernes.setText(horarios.getViernes());
            txtSabado.setText(horarios.getSabado());
            txtDomingo.setText(horarios.getDomingo());
            txtHora.setInputType(InputType.TYPE_NULL);
            txtLunes.setInputType(InputType.TYPE_NULL);
            txtMartes.setInputType(InputType.TYPE_NULL);
            txtMiercoles.setInputType(InputType.TYPE_NULL);
            txtJueves.setInputType(InputType.TYPE_NULL);
            txtViernes.setInputType(InputType.TYPE_NULL);
            txtSabado.setInputType(InputType.TYPE_NULL);
            txtDomingo.setInputType(InputType.TYPE_NULL);
        }

        fabEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VerHActivity.this, EditarHActivity.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });

        fabEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(VerHActivity.this);
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

    private void lista(){
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, adapterView.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @SuppressLint("Range")
    private List<Actividades> llenarCategorias(){
        List<Actividades> listaCat = new ArrayList<>();
        DbPlanificador dbCategorias = new DbPlanificador(VerHActivity.this);
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
}