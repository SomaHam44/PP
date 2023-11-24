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

        loadFragmentAndAddToBackStack(new FooldalFragment(), "home");
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
                loadFragmentAndAddToBackStack(new FooldalFragment(), "home");

                //showMessage("Főoldal");
                return true;
            case R.id.action_profil:
                loadFragmentAndAddToBackStack(new ProfilFragment(), "profil");

                //showMessage("Profil");
                return true;
            case R.id.action_beallitasok:
                //showMessage("Beállítások");
                return true;
        }
        return true;
    }

    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    private void loadFragmentAndAddToBackStack(Fragment fragment, String tag) {
        loadFragment(fragment, tag, true);
    }

    private void loadFragment(Fragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, tag);
        if(addToBackStack) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();
    }

    public void profileSave(String name) {
        profileName = name;
        loadFragmentAndAddToBackStack(FooldalFragment.newInstance(profileName), "home");
    }
    public void profileCancel() {
        loadFragmentAndAddToBackStack(FooldalFragment.newInstance(profileName), "home");
    }


}