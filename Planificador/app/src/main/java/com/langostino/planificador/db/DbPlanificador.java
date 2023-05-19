package com.langostino.planificador.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.langostino.planificador.entidades.Actividades;
import com.langostino.planificador.entidades.Horarios;
import com.langostino.planificador.entidades.Planes;

import java.util.ArrayList;

public class DbPlanificador extends DbHelper2{

    Context context;

    public DbPlanificador(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long ingresarPlan(String titulo, String dia, String hora, String detalles, String lugar){
        long id = 0;

        try{
            DbHelper2 dbHelper = new DbHelper2(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("titulo", titulo);
            values.put("dia", dia);
            values.put("hora", hora);
            values.put("detalles", detalles);
            values.put("lugar", lugar);

            id = db.insert(TABLE_NAME, null, values);
        }catch (Exception ex){
            ex.toString();
        }

        return id;
    }
    public ArrayList<Planes> mostrarPlanes() {

        DbHelper2 dbHelper = new DbHelper2(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Planes> listaPlanes = new ArrayList<>();
        Planes planes;
        Cursor cursorPlanes;

        cursorPlanes = db.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY titulo ASC", null);

        if (cursorPlanes.moveToFirst()) {
            do {
                planes = new Planes();
                planes.setId(cursorPlanes.getInt(0));
                planes.setTitulo(cursorPlanes.getString(1));
                planes.setDia(cursorPlanes.getString(2));
                planes.setHora(cursorPlanes.getString(3));
                planes.setDetalles(cursorPlanes.getString(4));
                planes.setLugar(cursorPlanes.getString(5));
                listaPlanes.add(planes);
            } while (cursorPlanes.moveToNext());
        }

        cursorPlanes.close();

        return listaPlanes;
    }

    public Planes verContacto(int id) {

        DbHelper2 dbHelper = new DbHelper2(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Planes planes = null;
        Cursor cursorPlanes;

        cursorPlanes = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = " + id + " LIMIT 1", null);

        if (cursorPlanes.moveToFirst()) {
            planes = new Planes();
            planes.setId(cursorPlanes.getInt(0));
            planes.setTitulo(cursorPlanes.getString(1));
            planes.setDia(cursorPlanes.getString(2));
            planes.setHora(cursorPlanes.getString(3));
            planes.setDetalles(cursorPlanes.getString(4));
            planes.setLugar(cursorPlanes.getString(5));
        }

        cursorPlanes.close();

        return planes;
    }

    public boolean editarPlanes(int id, String titulo, String dia, String hora, String detalles, String lugar) {

        boolean correcto = false;

        DbHelper2 dbHelper = new DbHelper2(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("UPDATE " + TABLE_NAME + " SET titulo = '" + titulo + "', dia = '" + dia + "', hora = '" + hora + "', detalles = '" + detalles +"', lugar = '" + lugar + "' WHERE id='" + id + "' ");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }

    public boolean eliminarPlanes(int id) {

        boolean correcto = false;

        DbHelper2 dbHelper = new DbHelper2(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE id = '" + id + "'");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }

    public Planes verId(String fecha, String hora){
        DbHelper2 dbHelper = new DbHelper2(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Planes planes = null;
        Cursor cursorPlanes;

        cursorPlanes = db.rawQuery("SELECT id FROM " + TABLE_NAME + " WHERE dia = '" + fecha + "' AND hora = '" + hora + "'  LIMIT 1", null);

        if (cursorPlanes.moveToFirst()) {
            planes = new Planes();
            planes.setId(cursorPlanes.getInt(0));
        }

        cursorPlanes.close();

        return planes;
    }

    //HORARIO

    public long ingresarHorario(String hora,String lunes, String martes, String miercoles, String jueves, String viernes, String sabado, String domingo){
        long id = 0;

        try{
            DbHelper2 dbHelper = new DbHelper2(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put("hora", hora);
            values.put("lunes", lunes);
            values.put("martes", martes);
            values.put("miercoles", miercoles);
            values.put("jueves", jueves);
            values.put("sabado", sabado);
            values.put("domingo", domingo);
            values.put("viernes", viernes);

            id = db.insert(TABLE_2, null, values);
        }catch (Exception ex){
            ex.toString();
        }

        return id;
    }
    public ArrayList<Horarios> mostrarHorario() {

        DbHelper2 dbHelper = new DbHelper2(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Horarios> listaHorario = new ArrayList<>();
        Horarios horarios;
        Cursor cursorHorario;

        cursorHorario = db.rawQuery("SELECT * FROM " + TABLE_2 + " ORDER BY hora ASC", null);

        if (cursorHorario.moveToFirst()) {
            do {
                horarios = new Horarios();
                horarios.setId(cursorHorario.getInt(0));
                horarios.setHora(cursorHorario.getString(1));
                horarios.setLunes(cursorHorario.getString(2));
                horarios.setMartes(cursorHorario.getString(3));
                horarios.setMiercoles(cursorHorario.getString(4));
                horarios.setJueves(cursorHorario.getString(5));
                horarios.setViernes(cursorHorario.getString(6));
                horarios.setSabado(cursorHorario.getString(7));
                horarios.setDomingo(cursorHorario.getString(8));
                listaHorario.add(horarios);
            } while (cursorHorario.moveToNext());
        }

        cursorHorario.close();

        return listaHorario;
    }

    public Horarios verHorarios(int id) {

        DbHelper2 dbHelper = new DbHelper2(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Horarios horarios = null;
        Cursor cursorHorario;

        cursorHorario = db.rawQuery("SELECT * FROM " + TABLE_2 + " WHERE id = " + id + " LIMIT 1", null);

        if (cursorHorario.moveToFirst()) {

            horarios = new Horarios();
            horarios.setId(cursorHorario.getInt(0));
            horarios.setHora(cursorHorario.getString(1));
            horarios.setLunes(cursorHorario.getString(2));
            horarios.setMartes(cursorHorario.getString(3));
            horarios.setMiercoles(cursorHorario.getString(4));
            horarios.setJueves(cursorHorario.getString(5));
            horarios.setViernes(cursorHorario.getString(6));
            horarios.setSabado(cursorHorario.getString(7));
            horarios.setDomingo(cursorHorario.getString(8));
        }

        cursorHorario.close();

        return horarios;
    }

    public boolean editarHorario(int id, String hora, String lunes, String martes, String miercoles, String jueves, String viernes, String sabado, String domingo) {

        boolean correcto = false;

        DbHelper2 dbHelper = new DbHelper2(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("UPDATE " + TABLE_2 + " SET hora = '" + hora + "', lunes = '" + lunes + "', martes = '" + martes + "', miercoles = '" + miercoles +"', jueves = '" + jueves + "', viernes = '" + viernes + "', sabado = '" + sabado + "', domingo = '" + domingo + "' WHERE id='" + id + "' ");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }

    public boolean eliminarHorario(int id) {

        boolean correcto = false;

        DbHelper2 dbHelper = new DbHelper2(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM " + TABLE_2 + " WHERE id = '" + id + "'");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }

    public Horarios verId2(String fecha, String hora){
        DbHelper2 dbHelper = new DbHelper2(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Horarios planes = null;
        Cursor cursorPlanes;

        cursorPlanes = db.rawQuery("SELECT id FROM " + TABLE_2 + " WHERE dia = '" + fecha + "' AND hora = '" + hora + "'  LIMIT 1", null);

        if (cursorPlanes.moveToFirst()) {
            planes = new Horarios();
            planes.setId(cursorPlanes.getInt(0));
        }

        cursorPlanes.close();

        return planes;
    }

    //ACTIVIDADES

    public long ingresarActividades(String nombre,String profesor, String salon, String cantidad, String detalle){
        long id = 0;

        try{
            DbHelper2 dbHelper = new DbHelper2(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put("nombre", nombre);
            values.put("profesor", profesor);
            values.put("salon", salon);
            values.put("cantidad", cantidad);
            values.put("detalle", detalle);

            id = db.insert(TABLE_3, null, values);
        }catch (Exception ex){
            ex.toString();
        }

        return id;
    }
    public ArrayList<Actividades> mostrarActividades() {

        DbHelper2 dbHelper = new DbHelper2(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Actividades> listaActividades = new ArrayList<>();
        Actividades actividades;
        Cursor cursorActividades;

        cursorActividades = db.rawQuery("SELECT * FROM " + TABLE_3 + " ORDER BY nombre ASC", null);

        if (cursorActividades.moveToFirst()) {
            do {
                actividades = new Actividades();
                actividades.setId(cursorActividades.getInt(0));
                actividades.setNombre(cursorActividades.getString(1));
                actividades.setProfesor(cursorActividades.getString(2));
                actividades.setSalon(cursorActividades.getString(3));
                actividades.setCantidad(cursorActividades.getString(4));
                actividades.setDetalle(cursorActividades.getString(5));
                listaActividades.add(actividades);
            } while (cursorActividades.moveToNext());
        }

        cursorActividades.close();

        return listaActividades;
    }

    public Actividades verActividades(int id) {

        DbHelper2 dbHelper = new DbHelper2(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Actividades actividades = null;
        Cursor cursorActividades;

        cursorActividades = db.rawQuery("SELECT * FROM " + TABLE_3 + " WHERE id = " + id + " LIMIT 1", null);

        if (cursorActividades.moveToFirst()) {

            actividades = new Actividades();
            actividades.setId(cursorActividades.getInt(0));
            actividades.setNombre(cursorActividades.getString(1));
            actividades.setProfesor(cursorActividades.getString(2));
            actividades.setSalon(cursorActividades.getString(3));
            actividades.setCantidad(cursorActividades.getString(4));
            actividades.setDetalle(cursorActividades.getString(5));
        }

        cursorActividades.close();

        return actividades;
    }

    public boolean editarActividades(int id, String nombre, String profesor, String salon, String cantidad, String detalle) {

        boolean correcto = false;

        DbHelper2 dbHelper = new DbHelper2(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("UPDATE " + TABLE_3 + " SET nombre = '" + nombre + "', profesor = '" + profesor + "', salon = '" + salon + "', cantidad = '" + cantidad +"', detalle = '" + detalle + "' WHERE id= '" + id + "' ");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }

    public boolean eliminarActividades(int id) {

        boolean correcto = false;

        DbHelper2 dbHelper = new DbHelper2(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM " + TABLE_3 + " WHERE id = '" + id + "'");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }

    public Horarios verId3(String fecha, String hora){
        DbHelper2 dbHelper = new DbHelper2(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Horarios planes = null;
        Cursor cursorPlanes;

        cursorPlanes = db.rawQuery("SELECT id FROM " + TABLE_3 + " WHERE dia = '" + fecha + "' AND hora = '" + hora + "'  LIMIT 1", null);

        if (cursorPlanes.moveToFirst()) {
            planes = new Horarios();
            planes.setId(cursorPlanes.getInt(0));
        }

        cursorPlanes.close();

        return planes;
    }

    public Cursor mostarNombres() {
        try {
            SQLiteDatabase bd = this.getReadableDatabase();
            Cursor filas = bd.rawQuery("SELECT nombre FROM " + TABLE_3 + " ORDER BY nombre ASC", null);
            if (filas.moveToFirst()) {
                return filas;
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }
}
