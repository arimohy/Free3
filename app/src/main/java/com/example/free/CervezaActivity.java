package com.example.free;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class CervezaActivity extends AppCompatActivity implements CervezaFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerveza);
    }

    @Override
    public void onListFragmentInteraction(cCerverza item) {

    }
}
