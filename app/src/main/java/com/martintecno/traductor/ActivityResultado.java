package com.martintecno.traductor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.martintecno.traductor.databinding.ActivityResultadoBinding;

import Modelo.Palabra;


public class ActivityResultado extends AppCompatActivity {

    private ActivityResultadoViewModel vmResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActivityResultadoBinding binding = ActivityResultadoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vmResultado = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ActivityResultadoViewModel.class);

        vmResultado.getPalabraM().observe(this, new Observer<Palabra>() {
            @Override
            public void onChanged(Palabra palabraI) {

                binding.TVResultado.setText(palabraI.getTraduccion());
                binding.IMGImagen.setImageResource(palabraI.getFoto());

            }
        });

        Intent intent = getIntent();
        vmResultado.traducirPalabra((String) intent.getStringExtra("palabra"));



    }
}