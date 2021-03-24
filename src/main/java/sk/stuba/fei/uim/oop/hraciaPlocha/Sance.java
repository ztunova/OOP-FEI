package sk.stuba.fei.uim.oop.hraciaPlocha;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.karty.Karty;

import java.util.ArrayList;

public class Sance extends Policko {
    String akcia;
    ArrayList<Karty> tahaciBalicek;
    ArrayList<Karty> odhadzovaciBalicek;

    @Override
    public void akciaPolicka() {
    }

    public void zamiesajKarty(){}

    public Sance(int poradoveCislo, String meno, String popis, ArrayList<Karty> balicek) {
        super(poradoveCislo, meno, popis);
        this.odhadzovaciBalicek= balicek;
    }

    public Sance(int poradoveCislo, String meno, String popis) {
        super(poradoveCislo, meno, popis);
    }

    public Sance(){}
}
