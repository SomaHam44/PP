package com.example.pp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "pirulapolc2.db";
    private static final int version = 1;

    private static final String TABLE_PROFIL = "Profil";
    private static final String P_ID = "profilID";
    private static final String P_NEV = "nev";
    private static final String P_DATUM = "szuldatum";
    private static final String P_TAJ = "TAJ";

    private static final String TABLE_GYOGYSZEREK="Gyogyszer";
    private static final String GY_ID="gyogyszerID";
    private static final String GY_NEV = "gyogyszerNev";
    private static final String GY_HATOANYAG = "gyogyszerHatoanyag";
    private static final String GY_LINK = "gyogyszerLink";
    private static final String GY_LEJARAT = "lejarat";
    private static final String GY_RENDSZERES = "rendszeres";
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
        String Create_Gyogyszerek_Table = "CREATE TABLE IF NOT EXISTS " + TABLE_GYOGYSZEREK+ "("
                + GY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + GY_NEV +" TEXT,"
                + GY_HATOANYAG +" TEXT,"
                + GY_LINK +" TEXT,"
                + GY_NAPI +" INTEGER,"
                + GY_KESZLET +" INTEGER);";
        //+ GY_RENDSZERES +" BOOLEAN, "
        //+ GY_MOD +" TEXT

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
    public Cursor legfrissebbId(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT MAX("+P_ID+") FROM "+ TABLE_PROFIL+"", null);
    }

    public boolean gyogyszerHozzaadas(String nev, String hatoanyag, String link, int napi, int keszlet){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(GY_NEV, nev);
        values.put(GY_HATOANYAG, hatoanyag);
        values.put(GY_LINK, link);
        //values.put(GY_RENDSZERES, rendszeres);
        values.put(GY_NAPI, napi);
        values.put(GY_KESZLET, keszlet);
        //values.put(GY_MOD, modDatum);
        return db.insert(TABLE_GYOGYSZEREK, null, values) != -1;
    }

    public boolean gyogyszerModositas(int id, String nev, String hatoanyag, String link, int napi, int keszlet){
        SQLiteDatabase db = this.getWritableDatabase();
        //Date modDatum= new Date();
        //SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //modStrDatum = formatter.format(modDatum);
        ContentValues values = new ContentValues();
        values.put(GY_NEV, nev);
        values.put(GY_HATOANYAG, hatoanyag);
        values.put(GY_LINK, link);
        //values.put(GY_RENDSZERES, rendszeres);
        values.put(GY_NAPI, napi);
        values.put(GY_KESZLET, keszlet);
        /*if(keszlet == utolsoKeszlet){
            values.put(GY_MOD, modStrDatum);
        }
        else{
            values.put(GY_MOD,utolsoMod);
        }*/
        return db.update(TABLE_GYOGYSZEREK, values, GY_ID+"=?", new String[]{String.valueOf(id)}) >0;
    }
    public Cursor listazas() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery(" SELECT * FROM " + TABLE_GYOGYSZEREK, null);
    }

    public void torles(int id){
        String DELETE_ROW = "DELETE FROM " + TABLE_GYOGYSZEREK + " WHERE " + GY_ID + " = " + id;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(DELETE_ROW);
        db.close();
    }

   public Cursor utolsoModLekerdezes(){
       SQLiteDatabase db = this.getReadableDatabase();
       return db.rawQuery(" SELECT GY_MOD FROM " + TABLE_GYOGYSZEREK, null);
   }
    public Cursor keszletLekerdezes(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(" SELECT GY_KESZLET FROM " + TABLE_GYOGYSZEREK, null);
    }

    /*public Cursor IDlistaLekerdezes(){

    }*/
    public boolean keszletModositas(int id, int ujKeszlet){
        SQLiteDatabase db = this.getWritableDatabase();
        //Date modDatum= new Date();
        //SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //String modStrDatum = formatter.format(modDatum);
        ContentValues values = new ContentValues();
        values.put(GY_KESZLET, ujKeszlet);
        return db.update(TABLE_GYOGYSZEREK, values, GY_ID+"=?", new String[]{String.valueOf(id)}) >0;

    }
}

