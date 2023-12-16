package com.example.pp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "pirulapolc.db";
    private static final int version = 1;

    private static final String TABLE_PROFIL = "Profil";

    private static final String P_ID = "profilID";
    private static final String P_NEV = "nev";
    private static final String P_DATUM = "szuldatum";
    private static final String P_TAJ = "TAJ";

    private static final String TABLE_GYOGYSZEREK="Gyogyszerek";
    private static final String GY_ID="gyogyszerID";
    private static final String GY_NEV = "gyogyszerNev";
    private static final String GY_LEJARAT = "lejarat";
    private static final String GY_NAPI = "napi";
    private static final String GY_KESZLET = "keszlet";
    private static final String GY_MOD = "utolsomod";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Create_Profil_Table = "CREATE TABLE IF NOT EXISTS " + TABLE_PROFIL+ "("
                + P_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + P_NEV +" TEXT,"
                + P_DATUM +" TEXT,"
                + P_TAJ +" INTEGER);";
        String Create_Gyogyszerek_Table = "CREATE TABLE IF NOT EXISTS " +TABLE_GYOGYSZEREK+"("
                + GY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + GY_NEV +" TEXT NOT NULL,"
                + GY_LEJARAT +" TEXT,"
                + GY_NAPI +" INTEGER,"
                + GY_KESZLET +" INTEGER,"
                + GY_MOD +" TEXT);";
        sqLiteDatabase.execSQL(Create_Profil_Table);
        sqLiteDatabase.execSQL(Create_Gyogyszerek_Table);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean profilHozzaadas(String nev, String datum, Integer taj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(P_NEV, nev);
        values.put(P_DATUM, datum);
        values.put(P_TAJ, taj);
        return db.insert(TABLE_PROFIL, null, values)!= -1;
    }
    public Cursor profilMegjelenites(int Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(" SELECT * FROM " + TABLE_PROFIL +
                " WHERE " +  P_ID + " == ? ", new String[]{Integer.toString(Id)});
    }
    public Cursor legrissebbId(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT MAX("+P_ID+") FROM "+ TABLE_PROFIL+"", null);
    }

    public boolean gyogyszerHozzaadas(String nev, String lejarat, Integer napi, Integer keszlet, String modDatum){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(GY_NEV, nev);
        values.put(GY_LEJARAT, lejarat);
        values.put(GY_NAPI, napi);
        values.put(GY_KESZLET, keszlet);
        values.put(GY_MOD, modDatum);
        return db.insert(TABLE_GYOGYSZEREK, null, values) != -1;
    }
    public Cursor listazas() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery(" SELECT * FROM " + TABLE_GYOGYSZEREK, null);
    }

}

