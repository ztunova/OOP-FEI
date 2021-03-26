package sk.stuba.fei.uim.oop.hraciaPlocha;

import sk.stuba.fei.uim.oop.hra.Hrac;

public abstract class Policko {
    protected int poradoveCislo;
    protected Hrac stojiTam;
    protected String meno;

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
