package com.langostino.planificador.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper2 extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "planificadorYhorario.db";
    public static final String TABLE_NAME = "t_planificador";
    public static final String TABLE_2 = "t_horario";
    public static final String TABLE_3 = "t_agregar";

    public DbHelper2(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo TEXT NOT NULL," +
                "dia TEXT NOT NULL," +
                "hora TEXT NOT NULL," +
                "detalles TEXT NOT NULL," +
                "lugar TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_2 + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "hora TEXT NOT NULL," +
                "lunes TEXT," +
                "martes TEXT," +
                "miercoles TEXT," +
                "jueves TEXT," +
                "viernes TEXT," +
                "sabado TEXT," +
                "domingo TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_3 + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "profesor TEXT," +
                "salon TEXT," +
                "cantidad TEXT," +
                "detalle TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_2);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_3);
        onCreate(sqLiteDatabase);
    }
}
