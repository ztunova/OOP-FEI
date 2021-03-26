package sk.stuba.fei.uim.oop.hraciaPlocha;

import sk.stuba.fei.uim.oop.karty.Karty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Sance extends Policko {
    private ArrayList<Karty> tahaciBalicek;
    private ArrayList<Karty> odhadzovaciBalicek;

    @Override
    public void akciaPolicka() {
        System.out.println("Tahas si kartu");
        if(this.tahaciBalicek.isEmpty()){
            zamiesajKarty();
        }
        Karty vytiahnuta= tahaciBalicek.get(0);
        vytiahnuta.setKtoVytiahol(stojiTam);
        odhadzovaciBalicek.add(vytiahnuta);
        tahaciBalicek.remove(0);
        vytiahnuta.akciaKarty();
    }

    private void zamiesajKarty(){
        tahaciBalicek.addAll(odhadzovaciBalicek);
        odhadzovaciBalicek.clear();
        Collections.shuffle(tahaciBalicek, new Random());
    }

    public Sance(int poradoveCislo, String meno, ArrayList<Karty> balicek, ArrayList<Karty> tahaci) {
        this.poradoveCislo= poradoveCislo;
        this.meno= meno;
        this.odhadzovaciBalicek= balicek;
        this.tahaciBalicek= tahaci;
    }

    public Sance(){}
}
