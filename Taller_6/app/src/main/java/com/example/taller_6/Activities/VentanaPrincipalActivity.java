package com.example.taller_6.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.taller_6.Fragments.SeasonsFragment;
import com.example.taller_6.Fragments.SeriesFragment;
import com.example.taller_6.R;

public class VentanaPrincipalActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private Bundle createBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        createBundle = savedInstanceState;

        setUpFragmentManager();
        inflateLayout();
    }

    private void inflateLayout() {

        if (createBundle == null) {
            fragmentManager.beginTransaction().add(R.id.series_list, new SeriesFragment()).commit();
        }

        if(getResources().getBoolean(R.bool.has_two_panes)){
            fragmentManager.beginTransaction().add(R.id.seasons_fragment, new SeasonsFragment()).commit();
        }
    }

    private void setUpFragmentManager() {
        fragmentManager = getSupportFragmentManager();
    }


}
