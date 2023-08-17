package com.martintecno.traductor;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Modelo.Palabra;

public class ActivityResultadoViewModel extends AndroidViewModel {

    private Context context;

    Palabra[] diccionario = new Palabra[3];




    private MutableLiveData<Palabra> palabraTraducidaM;

    public ActivityResultadoViewModel(@NonNull Application application) {
        super(application);

        this.context = application.getApplicationContext();



        diccionario[0] = new Palabra("casa","home",R.drawable.casa);
        diccionario[1] = new Palabra("auto","car",R.drawable.auto);
        diccionario[2] = new Palabra("avion","plane",R.drawable.avion);



    }

    public LiveData<Palabra> getPalabraM(){
        if(palabraTraducidaM == null){
            palabraTraducidaM = new MutableLiveData<Palabra>();
        }
        return palabraTraducidaM;
    }



    public void traducirPalabra(String palabra) {


        for(Palabra p : diccionario){
            if(p.getPalabra().equals(palabra)){
                palabraTraducidaM.setValue(p);


            }
        }




    }




}
