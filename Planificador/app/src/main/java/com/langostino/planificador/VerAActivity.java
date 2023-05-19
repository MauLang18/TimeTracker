package com.langostino.planificador;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.langostino.planificador.db.DbPlanificador;
import com.langostino.planificador.entidades.Actividades;
import com.langostino.planificador.entidades.Planes;

public class VerAActivity extends AppCompatActivity {

    EditText txtNombre, txtProfesor, txtCantidad, txtDetalles, txtSalon;
    FloatingActionButton fabEditar, fabEliminar;
    Button btnGuarda;

    Actividades planes;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_aactivity);
        txtNombre = findViewById(R.id.txtNombre);
        txtProfesor = findViewById(R.id.txtProfesor);
        txtCantidad = findViewById(R.id.txtCantidad);
        txtDetalles = findViewById(R.id.txtDetalles);
        txtSalon = findViewById(R.id.txtSalon);
        fabEditar = findViewById(R.id.fabEditar);
        fabEliminar = findViewById(R.id.fabEliminar);
        btnGuarda = findViewById(R.id.btnGuarda);
        btnGuarda.setVisibility(View.INVISIBLE);

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

        final DbPlanificador dbPlanificador = new DbPlanificador(VerAActivity.this);
        planes = dbPlanificador.verActividades(id);

        if(planes != null){
            txtNombre.setText(planes.getNombre());
            txtProfesor.setText(planes.getProfesor());
            txtCantidad.setText(planes.getCantidad());
            txtDetalles.setText(planes.getDetalle());
            txtSalon.setText(planes.getSalon());
            txtNombre.setInputType(InputType.TYPE_NULL);
            txtProfesor.setInputType(InputType.TYPE_NULL);
            txtCantidad.setInputType(InputType.TYPE_NULL);
            txtDetalles.setInputType(InputType.TYPE_NULL);
            txtSalon.setInputType(InputType.TYPE_NULL);
        }

        fabEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VerAActivity.this, EditarAActivity.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });

        fabEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(VerAActivity.this);
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

    private void lista(){
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
    }
}