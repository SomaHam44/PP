package com.example.pp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "pirulapolc.db";
    private static final int version = 1;

    private static final String TABLE_NAME = "Profil";

    private static final String COL_ID = "profilID";
    private static final String COL_NEV = "nev";

    private static final String COL_DATUM = "szuldatum";

    private static final String COL_TAJ = "TAJ";



    public DBHelper(Context context) {
        super(context, DB_NAME, null, version);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Create_Profil_Table = "CREATE TABLE IF NOT EXISTS Profil(" +
                "profilID INTEGER NOT NULL DEFAULT 1," +
                "nev TEXT," +
                "szuldatum TEXT," +
                "TAJ INTEGER," +
                "PRIMARY KEY(profilID));";
        String Create_Gyogyszerek_Table = "CREATE TABLE IF NOT EXISTS Gyogyszerek (" +
                "gyogyszerID INTEGER NOT NULL," +
                "gyogyszerNev TEXT," +
                "lejarat TEXT," +
                "keszlet INTEGER," +
                "utolsomod TEXT," +
                "PRIMARY KEY(gyogyszerID AUTOINCREMENT)" +
                ");";

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean profilModositas(int Id, String nev, String datum, Integer taj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NEV, nev);
        values.put(COL_DATUM, datum);
        values.put(COL_TAJ, taj);
        return db.update(TABLE_NAME, values, "Id = ?", new String[]{Integer.toString(Id)})> 0;
    }


}

