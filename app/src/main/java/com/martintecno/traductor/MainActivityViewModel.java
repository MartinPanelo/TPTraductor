package com.martintecno.traductor;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.Arrays;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel{

    List<String> palabras = Arrays.asList("casa", "auto","avion");

    private Context context;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }

    public void ValidarPalabra(String palabra){

        if(palabras.contains(palabra)){
            Intent intent = new Intent (context,ActivityResultado.class);
            intent.putExtra("palabra", palabra);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intent);


        }else{
            Toast.makeText(context, "La palabra no existe en el diccionario", Toast.LENGTH_LONG).show();
        }

    }
}
