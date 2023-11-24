package com.example.pp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar foToolbar = findViewById(R.id.fo_toolbar);
        setSupportActionBar(foToolbar);

        loadFragment(new FooldalFragment(), "fooldal");

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
                loadFragment(FooldalFragment.newInstance(), "fooldal");
                showMessage("Főoldal");
                return true;
            case R.id.action_beallitasok:
                loadFragment(BeallitasokFragment.newInstance(), "beallitasok");
                showMessage("Beállítások");
                return true;
            case R.id.action_gyogyszereim:
                loadFragment(GyogyszereimFragment.newInstance(), "gyogyszereim");
                showMessage("Gyógyszereim");
                return true;
            case R.id.action_figyelmeztetesek:
                loadFragment(FigyelmeztetesekFragment.newInstance(), "figyelmeztetesek");
                showMessage("Figyelmeztetések");
                return true;
            case R.id.action_vasarlasRogzitese:
                loadFragment(VasarlasRogziteseFragment.newInstance(), "vasarlasRogzitese");
                showMessage("Vásárlás rögzítése");
                return true;
            case R.id.action_gyogyszerHozzaad:
                loadFragment(GyogyszerHozzaadasaFragment.newInstance(), "gyogyszerHozzaad");
                showMessage("Gyógyszer hozzáadása");
                return true;
            case R.id.action_gyogyszertarKeres:
                loadFragment(GyogyszertarKeresFragment.newInstance(), "gyogyszertarKeres");
                showMessage("Gyógyszertár keresése");
                return true;




        }
        return true;
    }

    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    private void loadFragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, tag);
        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();
    }

    public void profileSave(String name) {
        loadFragment(FooldalFragment.newInstance(), "fooldal");
    }
    public void profileCancel() {
        loadFragment(FooldalFragment.newInstance(), "fooldal");
    }


}