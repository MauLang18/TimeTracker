package com.langostino.planificador;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.langostino.planificador.db.DbPlanificador;

public class NuevoA2Activity extends Activity {

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

                    DbPlanificador dbPlanificador = new DbPlanificador(NuevoA2Activity.this);
                    long id = dbPlanificador.ingresarActividades(txtNombre.getText().toString(), txtProfesor.getText().toString(), txtSalon.getText().toString(), txtCantidad.getText().toString(), txtDetalles.getText().toString());

                    if (id > 0) {
                        Toast.makeText(NuevoA2Activity.this, "GUARDADO", Toast.LENGTH_SHORT).show();
                        limpiar();
                        horario();
                    } else {
                        Toast.makeText(NuevoA2Activity.this, "ERROR AL GUARDAR", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(NuevoA2Activity.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_SHORT).show();
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

    private void horario(){
        Intent intent = new Intent(NuevoA2Activity.this, NuevoHActivity.class);
        startActivity(intent);
    }
}