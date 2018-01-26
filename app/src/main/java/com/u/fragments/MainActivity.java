package com.u.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.u.fragments.Fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();

    }
}
