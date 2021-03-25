package sk.stuba.fei.uim.oop.hraciaPlocha;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.karty.Karty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Sance extends Policko {
    String akcia;
    ArrayList<Karty> tahaciBalicek;
    ArrayList<Karty> odhadzovaciBalicek;

    @Override
    public void akciaPolicka() {
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
        int i;
        tahaciBalicek.addAll(odhadzovaciBalicek);
        odhadzovaciBalicek.clear();
        Collections.shuffle(tahaciBalicek, new Random());
    }

    public Sance(int poradoveCislo, String meno, String popis, ArrayList<Karty> balicek, ArrayList<Karty> tahaci) {
        super(poradoveCislo, meno, popis);
        this.odhadzovaciBalicek= balicek;
        this.tahaciBalicek= tahaci;
    }

    public Sance(int poradoveCislo, String meno, String popis) {
        super(poradoveCislo, meno, popis);
    }

    public Sance(){}
}
