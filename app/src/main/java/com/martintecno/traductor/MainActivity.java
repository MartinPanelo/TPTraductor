package com.martintecno.traductor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.martintecno.traductor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel VmMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.TVTitulo.setText("Ingrese una palabra para traducir");
        VmMain = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        binding.BTNBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VmMain.ValidarPalabra( binding.TVPalabra.getText().toString());

            }
        });
    }
}