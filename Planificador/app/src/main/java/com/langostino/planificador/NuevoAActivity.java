package com.langostino.planificador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Data;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.langostino.planificador.alarmas.WorkManagerNoti;
import com.langostino.planificador.db.DbPlanificador;
import com.langostino.planificador.entidades.Actividades;
import com.langostino.planificador.entidades.Planes;

import java.util.Calendar;

public class NuevoAActivity extends Activity {

    Button btnGuardar;
    EditText txtNombre, txtDetalles, txtCantidad, txtProfesor, txtSalon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_aactivity);
        txtNombre = findViewById(R.id.txtNombre);
        txtDetalles = findViewById(R.id.txtDetalles);
        txtCantidad = findViewById(R.id.txtCantidad);
        txtProfesor = findViewById(R.id.txtProfesor);
        txtSalon = findViewById(R.id.txtSalon);
        btnGuardar = findViewById(R.id.btnGuarda);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!txtNombre.getText().toString().equals("") && !txtDetalles.getText().toString().equals("")) {

                    DbPlanificador dbPlanificador = new DbPlanificador(NuevoAActivity.this);
                    long id = dbPlanificador.ingresarActividades(txtNombre.getText().toString(), txtProfesor.getText().toString(), txtSalon.getText().toString(), txtCantidad.getText().toString(), txtDetalles.getText().toString());

                    if (id > 0) {
                        Toast.makeText(NuevoAActivity.this, "GUARDADO", Toast.LENGTH_SHORT).show();
                        limpiar();
                        //horario();
                        ir();
                    } else {
                        Toast.makeText(NuevoAActivity.this, "ERROR AL GUARDAR", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(NuevoAActivity.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_SHORT).show();
                    limpiar();
                }
            }
        });
    }

    private void limpiar(){
        txtNombre.setText("");
        txtCantidad.setText("");
        txtProfesor.setText("");
        txtDetalles.setText("");
        txtSalon.setText("");
    }

    private void ir(){
        Intent intent = new Intent(NuevoAActivity.this, PrincipalActivity.class);
        startActivity(intent);
    }

    private void horario(){
        Intent intent = new Intent(NuevoAActivity.this, NuevoHActivity.class);
        startActivity(intent);
    }
}