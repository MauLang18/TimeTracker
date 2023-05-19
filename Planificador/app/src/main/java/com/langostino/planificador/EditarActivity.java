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
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Data;
import androidx.work.WorkManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.langostino.planificador.alarmas.WorkManagerNoti;
import com.langostino.planificador.db.DbPlanificador;
import com.langostino.planificador.entidades.Planes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EditarActivity extends AppCompatActivity {
    EditText txtTitulo, txtDia, txtHora, txtDetalles, txtLugar;
    FloatingActionButton fabEditar, fabEliminar;
    Button btnGuarda, btnHora, btnFecha;
    boolean correcto = false;
    Planes planes;
    int id = 0;
    private int alarmID = 1;
    SharedPreferences settings;

    Calendar actual = Calendar.getInstance();
    Calendar calendar = Calendar.getInstance();
    private int minutos,hora,dia,mes,anio;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        settings = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);

        String hour, minute;

        hour = settings.getString("hour","");
        minute = settings.getString("minute","");

        txtTitulo = findViewById(R.id.txtTitulo);
        txtDia = findViewById(R.id.txtDia);
        txtDia.setInputType(InputType.TYPE_NULL);
        txtDia.setText("");
        txtHora = findViewById(R.id.txtHora);
        txtHora.setInputType(InputType.TYPE_NULL);
        txtHora.setText("");
        txtDetalles = findViewById(R.id.txtDetalles);
        txtLugar = findViewById(R.id.txtLugar);
        btnGuarda = findViewById(R.id.btnGuarda);
        fabEditar = findViewById(R.id.fabEditar);
        fabEditar.setVisibility(View.INVISIBLE);
        fabEliminar = findViewById(R.id.fabEliminar);
        btnHora = findViewById(R.id.btnHora);
        btnFecha = findViewById(R.id.btnFecha);

        if(hour.length() > 0)
        {
            txtHora.setText(hour + ":" + minute);
        }

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

        final DbPlanificador dbPlanificador = new DbPlanificador(EditarActivity.this);
        planes = dbPlanificador.verContacto(id);

        if (planes != null) {
            txtTitulo.setText(planes.getTitulo());
            txtDetalles.setText(planes.getDetalles());
            txtDia.setText(planes.getDia());
            txtHora.setText(planes.getHora());
            txtLugar.setText(planes.getLugar());
        }

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtTitulo.getText().toString().equals("") && !txtDetalles.getText().toString().equals("")) {
                    correcto = dbPlanificador.editarPlanes(id, txtTitulo.getText().toString(), txtDia.getText().toString(), txtHora.getText().toString(), txtDetalles.getText().toString(), txtLugar.getText().toString());

                    String tag = Integer.toString(planes.getId());
                    long AlertTime = calendar.getTimeInMillis() - System.currentTimeMillis();
                    int random = (int)(Math.random() * 50 + 1);

                    String t = txtTitulo.getText().toString();
                    String d = txtDetalles.getText().toString();

                    if(correcto){
                        Toast.makeText(EditarActivity.this, "REGISTRO MODIFICADO", Toast.LENGTH_SHORT).show();
                        eliminarAlarma(tag);
                        Data data = GuardarData(t, d, random);
                        WorkManagerNoti.GuardarNoti(AlertTime,data,tag);
                        Toast.makeText(EditarActivity.this, "ALARMA MODIFICADA", Toast.LENGTH_SHORT).show();
                        lista();
                    } else {
                        Toast.makeText(EditarActivity.this, "ERROR AL MODIFICAR REGISTRO", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(EditarActivity.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hora = actual.get(Calendar.HOUR_OF_DAY);
                minutos = actual.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(view.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int h, int m) {
                        calendar.set(Calendar.HOUR_OF_DAY,h);
                        calendar.set(Calendar.MINUTE,m);

                        txtHora.setText(String.format("%02d:%02d",h,m));
                    }
                },hora,minutos, true);
                timePickerDialog.show();
            }
        });

        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anio = actual.get(calendar.YEAR);
                mes = actual.get(calendar.MONTH);
                dia = actual.get(calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int y, int m, int d) {
                        calendar.set(Calendar.DAY_OF_MONTH,d);
                        calendar.set(Calendar.MONTH,m);
                        calendar.set(Calendar.YEAR,y);

                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        String strDate = format.format(calendar.getTime());
                        txtDia.setText(strDate);
                    }
                },anio,mes,dia);
                datePickerDialog.show();
            }
        });

        fabEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditarActivity.this);
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

    private void verRegistro(){
        Intent intent = new Intent(this, VerActivity.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }

    private Data GuardarData(String t, String d, int id_noti){

        return new Data.Builder()
                .putString("titulo", t)
                .putString("detalles", d)
                .putInt("id_noti", id_noti).build();
    }

    private void lista(){
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
    }

    private void eliminarAlarma(String tag){
        WorkManager.getInstance(this).cancelAllWorkByTag(tag);
    }

}
