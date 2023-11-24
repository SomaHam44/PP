package com.example.pp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String profileName;

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
                loadFragment(FooldalFragment.newInstance(profileName), "fooldal");
                //showMessage("Főoldal");
                return true;
            case R.id.action_profil:
                loadFragment(ProfilFragment.newInstance(profileName), "profil");
                //showMessage("Profil");
                return true;
            case R.id.action_beallitasok:
                showMessage("Beállítások");
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
        profileName = name;
        loadFragment(FooldalFragment.newInstance(profileName), "fooldal");
    }
    public void profileCancel() {
        loadFragment(FooldalFragment.newInstance(profileName), "fooldal");
    }


}