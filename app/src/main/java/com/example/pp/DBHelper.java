package com.example.pp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "pirulapolc.db";
    private static final int version = 1;
    public DBHelper(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Create_Profil_Table = "CREATE TABLE IF NOT EXISTS Profil(" +
                "profilID INTEGER NOT NULL UNIQUE," +
                "vezeteknev TEXT," +
                "keresztnev TEXT," +
                "szuldatum TEXT," +
                "TAJ INTEGER," +
                "PRIMARY KEY(profilID AUTOINCREMENT));";
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
}

/*public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "myDatabase.db";
    public static final int DATABASE_VERSION = 1;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // itt adhatjuk meg az SQL parancsokat az adatbázis tábláinak létrehozásához
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // itt adhatjuk meg az SQL parancsokat az adatbázis tábláinak frissítéséhez
    }
}
