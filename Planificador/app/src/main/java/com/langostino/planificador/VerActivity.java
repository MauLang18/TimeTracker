package com.langostino.planificador;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.WorkManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.langostino.planificador.db.DbPlanificador;
import com.langostino.planificador.entidades.Planes;

public class VerActivity extends AppCompatActivity {

    EditText txtTitulo, txtDia, txtHora, txtDetalles, txtLugar;
    FloatingActionButton fabEditar, fabEliminar;
    Button btnGuarda;

    Planes planes;
    int id = 0;

    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);
        txtTitulo = findViewById(R.id.txtTitulo);
        txtDia = findViewById(R.id.txtDia);
        txtHora = findViewById(R.id.txtHora);
        txtDetalles = findViewById(R.id.txtDetalles);
        txtLugar = findViewById(R.id.txtLugar);
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

        System.out.println(id);

        final DbPlanificador dbPlanificador = new DbPlanificador(VerActivity.this);
        planes = dbPlanificador.verContacto(id);

        if(planes != null){
            txtTitulo.setText(planes.getTitulo());
            txtDia.setText(planes.getDia());
            txtHora.setText(planes.getHora());
            txtDetalles.setText(planes.getDetalles());
            txtLugar.setText(planes.getLugar());
            txtTitulo.setInputType(InputType.TYPE_NULL);
            txtDia.setInputType(InputType.TYPE_NULL);
            txtHora.setInputType(InputType.TYPE_NULL);
            txtDetalles.setInputType(InputType.TYPE_NULL);
            txtLugar.setInputType(InputType.TYPE_NULL);
        }

        fabEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VerActivity.this, EditarActivity.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });

        fabEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(VerActivity.this);
                builder.setMessage("¿Desea eliminar este registro?")
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if(dbPlanificador.eliminarPlanes(id)){
                                    String str = Integer.toString(id);
                                    eliminarAlarma(str);
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

    private void eliminarAlarma(String tag){
        WorkManager.getInstance(this).cancelAllWorkByTag(tag);
        Toast.makeText(VerActivity.this, "Eliminado", Toast.LENGTH_LONG).show();
    }
}