package sk.stuba.fei.uim.oop.hraciaPlocha;

import sk.stuba.fei.uim.oop.hra.Hrac;

public abstract class Policko {
    int poradoveCislo;
    Hrac stojiTam;
    String meno;
    String popis;

    public abstract void akciaPolicka();

    public void setStojiTam(Hrac stojiTam) {
        this.stojiTam = stojiTam;
    }

    public Policko(int poradoveCislo, String meno, String popis) {
        this.poradoveCislo = poradoveCislo;
        //this.stojaTam= new ArrayList<Hrac>();
        this.meno = meno;
        this.popis= popis;
    }

    public Policko(){/*this.stojaTam= new ArrayList<Hrac>();*/}
}
