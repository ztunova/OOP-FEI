package sk.stuba.fei.uim.oop.hraciaPlocha;

import sk.stuba.fei.uim.oop.hra.Hrac;

/*
abstraktna trieda z ktorej dedia ostatne druhy policok
 */

public abstract class Policko {
    protected int poradoveCislo;
    protected Hrac stojiTam;
    protected String meno;

/*
abstraktna metoda ktoru musia implementovat vsetky odvodene triedy - vykonava efekt policka jednotlivych policok
 */
    public abstract void akciaPolicka();

    public String getMeno() {
        return meno;
    }

    public void setStojiTam(Hrac stojiTam) {
        this.stojiTam = stojiTam;
    }

    public Policko(int poradoveCislo, String meno) {
        this.poradoveCislo = poradoveCislo;
        this.meno = meno;
    }

    public Policko(){}
}
