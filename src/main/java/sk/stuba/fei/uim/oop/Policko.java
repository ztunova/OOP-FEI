package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

abstract class Policko {
    int poradoveCislo;
    ArrayList<Hrac> stojaTam;
    String meno;
    String popis;

    public abstract void akciaPolicka();

    public Policko(int poradoveCislo, String meno, String popis) {
        this.poradoveCislo = poradoveCislo;
        this.stojaTam= new ArrayList<Hrac>();
        this.meno = meno;
        this.popis= popis;
    }

    public Policko(){
        this.stojaTam= new ArrayList<Hrac>();
    }
}
