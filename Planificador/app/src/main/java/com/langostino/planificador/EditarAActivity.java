package com.langostino.planificador;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Data;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.langostino.planificador.alarmas.WorkManagerNoti;
import com.langostino.planificador.db.DbPlanificador;
import com.langostino.planificador.entidades.Actividades;
import com.langostino.planificador.entidades.Planes;

public class EditarAActivity extends AppCompatActivity {
    EditText txtNombre, txtCantidad, txtSalon, txtDetalles, txtProfesor;
    FloatingActionButton fabEditar, fabEliminar;
    Button btnGuarda, btnHora, btnFecha;
    boolean correcto = false;
    Actividades planes;
    int id = 0;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_aactivity);
        txtNombre = findViewById(R.id.txtNombre);
        txtCantidad = findViewById(R.id.txtCantidad);
        txtSalon = findViewById(R.id.txtSalon);
        txtDetalles = findViewById(R.id.txtDetalles);
        txtProfesor = findViewById(R.id.txtProfesor);
        btnGuarda = findViewById(R.id.btnGuarda);
        fabEditar = findViewById(R.id.fabEditar);
        fabEditar.setVisibility(View.INVISIBLE);
        fabEliminar = findViewById(R.id.fabEliminar);
        btnHora = findViewById(R.id.btnHora);
        btnFecha = findViewById(R.id.btnFecha);

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

        final DbPlanificador dbPlanificador = new DbPlanificador(EditarAActivity.this);
        planes = dbPlanificador.verActividades(id);

        if (planes != null) {
            txtNombre.setText(planes.getNombre());
            txtDetalles.setText(planes.getDetalle());
            txtSalon.setText(planes.getSalon());
            txtCantidad.setText(planes.getCantidad());
            txtProfesor.setText(planes.getProfesor());
        }

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtNombre.getText().toString().equals("") && !txtDetalles.getText().toString().equals("")) {
                    correcto = dbPlanificador.editarActividades(id, txtNombre.getText().toString(), txtProfesor.getText().toString(), txtSalon.getText().toString(), txtCantidad.getText().toString(), txtDetalles.getText().toString());

                    if(correcto){
                        Toast.makeText(EditarAActivity.this, "REGISTRO MODIFICADO", Toast.LENGTH_SHORT).show();
                        lista();
                    } else {
                        Toast.makeText(EditarAActivity.this, "ERROR AL MODIFICAR REGISTRO", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(EditarAActivity.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_SHORT).show();
                }
            }
        });

        fabEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditarAActivity.this);
                builder.setMessage("¿Desea eliminar este registro?")
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if(dbPlanificador.eliminarActividades(id)){
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
        Intent intent = new Intent(this, VerActivity.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }

    private void lista(){
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
    }
}
