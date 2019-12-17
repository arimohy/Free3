package com.example.free;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AguaActivity extends AppCompatActivity implements AguaFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agua);
    }

    @Override
    public void onListFragmentInteraction(cAgua item) {

    }
}
