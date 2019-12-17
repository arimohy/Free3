package com.example.free;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GasActivity extends AppCompatActivity implements GasFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas);
    }

    @Override
    public void onListFragmentInteraction(cGas item) {

    }
}
