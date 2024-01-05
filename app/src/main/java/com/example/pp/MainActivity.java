package com.example.pp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private DBHelper adatbazis;
    private Gyogyszer selectedGyogyszer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Toolbar foToolbar = findViewById(R.id.fo_toolbar);
        setSupportActionBar(foToolbar);
        loadFragment(new FooldalFragment(), "fooldal", false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_fooldal:
                loadFragment(FooldalFragment.newInstance(), "fooldal", false);
                showMessage("Főoldal");
                return true;
            case R.id.action_beallitasok:
                loadFragment(BeallitasokFragment.newInstance(), "beallitasok", false);
                showMessage("Beállítások");
                return true;
            case R.id.action_gyogyszereim:
                loadFragment(GyogyszereimFragment.newInstance(), "gyogyszereim", false);
                showMessage("Gyógyszereim");
                return true;
            case R.id.action_gyogyszerHozzaad:
                loadFragment(GyogyszerHozzaadasaFragment.newInstance(), "gyogyszerHozzaad", false);
                showMessage("Gyógyszer hozzáadása");
                return true;
            case R.id.action_gyogyszertarKeres:
                loadFragment(GyogyszertarKeresFragment.newInstance(), "gyogyszertarKeres", false);
                showMessage("Gyógyszertár keresése");
                return true;

        }
        return true;
    }
    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    private void loadFragment(Fragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, tag);
        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();
    }

    private void init() {
        adatbazis = new DBHelper(this);

    }

    public int keszletFrissites(String utolsoMod, int keszlet, int napi){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int ujkeszlet=keszlet;
        try {
            Date lastDate = dateFormat.parse(utolsoMod);
            Date currentDate = new Date();
            long differenceInMillis = currentDate.getTime() - lastDate.getTime();
            long differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24);
            int napok = (int)differenceInDays;
            ujkeszlet = keszlet-(napi*napok);
        } catch(ParseException e){
            e.printStackTrace();
        }
        return ujkeszlet;
    }

    public void keszletFrissites(){

    }

    public void navigateToDetails(Gyogyszer gyogyszer) {
        Toast.makeText(this, gyogyszer.getStringId(), Toast.LENGTH_SHORT).show();
        selectedGyogyszer = gyogyszer;
        loadFragment(GyogyszerReszletekFragment.newInstance(), "details", true);
    }
    public void navigateToGyogyszerBevetel(Gyogyszer gyogyszer) {
        Toast.makeText(this, gyogyszer.getStringId(), Toast.LENGTH_SHORT).show();
        selectedGyogyszer = gyogyszer;
        loadFragment(GyogyszerBevetelFragment.newInstance(), "details", true);
    }

    public Gyogyszer getSelectedGyogyszer() {
        return selectedGyogyszer;
    }

    public void navigateToGyogyszereim() {
        loadFragment(GyogyszereimFragment.newInstance(), "details", true);
    }
    public void navigateToGyogyszerVasarlas(Gyogyszer gyogyszer) {
        loadFragment(VasarlasRogziteseFragment.newInstance(), "details", true);
    }
    public void navigateToFooldal() {
        loadFragment(FooldalFragment.newInstance(), "details", true);
    }
    public void navigateToGyogyszerHozzaadasa() {
        loadFragment(GyogyszerHozzaadasaFragment.newInstance(), "details", true);
    }
}